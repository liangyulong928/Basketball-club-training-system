package ac.sict.yulong;


import ac.sict.yulong.mapper.NoticeForMenaMapper;
import ac.sict.yulong.mapper.NoticeMapper;
import ac.sict.yulong.pojo.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Timestamp;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class Test1 {

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private NoticeForMenaMapper noticeForMenaMapper;

    @Test
    public void Test1(){
        java.sql.Date date= new java.sql.Date(System.currentTimeMillis());
        System.out.println(new java.sql.Timestamp(date.getTime()));
    }

    @Test
    public void Test2(){
        Date date = new Date(System.currentTimeMillis());

        System.out.println(noticeMapper.insert(new Notice(1, null, "a", "b", new Timestamp(date.getTime()) , null)));
    }

    @Test
    public void Test3(){
        System.out.println(noticeForMenaMapper.getNoticeList("43f916d4-78ee-454a-bfc8-c00412019ead"));
    }
}
