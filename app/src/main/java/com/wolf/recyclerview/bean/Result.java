package com.wolf.recyclerview.bean;

/**
 * Created by nanchaodong on 2017/3/16.
 */

public class Result<T> {
    private int result;
    private int errorcode;
    private T data;

    public Result(int result, int errorcode, T data) {
        this.result = result;
        this.errorcode = errorcode;
        this.data = data;
    }

    public Result() {
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
