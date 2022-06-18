package ac.sict.yulong.controller;

import ac.sict.yulong.feign.NoticeFeign;
import ac.sict.yulong.mapper.ActorMapper;
import ac.sict.yulong.mapper.OfficeMapper;
import ac.sict.yulong.pojo.Actor;
import ac.sict.yulong.pojo.Admin;
import ac.sict.yulong.pojo.Office;
import ac.sict.yulong.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private NoticeFeign noticeFeign;

    @Autowired
    private OfficeMapper officeMapper;

    @Autowired
    private ActorMapper searchOneMapper;

    @GetMapping("/login/{id}")
    public Admin queryByPhone(@PathVariable String id){
        return adminService.queryByPhone(id);
    }

    @GetMapping("/getAdmin/{id}")
    public Admin queryById(@PathVariable String id){
        return adminService.queryById(id);
    }

    @GetMapping("/pwdUpdate/{id}/{password}")
    public int pwdUpdate(@PathVariable String id,@PathVariable String password){
        int i = adminService.updateAdmin(id, password);
        return i;
    }

    @GetMapping("/signup/{name}/{phone}/{office}")
    public int signUp(@PathVariable String name,@PathVariable String phone,@PathVariable String office){
        String s = adminService.addUser(name, phone, office);
        if (s.equals(null)){
            return 0;
        }
        else{
            Admin admin = adminService.queryById(s);
            return noticeFeign.signupNotice(admin.getId());
        }
    }

    @GetMapping("/getOfficeList")
    public List<Office> getOfficeList(){
        List<Office> offices = officeMapper.selectAll();
        return offices;
    }

    @GetMapping("/searchActorNameById/{id}")
    public String searchActorNameById(@PathVariable String id){
        List<Actor> actors = searchOneMapper.searchActorById(id);
        Actor actor = actors.get(0);
        return actor.getActor_name();
    }

    @GetMapping("/searchOfficeNameById/{id}")
    public String searchOfficeNameById(@PathVariable String id){
        List<Office> offices = officeMapper.searchOfficeById(id);
        return offices.get(0).getOffice_name();
    }

    @GetMapping("/searchOfficeListByOffice/{office}")
    public List<Office> searchOfficeListByOffice(@PathVariable String office){
        return officeMapper.searchOfficeListByOffice(office);
    }

    @GetMapping("/postOut/{id}/{office}/{actor}")
    public int postOut(@PathVariable String id,@PathVariable String office,@PathVariable Integer actor){
        return adminService.postOut(id,office,actor);
    }

    @GetMapping("/deleteUser/{id}")
    public int deleteUser(@PathVariable String id){
        return adminService.deleteUser(id);
    }

    @GetMapping("/getRegistrarList/{office}")
    public List<Admin> getRegistrarList(@PathVariable String office){
        return adminService.getRegistrarList(office);
    }
}
