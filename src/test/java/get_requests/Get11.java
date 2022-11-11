package get_requests;

import base_urls.GorestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get11 extends GorestBaseUrl {
     /*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Fr. Paramartha Bandopadhyay", "Pres. Amarnath Dhawan" and "Sujata Chaturvedi" are among the users
        And
            The female users are less than or equals to male users
     */

    @Test
    public void test01() {
        //set the url
        spec.pathParam("first", "users");

        //send the request
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //do assertion
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("meta.pagination.limit"), 10);
        assertEquals(jsonPath.getString("meta.pagination.links.current"), "https://gorest.co.in/public/v1/users?page=1");
        //assertEquals(jsonPath.getString("data.status"),hasItem("active"));
        //kadin erkek sayilari java
        List<String> genders = response.jsonPath().getList("data.gender");
        int female = 0;
        for (String w : genders) {
            if (w.equalsIgnoreCase("female")) {
                female++;
            }

        }
        assertTrue(female <= genders.size() - female);
//kadin ve erkek sayilarini groovy ile bulalim
        List<String> femaleNames = response.jsonPath().getList("data.findAll{it.gender=='female'}.name");
        System.out.println(femaleNames);


    }


}
