package com.wolf.recyclerview.presenter;

import java.io.Serializable;

/**
 * Created by nanchaodong on 2017/3/3.
 */

public interface Visitable extends Serializable {
    int type(TypeFactory typeFactory);
    String type();
}
