package cn.yyb.driver.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.yyb.driver.R;
import cn.yyb.driver.framework.mvp.MVPFragment;
import cn.yyb.driver.login.activity.LoginActivity;

/**
 * 我的fragment
 */
public class MyFragment extends MVPFragment<MyFragmentContract.IView, MyFragmentPresenter> {

    @BindView(R.id.iv_face)
    QMUIRadiusImageView ivFace;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_credit_score)
    TextView tvCreditScore;
    @BindView(R.id.tv_point)
    TextView tvPoint;
    @BindView(R.id.tv_end_money)
    TextView tvEndMoney;
    Unbinder unbinder;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        ivFace.setImageResource(R.mipmap.ic_launcher);
        ivFace.setCircle(true);
        ivFace.setOval(false);
        ivFace.setCornerRadius(100);
        ivFace.setBorderWidth(0);
    }

    @Override
    protected MyFragmentPresenter createPresenter() {
        return new MyFragmentPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_message, R.id.iv_setting, R.id.iv_to_login, R.id.rl_my_line, R.id.rl_waybill_order, R.id.rl_my_money, R.id.rl_shop_point, R.id.rl_more_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_message:
                break;
            case R.id.iv_setting:
                break;
            case R.id.iv_to_login:
                toActivity(LoginActivity.class);
                break;
            case R.id.rl_my_line:
                break;
            case R.id.rl_waybill_order:
                break;
            case R.id.rl_my_money:
                break;
            case R.id.rl_shop_point:
                break;
            case R.id.rl_more_setting:
                break;
        }
    }

    private void toActivity(Class<?> c){
        mContext.startActivity(new Intent(mContext,c));
    }
}
