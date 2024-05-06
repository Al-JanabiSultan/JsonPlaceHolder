package requests;

import dto.PostDTO;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Log4jLogger;

import java.util.List;


public class GetPostsRequest extends GetBaseRequest<PostDTO> {

    private static final Logger LOGGER = Log4jLogger.ClassLogger();
    //These constants could be in a seperate environmental file to have one file for all properties/Or a factory class-
    //If several environments were available, these would make maintenance and potential modifications easier
    protected static final String ENDPOINT = "https://jsonplaceholder.typicode.com";
    protected static final String PATH = "/posts";
    protected String invalidPath = "/posters";
    private Response response;
    private RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(ENDPOINT)
                .setBasePath(PATH)
                .build();

    public GetPostsRequest() {
        super(ENDPOINT, PATH);
    }

    private RequestSpecification getSpecifications() {
        return RestAssured.given().spec(requestSpecification);
    }

    public boolean isReachable() {
        if (getSpecifications().get().getStatusCode() == 200) {
            LOGGER.info(ENDPOINT + " is reachable");
            return true;
        } else
            return false;
    }

    @Override
    public void sendRequest() {
        LOGGER.info("Sending a get request to:" + ENDPOINT);;
        response = getSpecifications().get();
    }

    @Override
    public void sendInvalidRequest() {
        LOGGER.info("Sending a get request to:" + ENDPOINT + invalidPath);
        response = RestAssured.given()
                .baseUri(ENDPOINT)
                .basePath(invalidPath)
                .get();
    }

    @Override
    public int getStatusCode() {
        int statusCode = response.getStatusCode();
        LOGGER.info("The status code is " + statusCode);
        return response.getStatusCode();
    }

    @Override
    public List<PostDTO> getModels() {
        List<PostDTO> postDTOS = response
                .jsonPath()
                .getList("", PostDTO.class);
        LOGGER.info("Number of posts is: " + postDTOS.size());
        return postDTOS;
    }

    @Override
    public String getContentType() {
        String contentType = response.getContentType();
        LOGGER.info("Actual content type of the response:" + contentType);
        return contentType;
    }

    @Override
    public long getResponseTime() {
        LOGGER.info("Response time is "+ response.getTime());
        return response.getTime();
    }

}
