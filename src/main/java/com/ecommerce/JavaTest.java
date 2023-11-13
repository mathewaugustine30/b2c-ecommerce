package com.ecommerce;

import java.util.HashMap;

public class JavaTest {

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("mohan","10");
        map.put("rohan","10");
        map.put("mohan","20");
        map.put(new String("mohan"),"22");
        System.out.println(map);
    }
}
