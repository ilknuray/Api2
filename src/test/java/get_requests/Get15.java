package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponseBodyPojo;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get15 extends RestfulBaseUrl {
      /*
        Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
               {
    "firstname": "Sally",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    },
    "additionalneeds": "Breakfast"
}
     */
    @Test
    public void get15(){
        spec.pathParams("first","booking","second",22);

        //set the expected data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2013-02-23","2014-10-23");
        BookingPojo expectedData=new BookingPojo("Sally","Brown",111,true,bookingDatesPojo,"Breakfast");
        //sen the request
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion
        BookingPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(), BookingPojo.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getBookingdates(),actualData.getBookingdates());


    }
}
