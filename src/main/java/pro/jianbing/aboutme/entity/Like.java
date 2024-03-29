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
@Table(name="likes")
public class Like implements Serializable {
    private static final long serialVersionUID = -6683776601547996277L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "like_time")
    private LocalDateTime likeTime;
    private String person;
    private String ip;
}
