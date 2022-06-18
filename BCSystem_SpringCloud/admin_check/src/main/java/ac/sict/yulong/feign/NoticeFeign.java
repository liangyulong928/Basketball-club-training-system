package ac.sict.yulong.feign;


import ac.sict.yulong.pojo.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("notice-redirect")
@RequestMapping("notice")
public interface NoticeFeign {
    @GetMapping("/signup/{id}")
    public int signupNotice(@PathVariable String id);
}
