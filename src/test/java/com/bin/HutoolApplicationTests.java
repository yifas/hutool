package com.bin;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bin.dao.DiscountAllDAO;
import com.bin.dao.StoreDao;
import com.bin.pojo.DiscountAll;
import com.bin.pojo.Store;
import com.bin.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class HutoolApplicationTests {

    @Autowired
    private StoreDao storeDao;
    @Autowired
    private DiscountAllDAO discountAllDAO;

    @Test
    void contextLoads() {
        ExcelReader reader = ExcelUtil.getReader("C:/Users/fitz/Desktop/test.xlsx");
        List<List<Object>> readAll = reader.read();
        System.out.println(readAll.get(0));
        for (int i = 1; i < readAll.size(); i++) {
//            System.out.println(readAll.get(i));
            for (int j = 0; j < readAll.get(i).size(); j++) {
                System.out.println(readAll.get(i).get(j));
            }
        }


    }
    //‪C:\Users\fitz\Desktop\lvyuanstore.xlsx
    @Test
    void testRead(){
        ExcelReader reader = ExcelUtil.getReader("C:/Users/fitz/Desktop/lvyuanstore.xlsx");
        List<List<Object>> readAll = reader.read();
        //System.out.println(readAll);
            /*for (int j = 0; j < readAll.get(i).size(); j++) {
                System.err.println(readAll.get(i).get(0));
            }*/
        for (int i = 1; i < readAll.size(); i++) {
            //取地址
//            System.out.println(readAll.get(i).toString().split(" ")[0].substring(1));
            //取手机号
//            System.out.println(readAll.get(i).toString().split("联系方式：")[1].substring(0,12).trim());
            //取详细地址
            int end = readAll.get(i).toString().split(", ")[1].length()-1;
//            System.out.println(readAll.get(i).toString().split(", ")[1].substring(0,end));
            //取区
//            System.out.println(readAll.get(i).toString().split(", ")[1].substring(3,6));

            Store store = new Store();
            store.setStoreName(readAll.get(i).toString().split(" ")[0].substring(1));
            store.setUsername("未知");
            store.setPhone(readAll.get(i).toString().split("联系方式：")[1].substring(0,12).trim());
            store.setAddress(readAll.get(i).toString().split(", ")[1].substring(0,end));
            store.setProvince("浙江");
            store.setCity("宁波");
            store.setArea(readAll.get(i).toString().split(", ")[1].substring(3,6));
            store.setCreateTime(new Date());
            System.err.println(store);
            storeDao.insert(store);
        }
//        System.out.println(readAll.get(0).toString().split("\\)")[0]);
//        System.out.println(readAll.get(0).toString().split(" ")[0]);

    }

    @Test
    void testJDBC(){
        Store store = storeDao.selectById(1);
        System.out.println(store);

    }

    @Test
    void testWriterPoi() {
        Map<String, Object> row1 = new LinkedHashMap<>();
        row1.put("姓名", "张三");
        row1.put("年龄", 23);
        row1.put("成绩", 88.32);
        row1.put("是否合格", true);
        row1.put("考试日期", DateUtil.date());

        Map<String, Object> row2 = new LinkedHashMap<>();
        row2.put("姓名", "李四");
        row2.put("年龄", 33);
        row2.put("成绩", 59.50);
        row2.put("是否合格", false);
        row2.put("考试日期", DateUtil.date());

        ArrayList<Map<String, Object>> rows = CollUtil.newArrayList(row1, row2);


        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("C:/Users/fitz/Desktop/writeMapTest.xlsx");
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(rows.size() - 1, "一班成绩单");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
        // 关闭writer，释放内存
        writer.close();
    }

    @Test
    void testWriteBean() {
        User user1 = new User();
        user1.setName("a");
        user1.setAge(0);
        user1.setGender("male");
        user1.setPhone("18812345678");
        user1.setAddress("china");

        User user2 = new User();
        user2.setName("b");
        user2.setAge(0);
        user2.setGender("female");
        user2.setPhone("18812345677");
        user2.setAddress("k");

        //构建封装对象的集合
        List<User> rows = CollUtil.newArrayList(user1, user2);


        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("C:/Users/fitz/Desktop/writeBeanTest.xlsx");
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(4, "用户信息");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
        // 关闭writer，释放内存
        writer.close();


    }

    @Test
    void testReadDiscount(){
        ExcelReader reader = ExcelUtil.getReader("C:/Users/fitz/Desktop/0907discount.xlsx");
        List<List<Object>> readAll = reader.read();

        System.out.println("size------------------------"+readAll.size());
        for (int i = 0; i < readAll.size(); i++) {
//            System.out.println(readAll.get(i).get(1).toString().trim());

            DiscountAll discountAll = new DiscountAll();
            //第一行
            System.out.println(readAll.get(i).get(0).toString().trim());
            String  preName = readAll.get(i).get(0).toString().trim();
            discountAll.setPreName(preName);
            String  preValue = null;


            if (readAll.get(i).get(1)!=null){
                preValue = readAll.get(i).get(1).toString().trim();
                System.err.println(preValue);
                discountAll.setPreValue(preValue);
            }else {
                preValue = "0";
                discountAll.setPreValue(preValue);
            }
            discountAll.setProvince("浙江");
            discountAll.setCity("杭州");
            discountAll.setGmtCreate(new Date());
            discountAll.setAttributeCc(0L);
            QueryWrapper<DiscountAll> queryWrapper = new QueryWrapper<>();
//            System.out.println("preName--------"+preName);
//            System.out.println("preValue--------"+preValue);
            queryWrapper.eq("preName",preName);
            if(null==preValue||"".equals(preValue)){

            }else{
                queryWrapper.eq("preValue",preValue);
            }
            queryWrapper.eq("province","浙江");
            queryWrapper.eq("city","杭州");

            DiscountAll discountAll1 = discountAllDAO.selectOne(queryWrapper);
            if (discountAll1==null){
                discountAllDAO.insert(discountAll);
            }
        }
    }
    @Test
    public void testTwo(){
        QueryWrapper<DiscountAll> queryWrapper = new QueryWrapper<>();
//            System.out.println("preName--------"+preName);
//            System.out.println("preValue--------"+preValue);

        queryWrapper.eq("province","浙江");
        queryWrapper.eq("city","杭州");

        DiscountAll discountAll1 = discountAllDAO.selectOne(queryWrapper);
        System.out.println(discountAll1);
    }

}
