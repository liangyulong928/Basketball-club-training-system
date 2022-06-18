package ac.sict.yulong.controller;

import ac.sict.yulong.api.AdminClient;
import ac.sict.yulong.pojo.Admin;
import ac.sict.yulong.pojo.AdminLoginStatue;
import ac.sict.yulong.pojo.Office;
import ac.sict.yulong.service.LoginCheck;
import ac.sict.yulong.service.NewPlanData;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminClient adminClient;

    @Autowired
    private LoginCheck loginCheck;

    @Autowired
    private NewPlanData newPlanData;

    @RequestMapping("/login")
    public AdminLoginStatue loginCheck(@RequestParam String id,@RequestParam String password) throws NoSuchAlgorithmException {
        Admin admin = adminClient.queryByPhone(id);
        if (admin == null) {
            return null;
        }
        else if(admin.getStatus()==0){
            return new AdminLoginStatue(null,0,0);
        }
        else{
            return loginCheck.loginCheck(password,admin);
        }
    }

    @RequestMapping("/pwdUpdate")
    public int passwordUpdate(@RequestParam String id,@RequestParam String password) throws NoSuchAlgorithmException {
        String s = loginCheck.passwordChangeToMd5(password);
        return adminClient.pwdUpdate(id, s);
    }

    @RequestMapping("/getAdmin")
    public Admin getAdmin(@RequestParam String id){
        Admin admin = adminClient.queryById(id);
        return admin;
    }

    @RequestMapping("/signup")
    public int addUser(@RequestParam String name,@RequestParam String phone,@RequestParam String office){
        return adminClient.signUp(name, phone, office);
    }

    @RequestMapping("/getOfficeList")
    public List<Office> getOfficeList(){
        return adminClient.getOffice();
    }

    @RequestMapping("/searchActorNameById")
    public String searchActorNameById(@RequestParam String id){
        return adminClient.searchActorNameById(id);
    }

    @RequestMapping("/searchOfficeNameById")
    public String searchOfficeNameById(@RequestParam String id){
        return adminClient.searchOfficeNameById(id);
    }

    @RequestMapping("/searchOfficeListByOffice")
    public List<Office> searchOfficeListByOffice(@RequestParam String office){
        return adminClient.searchOfficeListByOffice(office);
    }

    @RequestMapping("/postOut")
    public int postOut(@RequestParam String id,@RequestParam String office,@RequestParam Integer actor){
        return adminClient.postOut(id,office,actor);
    }

    @RequestMapping("/deleteUser")
    public int deleteUser(@RequestParam String id){
        return adminClient.deleteUser(id);
    }

    @RequestMapping("/getRegistrarList")
    public JSONObject getRegistrarList(@RequestParam String office){
        return newPlanData.getNewPlanList(office);
    }
}
