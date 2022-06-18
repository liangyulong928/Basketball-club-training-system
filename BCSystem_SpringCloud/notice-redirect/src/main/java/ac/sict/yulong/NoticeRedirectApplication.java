package ac.sict.yulong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("ac.sict.yulong.mapper")
public class NoticeRedirectApplication {
    public static void main(String[] args) {
        SpringApplication.run(NoticeRedirectApplication.class, args);
    }
}
