package ac.sict.yulong.controller;


import ac.sict.yulong.api.NoticeClient;
import ac.sict.yulong.pojo.NoticeForMena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notice")
@CrossOrigin
public class NoticeController {

    @Autowired
    private NoticeClient noticeClient;

    @RequestMapping("/getNoticeMenuList")
    public List<NoticeForMena> getMenuNotice(@RequestParam String id){
        return noticeClient.getNoticeMenuList(id);
    }
}
