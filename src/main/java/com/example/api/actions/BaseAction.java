package com.example.api.actions;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public abstract class BaseAction {

    static {
        RestAssured.filters(
                new AllureRestAssured(),
                new ResponseLoggingFilter());
    }

    protected RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

    protected BaseAction() {
        requestSpecBuilder
                .setBaseUri("http://localhost:8080")
                .setRelaxedHTTPSValidation()
                .setUrlEncodingEnabled(true)
                .log(LogDetail.ALL)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON);
    }


}
