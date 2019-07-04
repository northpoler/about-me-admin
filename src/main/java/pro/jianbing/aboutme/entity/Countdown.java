package pro.jianbing.aboutme.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 李建兵
 */
@Data
@Entity
@Table(name = "countdown")
public class Countdown implements Serializable {
    private static final long serialVersionUID = -1811772377015660792L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String title;
    @Column(name = "end_time")
    private LocalDateTime endTime;
    private Integer days;
}
