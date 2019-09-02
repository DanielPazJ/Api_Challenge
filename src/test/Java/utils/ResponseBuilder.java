package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class ResponseBuilder {

    public static Response getResponse(RequestSpecification requestSpecification, String requestType){

        Response response = null;
        if(requestType.equals("get")){
            response = given().spec(requestSpecification).get();
        }else if(requestType.equals("post")){
            response = given().spec(requestSpecification).post();
        }
        if(response != null){
            response.then()
                    .assertThat()
                    .statusCode(SC_OK)
                    .extract()
                    .response();
        }
        return response;
    }

}

