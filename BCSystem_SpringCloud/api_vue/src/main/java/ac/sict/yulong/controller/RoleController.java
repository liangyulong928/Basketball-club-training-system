package ac.sict.yulong.controller;


import ac.sict.yulong.api.RoleClient;
import ac.sict.yulong.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role-author")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleClient roleClient;

    @RequestMapping("/getRoleList")
    public List<Role> getRoleList(@RequestParam String id){
        return roleClient.getRoleList(id);
    }

    @RequestMapping("/accept")
    public int acceptRole(@RequestParam String id,@RequestParam Integer actor){
        return roleClient.acceptRole(id, actor);
    }

    @RequestMapping("/confuse")
    public int confuseRole(@RequestParam String id){
        return roleClient.confuseRole(id);
    }
}
