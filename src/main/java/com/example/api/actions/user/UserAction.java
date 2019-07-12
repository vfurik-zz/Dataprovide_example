package com.example.api.actions.user;

import com.example.api.actions.BaseAction;
import com.example.api.models.user.UserResponse;
import io.qameta.allure.Step;
import io.restassured.RestAssured;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAction extends BaseAction {

    @Step
    public List<UserResponse> getUser(Params params) {
        UserResponse[] users = RestAssured.given(this.requestSpecBuilder
                .setBasePath("/users")
                .build())
                .when()
                .queryParams(params.getParams())
                .get()
                .then().extract().response()
                .as(UserResponse[].class);
        return Arrays.asList(users);
    }


    public static class Params {

        public Params() {
        }

        private Map<String, Object> params = new HashMap<>();

        public Params withName(String name) {
            this.params.put("name", name);
            return this;
        }

        public Params withEmail(String email) {
            this.params.put("email", email);
            return this;
        }

        public Params withPassport(String passport) {
            this.params.put("passport", passport);
            return this;
        }

        public Params withMinAge(int minAge) {
            this.params.put("minAge", minAge);
            return this;
        }

        public Params withMaxAge(int maxAge) {
            this.params.put("maxAge", maxAge);
            return this;
        }

        public Map<String, Object> getParams() {
            return params;
        }

        @Override
        public String toString() {
            return "Params{" +
                    "params=" + params +
                    '}';
        }
    }

}
