package pro.jianbing.aboutme.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author DefaultAccount
 */
@Data
public class Like implements Serializable {
    private static final long serialVersionUID = -6683776601547996277L;
    private String id;
    private Timestamp likeTime;
    private String person;
    private String ip;
}
