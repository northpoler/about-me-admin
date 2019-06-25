package pro.jianbing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@MapperScan("pro.jianbing.aboutme.mapper")
@SpringBootApplication
public class AboutMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AboutMeApplication.class, args);
    }

}
