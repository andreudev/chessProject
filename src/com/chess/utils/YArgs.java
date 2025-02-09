package com.chess.utils;

import java.util.HashMap;

public class YArgs {

    public static HashMap<String, String> splitArgs(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        for (String arg : args) {
            String[] split = arg.split("=");
            if (split.length == 2) {
                map.put(split[0], split[1]);
            }
        }
        return map;
    }


}
