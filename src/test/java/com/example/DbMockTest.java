package com.example;

import com.example.api.utils.XlsHelper;
import com.example.models.User;
import io.github.sskorol.core.DataSupplier;
import io.vavr.Tuple;
import io.vavr.Tuple3;
import one.util.streamex.StreamEx;
import org.testng.annotations.Test;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DbMockTest {

    /**
     * Example data supplier for Stream
     */

    @DataSupplier
    public Stream<User> getData() {
        return XlsHelper.helper.getUsers()
                .stream()
                .filter(e -> e.getAge() > 50)
                .sorted(Comparator.comparing(User::getAge))
                .limit(3);
    }

    @Test(dataProvider = "getData")
    public void testAllData(final User user) {
        Logger.getGlobal().log(Level.INFO, "Test is started");
        System.out.println(user);
    }


    /**
     * Example data supplier for List with transpose
     */

    @DataSupplier(transpose = true)
    public List<User> getTransposeData() {
        return XlsHelper.helper.getUsers();
    }

    @Test(dataProvider = "getTransposeData")
    public void testTransposeData(final User... user) {
        Logger.getGlobal().log(Level.INFO, "Test is started");
        System.out.println(Arrays.stream(user).count());
    }

    /**
     * Example data supplier for Map with prop flatMap
     */

    @DataSupplier(flatMap = true)
    public Map<Long, String> getMapData() {
        return XlsHelper.helper.getUsers().stream().collect(Collectors.toMap(User::getId, User::getName));
    }

    @Test(dataProvider = "getMapData")
    public void testGetMapData(Long id, String name) {
        System.out.println(String.format("Id is: %s , and name is %s", id, name));
    }


    /**
     * Example List with prop flatMap
     */

    @DataSupplier(flatMap = true)
    public List<List<String>> getListFlatMap() {
        List<List<String>> allData = new ArrayList<>();

        allData.add(Arrays.asList("list_1:value_1", "list1:value2", "list1:value3", "list1:value4"));
        allData.add(Arrays.asList("list_2:value_1", "list2:value2", "list2:value3", "list2:value4"));
        allData.add(Arrays.asList("list_3:value_1", "list3:value2", "list3:value3", "list3:value4"));

        return allData;
    }

    // use for false
    @Test(dataProvider = "getListFlatMap")
    public void testGetListFlatMapFalse(List<String> lists) {
        System.out.println(lists);
    }

    // use for true
    @Test(dataProvider = "getListFlatMap")
    public void testGetListFlatMapTrue(String value1, String value2, String value3, String value4) {
        System.out.println(String.format("VAL1: %s, VAL2: %s, VAL3: %s, VAL3: %s", value1, value2, value3, value4));
    }

    /**
     * Data provider for stream ex
     */

    @DataSupplier
    public StreamEx<User> getStreamExData() {
        return StreamEx.of(XlsHelper.helper.getUsers())
                .nonNull()
                .remove(e -> e.getAge() > 40)
                .prepend(new User("user", 23, "email", "passport"));
    }

    @Test(dataProvider = "getStreamExData")
    public void testGetStreamExData(final User user) {
        System.out.println(user);
    }

    /**
     * Data provider for Tuple
     */

    @DataSupplier(flatMap = true)
    public List<Tuple3<String, Boolean, User>> getTupleData() {
        return StreamEx.of(
                Tuple.of("String1", true, new User("user1", 21, "em1", "pass1")),
                Tuple.of("String2", false, new User("user2", 41, "em2", "pass2")),
                Tuple.of("String3", false, new User("user3", 45, "em3", "pass3"))
        ).toList();
    }

    @Test(dataProvider = "getTupleData")
    public void testTupleData(String string, boolean bool, User user) {
        System.out.println(String.format("String is: %s, Boolean is: %s, User is: %s", string, bool, user));
    }

}
