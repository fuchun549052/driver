package cn.yyb.driver.login.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.yyb.driver.R;
import cn.yyb.driver.framework.mvp.MVPActivity;
import cn.yyb.driver.login.contract.PassLoginContract;
import cn.yyb.driver.login.presenter.PassLoginPresenter;
import cn.yyb.driver.utils.StringUtils;
import cn.yyb.driver.utils.ToastUtil;
import cn.yyb.driver.utils.ToolUtils;

public class PassLoginActivity extends MVPActivity<PassLoginContract.IView, PassLoginPresenter>
        implements PassLoginContract.IView {
    @BindView(R.id.tv_title_login)
    TextView tvTitleLogin;
    @BindView(R.id.et_login_phone)
    EditText etLoginPhone;
    @BindView(R.id.et_login_pass)
    EditText etLoginPass;
    @BindView(R.id.fist)
    LinearLayout fist;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_pass_login;
    }

    @Override
    protected LinearLayout setFistLayoutId() {
        return fist;
    }

    @Override
    protected void initView() {
        tvTitleLogin.setVisibility(View.GONE);
    }

    @Override
    protected PassLoginPresenter createPresenter() {
        return new PassLoginPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.iv_title_back2, R.id.iv_show, R.id.bt_login, R.id.tv_to_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_back2:
                finish();
                break;
            case R.id.iv_show://显示密码
                break;
            case R.id.bt_login://登录
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
}
