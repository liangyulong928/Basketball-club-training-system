package ac.sict.yulong.api;

import ac.sict.yulong.pojo.NoticeForMena;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("notice-redirect")


@RequestMapping("/notice")
public interface NoticeClient {

    /*
    * 功能：根据管理员ID获取管理员所有通知
    * */
    @GetMapping("/getNoticeMenuList/{id}")
    public List<NoticeForMena> getNoticeMenuList(@PathVariable String id);
}
