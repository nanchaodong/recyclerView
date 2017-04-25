package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

import java.security.SecureRandom;

/**
 * Created by nanchaodong on 2017/4/24.
 */

public class Test implements Visitable {
    private static final String TYPE = "Test";
    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String type() {
        return TYPE;
    }
}
