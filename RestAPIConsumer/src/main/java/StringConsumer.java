import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class StringConsumer {
    public static void main(String[] args) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "Arthur");
        jsonToSend.put("job", "Swordsman");

        HttpEntity<Map<String,String>> request = new HttpEntity<>(jsonToSend);

        String url = "https://reqres.in/api/users";
        String response = restTemplate.postForObject(url, request, String.class);

//        String url = "https://reqres.in/api/users/2";
//        String response = restTemplate.getForObject(url, String.class);

        System.out.println(response);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response);

        System.out.println("Name: " + node.get("name"));
        System.out.println("Job: " + node.get("job"));
        System.out.println("Created at: " + node.get("createdAt"));
    }
}
