package cn.yyb.driver.login.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.yyb.driver.R;
import cn.yyb.driver.framework.mvp.MVPActivity;
import cn.yyb.driver.login.contract.RegisterContract;
import cn.yyb.driver.login.presenter.RegisterPresenter;
import cn.yyb.driver.utils.StringUtils;
import cn.yyb.driver.utils.ToastUtil;
import cn.yyb.driver.utils.ToolUtils;

public class RegisterActivity extends MVPActivity<RegisterContract.IView, RegisterPresenter>
        implements RegisterContract.IView {
    @BindView(R.id.tv_title_login)
    TextView tvTitleLogin;
    @BindView(R.id.et_login_phone)
    EditText etLoginPhone;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.fist)
    LinearLayout fist;
    @BindView(R.id.bt_get_code)
    Button btGetCode;
    @BindView(R.id.tv_title_title)
    TextView tvTitleTitle;
    @BindView(R.id.et_new_pass)
    EditText etNewPass;
    @BindView(R.id.et_invite)
    EditText etInvite;

    private boolean ifTimer=false;//判断倒计时是否启用

    @Override
    protected int setLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected LinearLayout setFistLayoutId() {
        return fist;
    }

    @Override
    protected void initView() {
        tvTitleTitle.setText(getResources().getText(R.string.register));
        tvTitleLogin.setVisibility(View.GONE);
    }

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.iv_title_back2, R.id.bt_get_code, R.id.bt_login, R.id.tv_to_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_back2:
                finish();
                break;
            case R.id.bt_get_code://获取验证码
                break;
            case R.id.bt_login://注册
                String phone_login = etLoginPhone.getText().toString().trim();
                if (!StringUtils.isBlank(phone_login)) {
                    if (ToolUtils.isPhone(phone_login)) {
                    } else {
                        ToastUtil.showShortToast("请输入正确的手机号！");
                    }
                } else {
                    ToastUtil.showShortToast("请输入手机号！");
                }
                break;
            case R.id.tv_to_register://忘记密码
                break;
        }
    }

    CountDownTimer timer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            ifTimer=true;
            btGetCode.setClickable(false);
            btGetCode.setBackground(getResources().getDrawable(R.drawable.code_btn_2));
            btGetCode.setText(getResources().getText(R.string.get_code)+"("+millisUntilFinished/1000+")");
        }

        @Override
        public void onFinish() {
            ifTimer=false;
            btGetCode.setClickable(true);
            btGetCode.setBackground(getResources().getDrawable(R.drawable.code_btn_green_2));
        }
    };

    @Override
    public void startTimer() {
        if (!ifTimer){
            timer.start();
        }
    }
}
