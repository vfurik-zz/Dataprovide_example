package com.example;

import com.example.models.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlainTestNgProvider {

    /* *********************************************************************************************************** */

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"Cedric", new Integer(36), new User("test1", 23, "test2", "test3")},
                {"Anne", new Integer(37), new User("test11", 23, "test22", "test33")},
        };
    }

    @Test(dataProvider = "test1")
    public void verifyData1(String str, Integer in, User user) {
        System.out.println(str + " " + in + " " + user);
    }

    /* *********************************************************************************************************** */


    @DataProvider(name = "test2")
    public Object[] createData() {
        return new User[]{
                new User("test1", 23, "test2", "test3"),
                new User("test11", 23, "test22", "test33")
        };
    }

    @Test(dataProvider = "test2")
    public void verifyData2(User user) {
        System.out.println(user);
    }

    /* *********************************************************************************************************** */


    @DataProvider(name = "DataProviderIterator")
    public Iterator<Object> users() {
        List users = Arrays.asList(
                new User("test1", 23, "test2", "test3"),
                new User("test11", 23, "test22", "test33"),
                new User("test111", 23, "test222", "test333")
        );
        return users.iterator();
    }


    @Test(dataProvider = "DataProviderIterator")
    public void verifyData3(User user) {
        System.out.println(user);
    }

    /* *********************************************************************************************************** */

    @DataProvider(name = "dataMaps")
    public Iterator<Object[]> dataMaps() {
        List<Map<String, String>> lom = new ArrayList();
        Map<String, String> map1 = new HashMap();
        Map<String, String> map2 = new HashMap();
        map1.put("name1", "value1");
        map1.put("name2", "value2");

        map2.put("name11", "value11");
        map2.put("name22", "value22");

        lom.add(map1);
        lom.add(map2);
        Collection<Object[]> dp = new ArrayList();
        for (Map<String, String> map : lom) {
            dp.add(new Object[]{map});
        }
        return dp.iterator();
    }

    @Test(dataProvider = "dataMaps")
    public void verifyData4(Map<String, String> map) {
        System.out.println(map);
    }


}
