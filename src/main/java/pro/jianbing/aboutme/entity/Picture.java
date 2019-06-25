package pro.jianbing.aboutme.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author DefaultAccount
 */
@Data
public class Picture implements Serializable {
    private static final long serialVersionUID = -7516927655911572040L;
    private String alt;
    private String pid;
    private String src;
    private String thumb;

    public Picture(String alt, String pid, String src, String thumb) {
        this.alt = alt;
        this.pid = pid;
        this.src = src;
        this.thumb = thumb;
    }
}
