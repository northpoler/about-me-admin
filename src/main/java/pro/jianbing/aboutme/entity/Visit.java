package pro.jianbing.aboutme.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author DefaultAccount
 */
@Data
@Entity
@Table(name="visit")
public class Visit implements Serializable {
    private static final long serialVersionUID = 1856503166435080552L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ip;
    private String address;
    @Column(name = "visit_time")
    private LocalDateTime visitTime;
    private String mark;
}
