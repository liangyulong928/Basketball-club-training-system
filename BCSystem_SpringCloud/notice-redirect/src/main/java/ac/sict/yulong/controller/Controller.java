package ac.sict.yulong.controller;

import ac.sict.yulong.mapper.AdminMapper;
import ac.sict.yulong.mapper.NoticeForMenaMapper;
import ac.sict.yulong.mapper.NoticeMapper;
import ac.sict.yulong.pojo.Admin;
import ac.sict.yulong.pojo.Notice;
import ac.sict.yulong.pojo.NoticeForMena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/notice")
public class Controller {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private NoticeForMenaMapper noticeForMenaMapper;

    @GetMapping("/signup/{id}")
    public int signupNotice(@PathVariable String id){
        Admin admin = adminMapper.selectByPrimaryKey(id);
        String accept_id = adminMapper.getAccpet(admin.getOffice()).get(0).getId();
        Date date = new Date(System.currentTimeMillis());
        return noticeMapper.insert(new Notice(1, "新用户注册", admin.getId(), accept_id, new Timestamp(date.getTime()),null));
    }

    @GetMapping("/getNoticeMenuList/{id}")
    public List<NoticeForMena> getNoticeMenuList(@PathVariable String id){
        return noticeForMenaMapper.getNoticeList(id);
    }

    @GetMapping("/acceptNotice/{id}")
    public int acceptNotice(@PathVariable String id){
        Date date = new Date(System.currentTimeMillis());
        Timestamp timestamp = new Timestamp(date.getTime());
        return noticeMapper.acceptNewRole(id, timestamp);
    }

    @GetMapping("/confuseRole/{id}")
    public int confuseRole(@PathVariable String id){
        return noticeMapper.confuseRoleApply(id);
    }

}
