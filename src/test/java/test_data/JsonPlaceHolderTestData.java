package test_data;


import java.util.HashMap;
import java.util.Map;



public class JsonPlaceHolderTestData {
    public Map<String,Object> expectedData(Integer userId, String title, Boolean completed){


//Set The Expected Data ==> Payload

        Map<String, Object> expectedDataMap = new HashMap<>();
        if (userId==null){
            expectedDataMap.put("userId", userId);
        }
        if (title==null){
            expectedDataMap.put("title", title);
        }
        if (completed==null){
            expectedDataMap.put("completed", completed);
        }




        return expectedDataMap;


    }
}