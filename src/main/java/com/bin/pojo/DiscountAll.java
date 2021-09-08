package com.bin.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class DiscountAll {

    private static final long serialVersionUID = -1762343807742454946L;

    /**
     * 乐观锁
     */
    private Long attributeCc;
    /**
     * 主键
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModify;
    /**
     * 优惠名称
     */
    private String preName;
    /**
     * 优惠属性
     */
    private String preValue;
    /**
     * 操作人Id
     */
    private Long operatorId;
    /**
     * 省
     */
    private String province;
    /**

     * 市
     */
    private String city;
}
