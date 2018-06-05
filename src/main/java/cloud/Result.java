package cloud;

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
        this.user = user;
    }

    String status;

    String description;

    Object user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
