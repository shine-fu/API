package com.shine.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Fu Junchao
 */
public class StringUtil {


    /**
     * compare two given string , if the string is null or empty , push back
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int strCompare(String s1, String s2) {
        if (isNullOrEmpty(s1) && isNullOrEmpty(s2)) {
            return 0;
        } else if (isNullOrEmpty(s1) && !isNullOrEmpty(s2)) {
            return 1;
        } else if (!isNullOrEmpty(s1) && isNullOrEmpty(s2)) {
            return -1;
        } else if (canCastToNumber(s1) && canCastToNumber(s2)) {
            String f = s1.substring(getFirstNonZeroIndex(s1));
            String s = s2.substring(getFirstNonZeroIndex(s2));
            int len = f.length() - s.length();
            return len == 0 ? f.compareTo(s) : len;
        } else {
            return s1.compareTo(s2);
        }
    }

    @Test
    public void test() {
        String[] strs = new String[]{"123", null, "", null, "12341", "", "9912"};
        List<String> strings = Arrays.asList(strs);
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return strCompare(o1, o2);
            }
        });
        System.out.println(strings);


    }


    /**
     * check the given string is null or empty
     *
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * try to parse the given string to a number
     *
     * @param numStr
     * @param type
     * @param <T>
     * @return
     */
    public static <T extends Number> T parseNonZeroInt(String numStr, Class<T> type) {
        if (type == Integer.class)
            return (T) Integer.valueOf(numStr);
        if (type == Long.class)
            return (T) Long.valueOf(numStr);
        return null;
    }

    /**
     * judge the given string is a decimal number or not
     *
     * @return
     */
    public static boolean isDecimalNumber(String snum) {
        return snum.matches("^[1-9][0-9]*\\.[0-9]*$");
    }


    public static boolean canCastToNumber(String snum) {
        return snum.matches("^[0-9]*(\\.)?[0-9]*$");
    }


    @Test
    public void testisDec() {
        String num = "1232.2344";
        System.out.println(num + (isDecimalNumber(num) ? "是" : "不是") + "十进制的数！");
        System.out.println(Double.MAX_VALUE);
        num = "123123";
        System.out.println(num + (isDecimalNumber(num) ? "是" : "不是") + "十进制的数！");
        System.out.println(num + (canCastToNumber(num) ? "可以" : "不可以"));

    }

    @Test
    public void testStr() {
        String[] strs = new String[]{"0651644", "123", null, null, "asdw", "svq",
                "12341", "", "9912", "00215164", "2316015", "03216444", "123", "12", "1234", null, ""};
        final List<String> strings = Arrays.asList(strs);
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return strCompare(o1, o2);
            }
        });
        System.out.println(strings);
    }

    /**
     * if the string is empty or null ,return -1
     *
     * @param str
     * @return
     */
    public static int getFirstNonZeroIndex(String str) {
        if (isNullOrEmpty(str)) {
            return -1;
        }
        int index = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            index = i;
            if (str.charAt(index) != '0') {
                break;
            }
        }
        return index;
    }


}
