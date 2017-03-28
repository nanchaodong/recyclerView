package com.wolf.recyclerview.controller;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.bean.School;
import com.wolf.recyclerview.bean.SchoolButton;
import com.wolf.recyclerview.bean.SchoolButtonList;
import com.wolf.recyclerview.constant.Urls;
import com.wolf.recyclerview.presenter.ListRecy;
import com.wolf.recyclerview.presenter.Visitable;
import com.wolf.recyclerview.utils.HttpParams;
import com.wolf.recyclerview.utils.Task;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by nanchaodong on 2017/3/27.
 */

public class SchoolListRecy extends ListRecy {

    private HttpParams httpParams;
    private SchoolButtonList schoolButtonList;
    private List<SchoolButton> buttons;
    private SchoolButton schoolButton;
    private SchoolButton schoolButton1;
    private SchoolButton schoolButton2;

    public SchoolListRecy(RecyclerView r, SwipeRefreshLayout rs, CommonAdapter a, boolean hasFooter) {
        super(r, rs, a, hasFooter);
        httpParams = new HttpParams();
        httpParams.setPlatform("android");
        httpParams.setDevice_token("Asv4x7aECQJWsGxpchPIC6IOb_eX8qJDk2q7P1EWf0pE");
        httpParams.setVersion("4.6.0.0");
        httpParams.setOffset(offset + "");
        httpParams.setToken("api-c5a641d2f352220fae89db32b37fc4ab");
        buttons = new ArrayList<SchoolButton>();
        schoolButton = new SchoolButton(R.mipmap.ame, "我的课程");
        schoolButton1 = new SchoolButton(R.mipmap.ero, "学历");
        schoolButton2 = new SchoolButton(R.mipmap.japan, "奖学金");
        buttons.add(schoolButton);
        buttons.add(schoolButton1);
        buttons.add(schoolButton2);
        schoolButtonList = new SchoolButtonList(buttons);
    }

    @Override
    public void down() {
        offset = 0;
        httpParams.setOffset(offset + "");
        Task.getInstance().getSchoolList(Urls.SCHOOL_URL, httpParams, new Subscriber<List<School>>() {
            @Override
            public void onCompleted() {
                refreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<School> schools) {
                List<Visitable> list = new ArrayList<Visitable>();
                list.add(schoolButtonList);
                list.addAll(schools);
                adapter.addData(list, false);

            }
        });
    }

    @Override
    public void up() {

        offset += 10;
        httpParams.setOffset(offset + "");
        Task.getInstance().getSchoolList(Urls.SCHOOL_URL, httpParams, new Subscriber<List<School>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<School> schools) {
                List<Visitable> list = new ArrayList<Visitable>();
                if (schools != null && schools.size() > 0) {
                    list.addAll(schools);
                    adapter.addData(list, true);
                    chageLoadingState();
                } else {
                    chageFooterState(2);
                    isLoading = true;
                }
            }
        });

    }
}
