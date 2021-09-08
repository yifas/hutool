package com.bin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class BigDecimalTest {

    @Test
    void testDec(){
        BigDecimal presentPrice = new BigDecimal("0");
        BigDecimal decimal = new BigDecimal("500");
        System.err.println(presentPrice);
         presentPrice = presentPrice.add(decimal);

        System.err.println(presentPrice);
    }
}
