package pro.jianbing.aboutme.pojo.po;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class Countdown implements Serializable {
    private static final long serialVersionUID = -283493060555132214L;
    private String title;
    private LocalDateTime endTime;
    private Integer days;
}
