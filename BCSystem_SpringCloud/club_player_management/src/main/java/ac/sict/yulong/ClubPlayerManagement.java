package ac.sict.yulong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("ac.sict.yulong.mapper")
public class ClubPlayerManagement {
    public static void main(String[] args) {
        SpringApplication.run(ClubPlayerManagement.class, args);
    }
}
