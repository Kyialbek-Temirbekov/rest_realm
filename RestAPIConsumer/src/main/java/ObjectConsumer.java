import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class ObjectConsumer {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "Merlin");
        jsonToSend.put("job", "Police");

        HttpEntity<Map<String,String>> request = new HttpEntity<>(jsonToSend);

        String url = "https://reqres.in/api/users";
        UserResponse response = restTemplate.postForObject(url, request, UserResponse.class);

        System.out.println(response.getId());
        System.out.println(response.getName());
        System.out.println(response.getJob());
        System.out.println(response.getCreatedAt());
    }
}
