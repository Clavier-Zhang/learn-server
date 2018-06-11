package cloud.entities;

import lombok.Data;

@Data
public class Result {


    public Result(String status) {
        this.status = status;
    }

    public Result(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public Result(String status, String description, Object user) {
        this.status = status;
        this.description = description;
        this.detail = user;
    }

    String status;

    String description;

    Object detail;

}
