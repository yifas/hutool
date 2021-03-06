package com.bin.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String name;
    private Integer age;
    private String gender;
    private String phone;
    private String address;
}
