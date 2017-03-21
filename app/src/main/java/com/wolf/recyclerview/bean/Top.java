package com.wolf.recyclerview.bean;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import rx.Observable;

/**
 * Created by nanchaodong on 2017/3/17.
 */

public class Top {
    public  ObservableField<String> advertId = new ObservableField<String>();
    public  ObservableInt articleId = new ObservableInt();
    public  ObservableField<String> articleTitle = new ObservableField<String>();
    public  ObservableField<String> imageUrl = new ObservableField<String>();
    public  ObservableField<String> linkUrl = new ObservableField<String>();
    public  ObservableInt type = new ObservableInt();


}
