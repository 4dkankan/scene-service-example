package com.fdkankan.example.controller;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fdkankan.example.bean.ResultData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hot")
public class HotController {

    private static final String HOTJSON_FILENAME_FORMAT = "hot-%s.json";

    @Value("${path.data.hot.path}")
    private String hotPath;

    @GetMapping
    public ResultData get(String num){

        String hotJsonFile = String.format(HOTJSON_FILENAME_FORMAT, num);
        String hotJsonFilePath = hotPath.concat(hotJsonFile);
        if(!FileUtil.exist(hotJsonFilePath)){
            return ResultData.ok();
        }
        String jsonStr = FileUtil.readUtf8String(hotJsonFilePath);
        return ResultData.ok(JSON.parseObject(jsonStr));
    }

    @PostMapping
    public ResultData save(String num, @RequestBody JSONObject hotJson){
        String hotJsonFile = String.format(HOTJSON_FILENAME_FORMAT, num);
        String hotJsonFilePath = hotPath.concat(hotJsonFile);
        FileUtil.mkParentDirs(hotJsonFilePath);
        FileUtil.writeUtf8String(hotJson.toJSONString(), hotJsonFilePath);
        return ResultData.ok();
    }


}
