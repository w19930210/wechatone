package wang.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 时间工具类
 */
public class DateUtile {

    /**
     * 给定字符串，获取串中的数字部分(毫秒值)返回时间串
     * 返回格式：yyyy-MM-dd HH
     */
    public static String getStringByNumber(String string){
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(string);
        string = matcher.replaceAll("");
        String reg = "^[0-9]";
        if (string.matches(reg))
            return null;
        //(100000<<2<<3)+(100000<<2)等同于1000*60*60
        Date date = new Date(new Date().getTime() + Long.parseLong(string) - (100000<<2<<3)-(100000<<2));
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH");
        return f.format(date);
    }


}
