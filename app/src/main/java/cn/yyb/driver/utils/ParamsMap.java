package cn.yyb.driver.utils;

import android.util.Log;
import java.util.HashMap;

public class ParamsMap<K, V> extends HashMap<K, V> {

    @Override
    public V put(K key, V value) {
        if (key == null) {
            Log.e("ParamsMap", "ParamsMap 的 key 为null");
            return value;
        }

        //用来对String类型过滤，参数类型基本是基础类型
        if (value == null) {
            value = (V) "";
        }
        return super.put(key, value);
    }
}
