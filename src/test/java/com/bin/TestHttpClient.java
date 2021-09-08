package com.bin;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Pattern;

@SpringBootTest
public class TestHttpClient {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void testHttpClint() {
        String url = "http://open.iciba.com/dsapi/";
        String result = restTemplate.getForObject(url, String.class);
        //对字符串进行解析
        //System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        System.err.println(jsonObject);
        System.out.println(jsonObject.get("note"));
        /*
            {"love":"0","sp_pv":"0","note":"真正的失败者是那些害怕失败不敢尝试的人。","dateline":"2021-07-19","s_pv":"0","caption":"词霸每日一句","picture4":"https://staticedu-wps.cache.iciba.com/image/c4d4849ed92c1e9d1b31c69f0f99c6bb.jpg","content":"A real loser is someone so afraid of not wining, they don't even try. ","picture":"https://staticedu-wps.cache.iciba.com/image/1304499e144255cbdf0679e248d7206f.jpg","picture3":"https://staticedu-wps.cache.iciba.com/image/d95a84585b0a07f518b4a5e32d56f54d.jpg","sid":"4193","picture2":"https://staticedu-wps.cache.iciba.com/image/355cae6938c5917aaf90f3116c383367.jpg","tags":[],"tts":"https://staticedu-wps.cache.iciba.com/audio/65c4df6a09975619501271547c1e62dc.mp3","fenxiang_img":"https://staticedu-wps.cache.iciba.com/image/9a1c90c2dcfee8657f3bbcdb8eaf26b5.png","translation":"新版每日一句"}

         */

    }

    @Test
    void testA() {
/*        (1,"10000000000004","DQ10000000000000004","FJ10000000000000004","18822345689","FJDQTMGL2"),
        (1,"10000000000005","DQ10000000000000005","FJ10000000000000005","18805345689","FJDQTMGL2"),
        (1,"10000000000006","DQ10000000000000006","FJ10000000000000006","18806345689","FJDQTMGL2"),
        (1,"10000000000007","DQ10000000000000007","FJ10000000000000007","18807345689","FJDQTMGL2"),
        (1,"10000000000008","DQ10000000000000008","FJ10000000000000008","18808345689","FJDQTMGL2"),
        (1,"10000000000009","DQ10000000000000009","FJ10000000000000009","18809345689","FJDQTMGL2"),
        (1,"10000000000010","DQ10000000000000010","FJ10000000000000010","18810345689","FJDQTMGL2"),
        (1,"10000000000011","DQ10000000000000011","FJ10000000000000011","18811345689","FJDQTMGL2"),
        (1,"10000000000012","DQ10000000000000012","FJ10000000000000012","18812345689","FJDQTMGL2"),
        insert into channel(name,createTime) values("福建天猫","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("杭州天猫","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("杭州公众号","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("浙江京东","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("小公举天猫","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("外呼H5","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("外呼线下","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("电信云销","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("小公举微信","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("给力微信","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("支付宝小程序","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("有赞平台","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("福建添翼","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("外呼信息流春利","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("外呼中介","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("外包杭州煊捷科技有限公司","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("外包山西团队","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("外包安徽团队","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("外呼杭州网站","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("给力信息流","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("百度外呼","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("爱番番","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("网易平台","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("江苏瑞翼","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("拼多多","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("纵合短信","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("给力线下渠道","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("","2021-08-20 09:00:00");
        insert into channel(name,createTime) values("","2021-08-20 09:00:00");
        杭州天猫
        杭州公众号
        浙江京东
        小公举天猫
        外呼H5
        外呼线下
        电信云销
        小公举微信
        给力微信
        支付宝小程序
        有赞平台
        福建添翼
        外呼信息流春利
        外呼中介
        外包杭州煊捷科技有限公司
        外包山西团队
        外包安徽团队
        外呼杭州网站
        给力信息流
        百度外呼
        爱番番
        网易平台
        江苏瑞翼
        拼多多
        纵合短信
        给力线下渠道*/
    }

    @Test
    void testURLEncoding() {

        try {


            String headUrl = "https://m.duanqu.com?_ariver_appid=3000000041425653&_mp_code=tb&transition=present&page=";
            String encode1 = headUrl + URLEncoder.encode("/pages/index/index", "UTF-8");
            String encode2 = headUrl + URLEncoder.encode("/pages/indexTen/indexTen", "UTF-8");
            String encode3 = headUrl + URLEncoder.encode("/pages/index100/index100", "UTF-8");
            System.err.println("30000000420001" + "-" + encode1);
            System.err.println("30000000421001" + "-" + encode2);
            System.err.println("30000000424001" + "-" + encode3);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testURLDecode() {
        String str = "https://m.duanqu.com?_ariver_appid=3000000041425653&query=params%3D%7B%22sellerNick%22%3A%22%E7%A6%8F%E5%BB%BA%E7%94%B5%E4%BF%A1%E5%AE%98%E6%96%B9%E6%97%97%E8%88%B0%E5%BA%97%22%2C%22itemId%22%3A%22644876571760%22%2C%22tradeToken%22%3A%22tradeToken%22%2C%22from%22%3A%22czs%22%2C%22isMobile%22%3A%22true%22%2C%22skuId%22%3A%22";
        String str2 = "%3F";//?
        try {
            String decode = URLDecoder.decode(str, "UTF-8");
            System.err.println(decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testReg() {
        //手机号校验
        final Pattern PHONE_PATTERN = Pattern.compile("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");
        //身份证校验
        final Pattern CARD_PATTERN = Pattern.compile("(\\d{17}[0-9a-zA-Z])|(\\d{14}[0-9a-zA-Z])");
        boolean matches = PHONE_PATTERN.matcher("1885733131").matches();
        System.err.println(matches);
        boolean matches1 = CARD_PATTERN.matcher("330483199601206614").matches();
        System.err.println(matches1);

    }


    @Test
    void testReg2() {
        String str = "北京 北京 北京市";
        String[] s = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s.length);
            System.out.println(s[i]);
        }


    }

    @Test
    void testReg3() {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        System.err.println(p.matcher("陈彬杰").matches());
    }


}
