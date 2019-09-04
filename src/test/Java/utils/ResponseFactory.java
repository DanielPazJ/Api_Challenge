package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseFactory {

    public static Response createResponse( RequestSpecification requestSpecification, String type){
        Response response ;
        switch (type) {
            case "get":
                response = ResponseCreator.createGetResponse(requestSpecification);
                break;
            case "post":
                response = ResponseCreator.createPostResponse(requestSpecification);
                break;
            case "put":
                response = ResponseCreator.createPutResponse(requestSpecification);
                break;
            case "delete":
                response = ResponseCreator.createDeleteResponse(requestSpecification);
                break;
            default:
                throw new IllegalStateException("Unexpected response type: " + type);
        }
        return response;

    }

}
