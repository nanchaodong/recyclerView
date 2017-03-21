package com.wolf.recyclerview.presenter;

import com.wolf.recyclerview.bean.Result;

import rx.functions.Func1;

/**
 * Created by nanchaodong on 2017/3/16.
 */

public class HttpResultFunc<T> implements Func1<Result<T>, T> {
    @Override
    public T call(Result<T> tResult) {
        if (tResult.getResult() == -1) {
            throw new ApiException("");
        }
        return tResult.getData();
    }
}
