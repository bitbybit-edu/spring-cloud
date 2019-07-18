package com.bitbybit.demoaop;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonTests {
    private static final Logger logger = Logger.getLogger("com.bitbybit.demoaop.CommonTests");

    public static void main(String[] args) {
        Integer a = new Integer(3);
        int b = 3;
        Integer c = 3;
        logger.log(Level.INFO,  (a == c) + "");
    }
}
