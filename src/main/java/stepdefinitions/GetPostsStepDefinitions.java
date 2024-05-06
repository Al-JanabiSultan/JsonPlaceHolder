package stepdefinitions;

import dto.PostDTO;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import requests.GetPostsRequest;

import java.util.List;


public class GetPostsStepDefinitions {

    protected static final Logger LOGGER = LogManager.getLogger("stepdefinitions.GetStepDefinitions");
    private GetPostsRequest getPostsRequest;

    @Before
    public void setup() {
        getPostsRequest = new GetPostsRequest();
    }

    @Given("the JSONPlaceholder is reachable")
    public void theJSONPlaceholderIsReachable() {
        Assert.assertTrue(getPostsRequest.getEndPoint() + " is not reachable!", getPostsRequest.isReachable());
    }


    @When("the user sends a GET request")
    public void theUserSendsAGETRequest() {
        getPostsRequest.sendRequest();
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        Assert.assertEquals("The status code is invalid!", expectedStatusCode, getPostsRequest.getStatusCode());
    }

    @And("the response contains {int} posts")
    public void theResponseContainsPosts(int expectedPosts) {
        List<PostDTO> postDTOS = getPostsRequest.getModels();
        Assert.assertEquals("The number of posts is invalid!", expectedPosts, postDTOS.size());
    }

    @And("the response should be in JSON format")
    public void theResponseShouldBeInJSONFormat() {
        String actualContentType = getPostsRequest.getContentType();
        String expectedContentType = "application/json; charset=utf-8";
        Assert.assertEquals("This content type isn't JSON", expectedContentType, actualContentType);
    }



    @And("each post should have correct fields")
    public void eachPostShouldHaveCorrectFields() {
        List<PostDTO> postDTOS = getPostsRequest.getModels();
        LOGGER.info("Verifying the fields of posts");
        for (int i = 0; i < postDTOS.size(); i++) {
            PostDTO postDTO = postDTOS.get(i);
            Assert.assertTrue("Post " + i + " has an invalid 'id' field.", postDTO.getId() >= 0);
            Assert.assertTrue("Post " + i + " has an invalid 'userId' field.", postDTO.getUserId() >= 0);
            Assert.assertFalse("Post " + i + " has an invalid 'title' field.", postDTO.getTitle().isEmpty());
            Assert.assertFalse("Post " + i + " has an invalid 'body' field.", postDTO.getBody().isEmpty());
        }
    }

    @When("the user sends a GET request to the invalid endpoint")
    public void iSendAGETRequestToTheInvalidEndpoint() {
        getPostsRequest.sendInvalidRequest();
    }

    @Then("the response should indicate a client error")
    public void theResponseShouldIndicateAClientOrServerError() {
        int expectedStatusCode = 404;
        int actualStatusCode = getPostsRequest.getStatusCode();
        Assert.assertEquals("The status code is invalid!", expectedStatusCode, actualStatusCode);
    }

    @Then("the response time should be less than {long} milliseconds")
    public void theResponseTimeShouldBeLessThanMilliseconds(long expectedResponseTime) {
        long actualResponseTime = getPostsRequest.getResponseTime();
        Assert.assertTrue("The response time is higher than expected!", expectedResponseTime>actualResponseTime);
    }

    @Then("the user can find the name of the post publisher")
    public void theUserCanFindTheNamePostPublisher(){

    }
}
