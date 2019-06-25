package pro.jianbing.aboutme.pojo.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1961294209487146933L;
    private String username;
    private String password;
}
