package cn.yyb.driver.utils;


import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtils {
    public static boolean isBlank(CharSequence cs) {
        if (cs == null || cs.length() == 0 || cs.equals("") || cs.equals("null")|| cs.equals("NULL")) {
            return true;
        }
        return false;
    }

    /**
     * 替换
     *
     * @param target
     * @param key
     * @param value
     * @return
     */
    public static String replace(String target, String key, String value) {
        if (!isBlank(target)) {
            String result = target.replace(key, value);
            return result;
        }
        return "";
    }


    public static String[] strSplit(String target, String key) {
        String result[] = null;
        if (!isBlank(target)) {
            result = target.split(key);
        }
        return result;
    }

    /**
     * 通过特殊字符分割成数组在转换成集合
     *
     * @param target
     * @param key
     * @return
     */
    public static List<String> stringToArrayBySplit(String target, String key) {
        String result[] = null;
        if (!isBlank(target)) {
            result = target.split(key);
        } else {
            return new ArrayList<>();
        }
        return Arrays.asList(result);
    }
//

    /**
     * 字符串删除指定下标的字符
     *
     * @param sourceString
     * @param index
     * @return
     */
    public static String deleteCharByIndex(String sourceString, int index) {
        if (isBlank(sourceString)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sourceString.length(); i++) {
            if (i != index) {
                sb.append(sourceString.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 字符串add指定下标的字符
     *
     * @param sourceString
     * @param index
     * @return
     */
    public static String addCharByIndex(String sourceString, int index, String indexStr) {
        if (isBlank(sourceString)) {
            return "";
        }
        //如果是-1说明光标在最前面
        if (index == -1) {
            return indexStr + sourceString;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sourceString.length(); i++) {
            if (i != index) {
                sb.append(sourceString.charAt(i));
            } else {
                sb.append(sourceString.charAt(i) + indexStr);
            }
        }
        return sb.toString();
    }

    /**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
    /**
     *
     *  设置Textview的一段属性
     *
     *author  xuhaijiang
     *@since 2014年7月3日上午9:49:00
     *@param tv tv
     *@param start 开始位置
     *@param end 结束位置
     *@param colorRes 不同的资源颜色
     *@param text text
     *@param zoom 放大缩小倍数
     */
    public static void setTextColor(TextView tv, int start, int end, int colorRes, String text, float zoom) {
        SpannableStringBuilder style = new SpannableStringBuilder(text);
        if (0 != colorRes) {
            style.setSpan(new ForegroundColorSpan(colorRes), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        if (zoom != 0 && zoom != 1) {
            style.setSpan(new RelativeSizeSpan(zoom), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        tv.setText(style);
    }

    /**
     * double 转 String 保留
     *
     * @param num
     * @param format
     * @return
     */
    public static String doubleToString(double num, String format){
        return new DecimalFormat(format).format(num);
    }
}
