package com.msi.core.bean;

import java.io.OutputStream;

/**
 * @author zyh
 * @Date 2020/12/30
 * @Description TODO
 */
public class ResultBean {
    /**
     * HTTP状态码
     */
    private int code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;
    /**
     * 成功、错误标志 默认成功
     */
    private Boolean flag = true;

    private OutputStream outputStream;

    public ResultBean setOutputStream(OutputStream outputStream){
        this.outputStream = outputStream;
        return this;
    }
    public OutputStream getOutputStream(){
        return outputStream;
    }

    public ResultBean setData(Object data) {
        this.data = data;
        return this;
    }

    public ResultBean setCode(int code) {
        this.code = code;
        return this;
    }

    public ResultBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResultBean setFlag(Boolean flag) {
        this.flag = flag;
        return this;
    }

    /**
     * 无参构造
     */
    public ResultBean() {
        this.code = 200;
        this.msg = "success";
    }

    public ResultBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultBean(int code, String msg, Object data, Boolean flag) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.flag = flag;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public Boolean getFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", flag=" + flag +
                ", outputStream=" + outputStream +
                '}';
    }
}
