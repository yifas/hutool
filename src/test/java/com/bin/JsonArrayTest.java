package com.bin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JsonArrayTest {

    @Test
    void testParseJson(){
        JSONObject backJson = new JSONObject();
        JSONObject resultJson = new JSONObject();


        JSONObject dataJson = new JSONObject();
        dataJson.put("product_id", "30000000037001");//阿里侧虚拟产品id 30000000037001
        dataJson.put("offer_name", "包月流量包15元6GB");//产品名称
        dataJson.put("offer_in_desc", "");//套餐产品包内优惠描述
        dataJson.put("offer_id", "224161500163");//外部产品id
        dataJson.put("offer_type", "FLOW_OFFER_ORIGINAL");//BASE_OFFER_ORIGINAL 基础策划原价 * BASE_OFFER_DISCOUNT 基础策划折扣 * FLOW_OFFER_ORIGINAL 流量包原价 * FLOW_OFFER_DISCOUNT 流量包折扣
        dataJson.put("exp_month", "2年");//合约期
        dataJson.put("send_award_fee", "");//需发放额度(分)
        dataJson.put("lock_money", "");//质押金额(分)
        dataJson.put("offer_set", "15元/月");//套餐档位
        dataJson.put("offer_out_desc", "");//套餐产品包外优惠描述
        dataJson.put("offer_set_discount", "");//优惠后套餐档位
        dataJson.put("ext", "{}");
        dataJson.put("offer_desc", "");//商品描述


        //13.9元10G10天流量包
        JSONObject dataJson2 = new JSONObject();
        dataJson2.put("product_id", "30000000038001");//阿里侧虚拟产品id
        dataJson2.put("offer_name", "13.9元10G10天流量包");//产品名称
        dataJson2.put("offer_in_desc", "");//套餐产品包内优惠描述
        dataJson2.put("offer_id", "216165859998");//外部产品id
        dataJson2.put("offer_type", "FLOW_OFFER_ORIGINAL");//BASE_OFFER_ORIGINAL 基础策划原价 * BASE_OFFER_DISCOUNT 基础策划折扣 * FLOW_OFFER_ORIGINAL 流量包原价 * FLOW_OFFER_DISCOUNT 流量包折扣
        dataJson2.put("exp_month", "0");//合约期
        dataJson2.put("send_award_fee", "");//需发放额度(分)
        dataJson2.put("lock_money", "");//质押金额(分)
        dataJson2.put("offer_set", "13.9元/10天");//套餐档位
        dataJson2.put("offer_out_desc", "");//套餐产品包外优惠描述
        dataJson2.put("offer_set_discount", "");//优惠后套餐档位
        dataJson2.put("ext", "{}");
        dataJson2.put("offer_desc", "");//商品描述



        JSONArray jsonArray = new JSONArray();
        jsonArray.add(dataJson);
        jsonArray.add(dataJson2);
        resultJson.put("data", jsonArray);
        backJson.put("result", resultJson);

        System.out.println(backJson);
    }


    @Test
    void testJson1(){
        String str = "{\"alibaba_mj_moscarnival_receivecoupon_response\":{\"result\":{\"data\":\"{\\\"rightsList\\\":[],\\\"success\\\":true,\\\"prizeType\\\":3,\\\"hasPrize\\\":true,\\\"isNewUser\\\":false}\",\"err_code\":200,\"success\":true,\"total\":0},\"request_id\":\"66q068diapw0\"}}";
        Boolean success = (Boolean) JSONObject.parseObject(str).getJSONObject("alibaba_mj_moscarnival_receivecoupon_response").getJSONObject("result").get("success");
        System.out.println(success);
    }

    @Test
    void testJson2(){
        String str="[\n" +
                "  {\n" +
                "    \"orderType\": \"宽带新装\",\n" +
                "    \"sgOrder\": \"\",\n" +
                "    \"dealNumber\": \"\",\n" +
                "    \"isMain\": 1,\n" +
                "    \"otherPackageName\": \"宽带新装\",\n" +
                "    \"speed\": \"1000M2年\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"orderType\": \"融合续包\",\n" +
                "    \"sgOrder\": \"\",\n" +
                "    \"dealNumber\": \"\",\n" +
                "    \"isMain\": 0,\n" +
                "    \"otherPackageName\": \"169套餐-甲种\",\n" +
                "    \"speed\": \"200M\"\n" +
                "  }\n" +
                "]\n";


//        System.out.println(JSONObject.parseArray(str));
        List<Object> list = JSONObject.parseArray(str);
//        System.err.println(list);
        for (Object o : list) {
            JSONObject jsonObject = JSONObject.parseObject(o.toString());
            String isMain = jsonObject.getString("Main");
           /* if ("1".equals(isMain)){

                System.out.println(jsonObject);
            }*/
            System.out.println(isMain);
        }
//        JSONObject.parseArray(str).getJSONObject()
    }

    @Test
    void testJson3(){
        String str = "{\"mobile\":{\"page\":\"pages/index/index?mobile=a317bf9b-2be2-4bb0-b71d-70b87a24102b\"}}";
        String str2 = "{\"mobile\":{\"mobile\":\"5bc461ee-fbe3-4d19-a59c-d677070f37be\"}}";
        JSONObject object = JSONObject.parseObject(str2);
//        String mobile = object.getString("mobile");
//        JSONObject jsonObject = object.getJSONObject("mobile");
        String page = object.getJSONObject("mobile").getString("mobile");
//        JSONObject jsonObject = object.getJSONObject("mobile").getJSONObject("page");
//        System.err.println(mobile);
//        System.err.println(page.split("=")[0]);
////        System.err.println(page.split("=")[1]);
        System.err.println(page);
    }



}
