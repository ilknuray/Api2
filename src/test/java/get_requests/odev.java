package get_requests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class odev {
    /*
Given
    https://automationexercise.com/api/productsList
When
    User sends a GET Request to the url
Then
    HTTP Status Code should be 200
And
    Content Type should be "text/html; charset=utf-8"
And
    Status Line should be HTTP/1.1 200 OK
And
     There must be 12 Women, 9 Men, 13 Kids usertype in products
  */

    @Test
    public void test01(){

        //set the url
        String url="https://automationexercise.com/api/productsList";

        //send get request and get the response
        Response response=given().when().get(url);
       // response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();

        //do assartion
        assertEquals(200,response.statusCode());
        assertEquals("text/html; charset=utf-8",response.contentType());
        assertEquals("HTTP/1.1 200 OK",response.statusLine());

        List<String> userType = jsonPath.getList("products.category.usertype.usertype");
        int women=0;
        int man=0;
        int kids=0;

        for (int i = 0; i <userType.size() ; i++) {
            if (userType.get(i).equals("Women")) women++;
            if (userType.get(i).equals("Men")) man++;
            if (userType.get(i).equals("Kids")) kids++;
        }
            System.out.println("women : "+women +"man : "+man + "kids : " +kids);

            assertEquals(12,women);
            assertEquals(9,man);
            assertEquals(13,kids);





    }
}
