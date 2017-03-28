package com.wolf.recyclerview.activity;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.databinding.ACodeBinding;
import com.wolf.recyclerview.view.SecurityCodeView;

/**
 * Created by nanchaodong on 2017/3/28.
 */

public class CodeActivity extends BaseActivity<ACodeBinding> {
    private final ObservableField<String> obText = new ObservableField<String>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_code);
        bindView.setText(obText);
        bindView.code.setInputCompleteListener(new SecurityCodeView.InputCompleteListener() {


            @Override
            public void inputCompleteListener(String content) {
                obText.set(content);
            }

            @Override
            public void deleteContent(String content) {
                obText.set(content);
            }


        });
    }

}
