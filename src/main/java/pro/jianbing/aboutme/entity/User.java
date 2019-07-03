package pro.jianbing.aboutme.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author 李建兵
 */
@Data
@Entity
@Table(name="user")
public class User implements Serializable {
    private static final long serialVersionUID = -6683776601547996277L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String username;
    private String password;
    /**
     * 角色类型：0 我自己 1 普通用户
     */
    private String role;
    private String phone;
    /**
     * 创建时间
     */
    private LocalDateTime created;
    /**
     * 最近一次登陆的IP
     */
    @Column(name = "last_IP")
    private String lastIP;
    /**
     * 最近一次登陆的时间
     */
    @Column(name = "last_time")
    private LocalDateTime lastTime;
    /**
     * 标记：0正常 1 删除
     */
    private String mark;
}
