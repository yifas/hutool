package com.bin.controller;

import com.bin.dao.StoreDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/lvyuan")
public class StoreController {

    @Resource
    private StoreDao storeDao;


}
