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
        String url = "http://h5.putibaby.com/[VER]/master/jfsc_product?id=44";
        String path = url.replace("[VER]","4.6");
        System.out.print(path);

    }


}