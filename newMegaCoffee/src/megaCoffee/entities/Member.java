package megaCoffee.entities;

public class Member {
    private String id;
    private int password;
    private int stamp;

    public Member(String id, int password, int stamp) {
        this.id = id;
        this.password = password;
        this.stamp = stamp;
    }

    public Member() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getStamp() {
        return stamp;
    }

    public void setStamp(int stamp) {
        this.stamp = stamp;
    }
}
