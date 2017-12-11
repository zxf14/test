package online.exam.datacenter.jerseyservice;

import java.util.HashMap;
import java.util.Map;

public class EndpointResponse {
    private String status;
    private Map<String, Object> data;

    EndpointResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void putDate(String name, Object value){
        if (data == null) data = new HashMap();
        data.put(name, value);
    }

    @Override
    public String toString() {
        return "EndpointResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
