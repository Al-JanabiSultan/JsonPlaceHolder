package requests;

import dto.UserDTO;

import java.util.List;

public class GetUsersRequest extends GetBaseRequest<UserDTO> {


    private final String endPoint = "https://jsonplaceholder.typicode.com";
    private final String path = "/users";

    protected GetUsersRequest(String endPoint, String path) {
        super(endPoint, path);
    }

    @Override
    public void sendRequest() {

    }

    @Override
    public void sendInvalidRequest() {

    }

    @Override
    public int getStatusCode() {
        return 0;
    }

    @Override
    public List<UserDTO> getModels() {
        return List.of();
    }

    @Override
    public String getContentType() {
        return "";
    }

    @Override
    public long getResponseTime() {
        return 0;
    }
}
