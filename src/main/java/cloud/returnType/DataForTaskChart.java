package cloud.returnType;


import lombok.Data;

import java.util.Date;

@Data
public class DataForTaskChart {

    private String taskKey;

    private String ownerName;

    private String title;

    private String content;

    private String level;

    private Date date;
}
