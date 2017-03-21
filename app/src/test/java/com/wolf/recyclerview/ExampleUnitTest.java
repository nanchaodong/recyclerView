package com.wolf.recyclerview;

import android.text.AndroidCharacter;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import com.wolf.recyclerview.bean.Advert;
import com.wolf.recyclerview.bean.Banner;
import com.wolf.recyclerview.bean.Top;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
    public void json() throws MalformedJsonException {
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("username","nanchaodong");
        maps.put("password","123456");
        Gson gson = new Gson();
        String str = gson.toJson(maps);
        System.out.print(str);

    }
}