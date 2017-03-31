package com.wolf.recyclerview;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wolf.recyclerview.bean.Nurse;
import com.wolf.recyclerview.bean.Result;
import com.wolf.recyclerview.bean.TestBook;

import org.junit.Test;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

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
        String json1 = "{data:[{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"}]}";
        String json2 = "{data:[{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"}]}";

        Gson gson = new Gson();
        Result<List<Nurse>> nurseResult = gson.fromJson(json2, new TypeToken<Result<List<Nurse>>>(){}.getType());
        System.out.print(nurseResult);

    }


}