package com.fdkankan.example.controller;

import com.fdkankan.example.bean.ResultData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hot")
public class HotController {

    private static final String HOTJSON_FILENAME_FORMAT = "hot-%s.json";

    @Value("path.data.hot.path")
    private String hotPath;

    @GetMapping
    public ResultData get(String num){
        String hotJsonFile = String.format(HOTJSON_FILENAME_FORMAT, num);
        return ResultData.ok("hahaha");
    }

}
