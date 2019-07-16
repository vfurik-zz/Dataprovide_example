package com.example;

import com.example.api.actions.user.UserAction;
import com.example.api.models.user.UserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertjTest {

    @Test
    public void assertjTest() {
        String passport = "PS23232";
        List<UserResponse> users = new UserAction().getUser(new UserAction.Params().withPassport(passport));
        assertThat(users).isNotEmpty();

        Assert.assertEquals(users.get(0).getPassport(), passport + "1", "Passport should be: " + passport + " , but was: " + users.get(0).getPassport());

    }

}
