package com.example.api.asserts.user;

import com.example.api.models.user.UserResponse;
import org.assertj.core.api.AbstractAssert;

public class UserAssert extends AbstractAssert<UserAssert, UserResponse> {

    public UserAssert(UserResponse userResponse) {
        super(userResponse, UserAssert.class);
    }
}
