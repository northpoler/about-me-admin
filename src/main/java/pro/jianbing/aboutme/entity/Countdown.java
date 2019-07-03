package pro.jianbing.aboutme.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 李建兵
 */
@Data
public class Countdown implements Serializable {
    private static final long serialVersionUID = -1811772377015660792L;
    private String id;
    private String title;
    private LocalDateTime endTime;
    private Integer days;
}
