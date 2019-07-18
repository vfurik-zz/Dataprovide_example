package com.example;

import com.example.api.actions.user.UserAction;
import com.example.api.models.user.UserResponse;
import com.example.generated_assertions.api.asserts.user.UserResponseAssert;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertjTest {

    @Test
    public void assertJExample() {
        String passport = "PS23232";
        List<UserResponse> users = new UserAction().getUser(new UserAction.Params().withPassport(passport));
        assertThat(users).isNotEmpty();
        UserResponseAssert.assertThat(users.get(0)).hasPassport(passport + "1");
    }

}
