package cn.yyb.driver.my.message;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import cn.yyb.driver.R;
import cn.yyb.driver.framework.mvp.MVPActivity;

public class MessageActivity extends MVPActivity<MessageContract.IView, MessagePresenter>
        implements MessageContract.IView {
    @BindView(R.id.tv_title_login)
    TextView tvTitleLogin;
    @BindView(R.id.fist)
    LinearLayout fist;
    @BindView(R.id.lv_message)
    ListView lvMessage;

    private MessageAdapter adapter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected LinearLayout setFistLayoutId() {
        return fist;
    }

    @Override
    protected void initView() {
        tvTitleLogin.setText("消息中心");
        adapter=new MessageAdapter(this,new ArrayList<MessageBean>());
        lvMessage.setAdapter(adapter);
        lvMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    protected MessagePresenter createPresenter() {
        return new MessagePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.iv_title_back2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_back2:
                finish();
                break;
        }
    }
}
