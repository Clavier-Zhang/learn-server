package cloud.entities;

import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator( name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String phoneNumber;

    private String password;

    private String username;

    private String email;

    private Integer follower;

    private Integer following;

    private Integer post;

    public User() {

    }

    public User(String phoneNumber, String password, String username) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.username = username;
        this.post = 0;
        this.follower = 0;
        this.following = 0;
    }




}