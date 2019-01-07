package cn.yyb.driver.my.message;


import cn.yyb.driver.framework.mvp.MVPPresenter;

public class MessagePresenter extends MVPPresenter<MessageContract.IView, MessageModel>
        implements MessageContract.IPresenter {


    @Override
    protected MessageModel createModel() {
        return new MessageModel();
    }

    @Override
    protected void initData() {

    }

    /**
     * 设为已读
     */
    @Override
    public void setRead() {

    }
}