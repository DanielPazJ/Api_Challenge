package utils;

import helpers.PropertiesHelper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

public class RequestBuilder {

    private RequestSpecBuilder requestSpecBuilder  = new RequestSpecBuilder();

    public RequestBuilder(){
        PropertiesHelper propertiesHelper = new PropertiesHelper();
        String baseUri = propertiesHelper.getProperty("BASE_URI");
        this.requestSpecBuilder
                .setBaseUri(baseUri)
                .setAccept(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + Share.getShare("token"));
    }

    public RequestBuilder withBasePath(String basePath){
        this.requestSpecBuilder.setBasePath(basePath);
        return this;
    }

    public RequestBuilder withContentType(ContentType contentType){
        this.requestSpecBuilder.setContentType(contentType);
        return this;
    }

    public RequestBuilder withContentParams(HashMap<String, String> content){
        this.requestSpecBuilder.addParams(content);
        return this;
    }

    public RequestBuilder withQueryParams (String key, String content){
        this.requestSpecBuilder.addQueryParam(key,content);
        return this;
    }

    public RequestSpecification build(){
        return this.requestSpecBuilder.build();
    }
}
