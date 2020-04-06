package com.family.bbkingbase.common;

import org.apache.poi.ss.formula.functions.T;

public class Result<T> {
    private String message;
    private int retCode;
    private String url;
    private T data;
    public Result(T data) {
        this.retCode = 0;
        this.message = "成功";
        this.data = data;
    }
    public Result(CodeMsg cm,String url) {
        if(cm == null){
            return;
        }
        this.retCode = cm.getRetCode();
        this.message = cm.getMessage();
        this.url = url;
    }
    /**
     * 成功时候的调用
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }
    /**
     * 成功，不需要传入参数
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Result<T> success(){
        return (Result<T>) success("");
    }
    /**
     * 失败时候的调用
     * @return
     */
    public static <T> Result<T> error(CodeMsg cm,String url){
        return new Result<T>(cm,url);
    }
    /**
     * 失败时候的调用,扩展消息参数
     * @param cm
     * @param msg
     * @return
     */
    public static <T> Result<T> error(CodeMsg cm,String msg,String url){
        cm.setMessage(cm.getMessage()+"--"+msg);
        return new Result<T>(cm,url);
    }
    public T getData() {
        return data;
    }
    public String getMessage() {
        return message;
    }
    public int getRetCode() {
        return retCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
