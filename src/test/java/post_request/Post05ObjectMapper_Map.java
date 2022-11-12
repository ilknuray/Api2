package post_request;

import base_urls.JsonplaceholderBaseUrl;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Post05ObjectMapper_Map extends JsonplaceholderBaseUrl {
      /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,"
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */
    @Test
    public void post05() throws IOException {
        spec.pathParam("first","todos");
        //send then request and get the response
        String jsonString="{\n" +
                "                                    \"userId\": 55,\"\n" +
                "                                    \"title\": \"Tidy your room\",\n" +
                "                                    \"completed\": false,\n" +
                "                                    \"id\": 201\n" +
                "                                    }";
        Map<String,Object>expectedData= new ObjectMapper().readValue("", HashMap.class);
    }
}
