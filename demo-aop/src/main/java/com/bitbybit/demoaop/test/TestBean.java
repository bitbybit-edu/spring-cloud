package com.bitbybit.demoaop.test;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class TestBean {

    private static final Logger logger = Logger.getLogger("com.bitbybit.demoaop.test.TestBean");

    public void progressing() {
        logger.log(Level.INFO, "progressing");
    }


}
