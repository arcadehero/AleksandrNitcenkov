package com.epam.tc.nitcenkov.hw9.service;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

import com.epam.tc.nitcenkov.hw9.util.Util;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

public class BasicService {

    private RequestSpecification requestSpecification;

    public BasicService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        requestSpecification = new RequestSpecBuilder()
            .setBaseUri(Util.BASE_URI)
            .addQueryParam("key", Util.KEY)
            .addQueryParam("token", Util.TOKEN)
            .setContentType(ContentType.JSON)
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .build();
    }

    public BasicService(String idList) {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        requestSpecification = new RequestSpecBuilder()
            .setBaseUri(Util.BASE_URI)
            .addQueryParam("idList", idList)
            .addQueryParam("key", Util.KEY)
            .addQueryParam("token", Util.TOKEN)
            .setContentType(ContentType.JSON)
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .build();
    }

    public Response requestWithoutParams(String uri, Method method) {
        return
            given()
                .spec(requestSpecification)
                .when()
                .request(method, Util.BASE_URI + uri)
                .then()
                .statusCode(SC_OK)
                .extract().response();
    }

    public Response requestWithParams(String uri, Method method, Map<String, String> params) {
        return
            given()
                .spec(requestSpecification)
                .queryParams(params)
                .when()
                .request(method, Util.BASE_URI + uri)
                .then()
                .statusCode(SC_OK).extract().response();
    }
}
