package cn.yyb.driver.my.message;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.yyb.driver.R;
import cn.yyb.driver.adapter.BaseHolderAdapter;

/**
 * 描述:消息适配器
 */
public class MessageAdapter extends BaseHolderAdapter<MessageBean> {

    private int selectIndex;

    public MessageAdapter(Context context, List<MessageBean> list) {
        super(context, list);
    }

    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
    }

    @Override
    public int getContentView(int position) {
        return R.layout.adapter_message_layout;
    }

    @Override
    public void onInitView(View view, int position) {
        ImageView ivMessage = get(view, R.id.iv_message);
        TextView tvMessageTitle = get(view, R.id.tv_message_title);
        TextView tvmessageTime = get(view, R.id.tv_message_time);
        TextView tvMessageContent = get(view, R.id.tv_message_content);
        MessageBean bean = getItem(position);
        ivMessage.setBackgroundResource(R.mipmap.ic_launcher);
        tvMessageTitle.setText("");
        tvmessageTime.setText("");
        tvMessageContent.setText("");
    }
}

