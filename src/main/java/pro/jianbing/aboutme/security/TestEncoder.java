package pro.jianbing.aboutme.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 用于生成加密的密码
 * @author DefaultAccount
 */
public class TestEncoder {
    public static void main(String[] args) {
        String password = "test";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        String enPassword = encoder.encode(password);
        System.out.println(enPassword);
    }
}
