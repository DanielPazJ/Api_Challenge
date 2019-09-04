package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.apache.http.HttpStatus.SC_OK;

public class ResponseCreator {

    private Response getResponse(Response response){
        return response
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .response();
    }

    public Response createGetResponse(RequestSpecification requestSpecification){
        Response response= requestSpecification
                .get();
        response = getResponse(response);
        return response;
    }


    public Response createPostResponse(RequestSpecification requestSpecification){
        Response response = requestSpecification
                .post();
        response = getResponse(response);
        return response;
    }

    public Response createPutResponse(RequestSpecification requestSpecification){
        Response response = requestSpecification
                .put();
        response = getResponse(response);
        return response;
    }

    public Response createDeleteResponse(RequestSpecification requestSpecification){
        Response response = requestSpecification
                .delete();
        response = getResponse(response);
        return response;
    }
}
