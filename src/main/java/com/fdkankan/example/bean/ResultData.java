package com.fdkankan.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultData<T> implements Serializable {
    /**
     * 状态码
     */
    private int code;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 后端返回结果
     */
    private T data;
    /**
     * 请求是否成功
     */
    private Boolean success;
    /**
     * 响应时间戳
     */
    private long timestamp = Calendar.getInstance().getTimeInMillis();

    public static ResultData ok() {
        return ok(null);
    }
    public static ResultData ok(Object data) {
        return ok("成功", data);
    }
    public static ResultData ok(String msg, Object data) {
        return base(0, msg, data,true);
    }

    public static ResultData error(int code, String msg) {
        return error(code, msg, null); }
    public static ResultData error(int code, String msg, Object data) {
        return base(code, msg, data,false);
    }

    private static ResultData  base(int code, String msg, Object data,Boolean success) {
        ResultData rd = new ResultData();
        rd.setCode(code);
        rd.setMessage(msg);
        rd.setData(data);
        rd.setSuccess(success);
        return rd;
    }

}