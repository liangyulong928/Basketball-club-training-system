package ac.sict.yulong.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("notice-redirect")
@RequestMapping("/notice")
public interface NoticeClient {

    @GetMapping("/acceptNotice/{id}")
    public int acceptNotice(@PathVariable String id);

    @GetMapping("/confuseRole/{id}")
    public int confuseRole(@PathVariable String id);

}
