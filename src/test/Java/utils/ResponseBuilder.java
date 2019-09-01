package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class ResponseBuilder {

    public static Response getResponse(RequestSpecification requestSpecification, String query, String queryValue){
        Response response;
        response = given()
                .queryParam(query, queryValue)
                .spec(requestSpecification)
                .get()
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .response();
        return response;
    }
}
