package requests;

import java.util.List;

public abstract class GetBaseRequest<Model> {

    protected final String ENDPOINT;

    protected final String PATH;

    protected GetBaseRequest(String endPoint, String path) {
        this.ENDPOINT = endPoint;
        this.PATH = path;
    }

    public String getEndPoint() {
        return ENDPOINT;
    }

    abstract public void sendRequest();

    abstract public void sendInvalidRequest();

    abstract public int getStatusCode();

    abstract public List<Model> getModels();

    abstract public String getContentType();

    public abstract long getResponseTime();
}
