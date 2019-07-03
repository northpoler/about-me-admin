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
@Table(name="keyword")
public class Keyword implements Serializable {
    private static final long serialVersionUID = -684212631938319120L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String keyword;
    @Column(name = "search_time")
    private LocalDateTime searchTime;
    private String ip;
    private String mark;
}
