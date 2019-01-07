package cn.yyb.driver.postBean;

import java.util.List;

/**
 * 设置已读bean
 */
public class SetReadBean {
    private List<Integer> Ids;//消息唯一号集合

    public List<Integer>  getIds() {
        return Ids;
    }

    public void setIds(List<Integer>  ids) {
        Ids = ids;
    }
}
