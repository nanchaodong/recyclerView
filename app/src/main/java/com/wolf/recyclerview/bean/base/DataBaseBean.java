package com.wolf.recyclerview.bean.base;

import android.databinding.BaseObservable;
import android.os.Parcelable;

import com.orm.SugarRecord;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/3/24.
 */

public abstract class DataBaseBean extends SugarRecord implements Visitable {
}
