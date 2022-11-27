package pojos;

public class DummyBodyPojo {
    /*
     {
            "status": "success",
            "data": {
                "employee_name": "Tom Hanks",
                "employee_salary": 111111,
                "employee_age": 23,
                "profile_image": "Perfect image",
                "id": 4891
            },
            "message": "Successfully! Record has been added."
        }
     */
    private String status;
    private DummyDataPojo data;
    private String message;

    public DummyBodyPojo(String status, DummyDataPojo data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public DummyBodyPojo() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyDataPojo getData() {
        return data;
    }

    public void setData(DummyDataPojo data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
