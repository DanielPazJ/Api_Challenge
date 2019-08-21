package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

    private RequestSpecBuilder requestSpecBuilder;
    private RequestSpecification requestSpecification;

    public RequestBuilder(String basePath) {
        requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://sandbox.tradier.com/v1")
                .setBasePath(basePath)
                .setAccept(ContentType.JSON);
        requestSpecification = requestSpecBuilder.build();
    }

    public  RequestBuilder request(String baseUri,String basePath){

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setBasePath(basePath)
                .setAccept(ContentType.JSON)
                .build();
        return this;
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
