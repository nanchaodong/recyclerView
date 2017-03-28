package com.wolf.recyclerview.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.databinding.ViewSecurityCodeBinding;
import com.wolf.recyclerview.presenter.EditWatcher;

/**
 * Created by nanchaodong on 2017/3/28.
 */

public class SecurityCodeView extends RelativeLayout {
    private static final String TAG = "SecurityCodeView";
    private ViewSecurityCodeBinding codeBinding;
    private EditText editText;
    private TextView[] textViews;
    private StringBuffer stringBuffer;
    private int count = 4;
    private String inputContent;

    public SecurityCodeView(Context context) {
        this(context, null);
    }

    public SecurityCodeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SecurityCodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        codeBinding = DataBindingUtil.inflate(inflater, R.layout.view_security_code, this, true);
        codeBinding.setSecurity(this);
        editText = codeBinding.itemEditText;
        textViews = new TextView[4];
        stringBuffer = new StringBuffer();
        textViews[0] = codeBinding.itemCodeIv1;
        textViews[1] = codeBinding.itemCodeIv2;
        textViews[2] = codeBinding.itemCodeIv3;
        textViews[3] = codeBinding.itemCodeIv4;
    }

    public EditWatcher textWatcher = new EditWatcher() {
        @Override
        public void afterTextChanged(Editable editable) {
            if (!editable.toString().equals("")) {
                if (stringBuffer.length() > 3) {
                    editText.setText("");
                    return;
                } else {
                    stringBuffer.append(editable);
                    editText.setText("");
                    count = stringBuffer.length();
                    inputContent = stringBuffer.toString();
                    if (inputContent.length() == 4) {
                        if (inputCompleteListener != null) {
                            inputCompleteListener.inputCompleteListener(inputContent);
                        }
                    }
                }
                for (int i = 0; i < stringBuffer.length(); i++) {
                    textViews[i].setText(String.valueOf(inputContent.charAt(i)));
                    textViews[i].setBackgroundResource(R.mipmap.bg_verify_press);
                }
            }

        }
    };
    public OnKeyListener keyListener = new OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == KeyEvent.KEYCODE_DEL && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                if (onKeyDelete()) return true;
                return true;
            }
            return false;
        }
    };

    private boolean onKeyDelete() {
        if (count == 0) {
            count = 4;
            return true;
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.delete(count - 1, count);
            count--;
            inputContent = stringBuffer.toString();
            textViews[stringBuffer.length()].setText("");
            textViews[stringBuffer.length()].setBackgroundResource(R.mipmap.bg_verify);
            if (inputCompleteListener != null) {
                inputCompleteListener.deleteContent(inputContent);
            }
        }
        return false;
    }

    public interface InputCompleteListener {
        void inputCompleteListener(String content);

        void deleteContent(String content);
    }

    private InputCompleteListener inputCompleteListener;

    public void setInputCompleteListener(InputCompleteListener listener) {
        this.inputCompleteListener = listener;
    }
}
