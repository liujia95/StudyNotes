package me.liujia95.studynotes._2016_2_27.utils;

/**
 * Created by Administrator on 2016/2/27 20:52.
 */
public class StringMatcher {
    /**
     * @param value   item条目中的文字
     * @param keyword 索引列表的字符
     * @return 这两个是否进行匹配
     */
    public static boolean match(String value, String keyword) {
        if (value == null || keyword == null) {
            return false;
        }
        if (keyword.length() > value.length()) {
            return false;
        }
        int i = 0; //value的指针
        int j = 0; //keyword的指针
        do {
            if (keyword.charAt(j) == value.charAt(i)) {
                i++;
                j++;
            } else if (j > 0) {
                //TODO：有疑问：如果索引匹配不上前面，到后面匹配上了，也要break？
                break;
            } else {
                i++;
            }
        } while (i < value.length() && j < keyword.length());

        return (j == keyword.length());
    }
}
