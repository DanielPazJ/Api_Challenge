package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class ResponseCreator {

    private static Response getBaseResponse(Response response){
        return response
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .response();
    }

    static Response createGetResponse(RequestSpecification requestSpecification){
        Response response = given().spec(requestSpecification).get();
        response = getBaseResponse(response);
        return response;
    }


    static Response createPostResponse(RequestSpecification requestSpecification){
        Response response = given().spec(requestSpecification).post();
        response = getBaseResponse(response);
        return response;
    }

    static Response createPutResponse(RequestSpecification requestSpecification){
        Response response = given().spec(requestSpecification).put();
        response = getBaseResponse(response);
        return response;
    }

    static Response createDeleteResponse(RequestSpecification requestSpecification){
        Response response = given().spec(requestSpecification).delete();
        response = getBaseResponse(response);
        return response;
    }
}
