package com.wolf.recyclerview;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wolf.recyclerview.bean.Result;
import com.wolf.recyclerview.bean.TestBook;

import org.junit.Test;

import java.lang.reflect.Type;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addSq() {
        String json = "{data:{\"name\":\"nanchaodong\",\"title\":\"ashffhj\",\"age\":\"12\"}}";
        Util<TestBook> testBookUtil = new Util<TestBook>();
        Result<TestBook> result = testBookUtil.gettResult(json);
        System.out.print(result.getData().toString());

    }
    private class Util<T>{
        private Result<T> tResult;
        private Type type;
        private Gson gson;
        private T t;
        public Util(){
            gson = new Gson();
            type = new TypeToken<T>(){

            }.getType();
        }
        public Result<T> gettResult(String a){
            return gson.fromJson(a, type);
        }
    }

}