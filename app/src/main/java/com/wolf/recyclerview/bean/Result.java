package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/3/16.
 */

public class Result<T> implements Visitable {
    private static final String TYPE = "Result";
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

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String type() {
        return TYPE;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                ", errorcode=" + errorcode +
                ", data=" + data +
                '}';
    }
}
