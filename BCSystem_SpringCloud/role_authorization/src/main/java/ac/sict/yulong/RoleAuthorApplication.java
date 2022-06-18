package ac.sict.yulong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("ac.sict.yulong.mapper")
@EnableFeignClients
public class RoleAuthorApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoleAuthorApplication.class, args);
    }
}
