package cloud.entities;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class ConfessPost {

    private String id;

    private String authorId;

    private String authorAvatar;

    private String type;

    private Boolean anonymous;

    private Timestamp time;

    private Integer comments;

    private Integer like;

    private String article;

}
