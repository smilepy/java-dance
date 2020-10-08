package com.smilepy.javadance.util;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author peiyu
 * @date 2020-5-31 16:41
 */
public class ArrayUtilsTest extends TestCase {
    public List<Integer> testByte() {
        int a = 3;
        int b = (a >> 1);
        System.out.println(String.format("b:%d", b));
        int c = 4;
        int d = (c >> 1);
        System.out.println(String.format("d:%d", d));
        Map<String,String> map=new HashMap<>();
        return new ArrayList<Integer>(){{add(new Integer(1));}};
    }
}
