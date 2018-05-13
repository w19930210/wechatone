package wang.utils;

/**
 * Created by Administrator on 2018/5/4.
 */
public class NumberUtile {
    /**
     * 判断是否为正浮点数的字符串
     */
    public static boolean isDouble(String str){
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }

    /**
     * 判断是否为正整数的字符串
     */
    public static boolean isInteger(String str){
        String reg = "^[0-9]";
        return str.matches(reg);
    }

    /**
     * 判断传入的字符串是否为正浮点数
     *  是则返回值的类型
     *  不是则返回指定的数值
     */
    public static Double judgeDouble(String str, Double result){
        if (!isDouble(str))
            return result;
        return Double.parseDouble(str);
    }

    /**
     * 判断传入的字符串是否为正浮点数
     *  是则返回值的类型
     *  不是则返回指定的数值
     */
    public static Integer judgeInteger(String str, Integer result){
        if (!isInteger(str))
            return result;
        return Integer.parseInt(str);
    }
}
