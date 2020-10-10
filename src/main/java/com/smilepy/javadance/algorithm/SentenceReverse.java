package com.smilepy.javadance.algorithm;

/**
 * 将一个英文句子反转，但每个单词正序，不使用String的split方法
 * @author peiyu
 */
public class SentenceReverse {
    public static void main(String[] args) {
        String content = "      Hello World   yeah                       ";
        char[] chars = content.toCharArray();
        reverseString(chars, 0, chars.length - 1);
        System.out.println("temp result:" + new String(chars));
        int start = -1, end = -1;
        for (int i = 0; i <= chars.length - 1; i++) {
            if (start == -1 && ' ' != chars[i]) {
                start = i;
            }
            if (end == -1 && ' ' != chars[i] && ((i < chars.length - 1 && ' ' == chars[i + 1]) || i == chars.length - 1)) {
                end = i;
            }
            if (start != -1 && end != -1) {
                reverseString(chars, start, end);
                start = -1;
                end = -1;
            }
        }
        System.out.println("final result:" + new String(chars));
    }

    public static void reverseString(char[] chars, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char cur = chars[i];
            chars[i] = chars[j];
            chars[j] = cur;
        }
    }
}
