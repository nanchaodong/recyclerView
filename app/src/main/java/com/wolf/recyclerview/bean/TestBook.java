package com.wolf.recyclerview.bean;

import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.google.gson.annotations.Expose;
import com.orm.dsl.Table;
import com.wolf.recyclerview.bean.base.DataBaseBean;
import com.wolf.recyclerview.presenter.TypeFactory;

/**
 * Created by nanchaodong on 2017/3/24.
 */
@Table(name = "TEST_BOOK")
public class TestBook extends DataBaseBean {
    private static final String TYPE = "TestBook";
    @Expose
    private String title;
    @Expose
    private String edition;
    @Expose
    private String name;
    @Expose
    private String age;
    @Expose
    private String people;

    public final  ObservableField<String> obName = new ObservableField<String>();


    public TestBook(String title, String edition, String name, String age, String people) {
        this.title = title;
        this.edition = edition;
        this.name = name;
        this.age = age;
        this.people = people;
        this.obName.set(name);
    }

    public TestBook() {
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return 0;
    }

    @Override
    public String type() {
        return TYPE;
    }

    @Override
    public String toString() {
        return "TestBook{" +
                "title='" + title + '\'' +
                ", edition='" + edition + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
    public void obser(){
        obName.set(name);
    }

}
