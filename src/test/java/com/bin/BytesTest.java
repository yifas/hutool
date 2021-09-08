package com.bin;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

@SpringBootTest
public class BytesTest {


    @Test
    void testBytes() throws UnsupportedEncodingException {
        String str = "福建";
        String string = new String(str.getBytes("utf-8"),"iso-8859-1");
        String string1 = new String(str.getBytes("iso-8859-1"));

        System.out.println(string1);
    }

    @Test
    void testJson(){
        String s = "{\n" +
                "  \"head\": {\n" +
                "    \"sysCode\": \"UOP101\",\n" +
                "    \"method\": \"synOrderInfo\",\n" +
                "    \"sign\": \"db7fb96507b69fa922b75b4f621b1e6b\",\n" +
                "    \"appCode\": \"FJDQTMGL\",\n" +
                "    \"attach\": \"hello,proc.fj.189.cn\",\n" +
                "    \"reqTime\": \"2021-07-20 09:01:55\",\n" +
                "    \"version\": \"1\",\n" +
                "    \"transactionId\": \"FJDQTMGL21072009016FCBFC419DBE558FD1BC786A844948C6\"\n" +
                "  },\n" +
                "  \"biz\": {\n" +
                "    \"amount\": \"369\",\n" +
                "    \"offerName\": \"null\",\n" +
                "    \"provName\": \"福建\",\n" +
                "    \"sendDate\": \"2021-07-08 06:30:30\",\n" +
                "    \"busiAct\": \"新装/订购\",\n" +
                "    \"custAddr\": \"aaa\",\n" +
                "    \"statusCd\": \"0\",\n" +
                "    \"finshDate\": \"2021-07-14 09:00:30\",\n" +
                "    \"remark\": \"测试\",\n" +
                "    \"custName\": \"邓清华\",\n" +
                "    \"logisticCompan\": \"sdds\",\n" +
                "    \"logisticNbr\": \"123456\",\n" +
                "    \"iccid\": \"12345678\",\n" +
                "    \"cityName\": \"漳州\",\n" +
                "    \"phone\": \"15305020920\",\n" +
                "    \"orderCode\": \"1947772479644913367\",\n" +
                "    \"busiType\": \"宽带新装\",\n" +
                "    \"from\": \"aaaaa\",\n" +
                "    \"accNbr\": \"15612345678\",\n" +
                "    \"account\": \"super\",\n" +
                "    \"createDate\": \"2021-07-13 19:10:36\"\n" +
                "  }\n" +
                "}";

        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(jsonObject.getJSONObject("head").getString("sysCode"));
    }
}
