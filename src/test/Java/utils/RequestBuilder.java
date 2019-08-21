package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

    private RequestSpecBuilder requestSpecBuilder;
    private RequestSpecification requestSpecification;

    public RequestBuilder(String basePath, String path) {
        requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://sandbox.tradier.com/v1")
                .setBasePath(basePath + "/" + path)
                .addHeader("Authorization", "Bearer " + PropertiesHelper.Token())
                .setAccept(ContentType.JSON);
        requestSpecification = requestSpecBuilder.build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
