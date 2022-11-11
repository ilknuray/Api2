package test_data;

import java.util.HashMap;
import java.util.Map;

public class RestfultestData {
    public Map<String,Object>expectedDataMethod(String firstname,String lastname,Integer totalprice,Boolean depositpaid,Map<String,String>bookingdates){

        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("firstname",firstname);
        expectedData.put("lastname",lastname);
        expectedData.put("totalprice", totalprice);
        expectedData.put("depositpaid",depositpaid);
        expectedData.put("bookingdates",bookingdates);

        return expectedData;

    }
    public Map<String,String>booking(String checkin,String checkout){
        Map<String,String>bookingData=new HashMap<>();
        bookingData.put("checkin",checkin);
        bookingData.put("checkout",checkout);

        return bookingData;
    }

}
