package ac.sict.yulong.controller;


import ac.sict.yulong.pojo.Role;
import ac.sict.yulong.service.AdminService;
import ac.sict.yulong.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role-author")
public class Controller {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;


    @GetMapping("/getRoleList/{id}")
    public List<Role> getRoleList(@PathVariable String id){
        return roleService.getRoleList(adminService.getAdmin(id));
    }

    @GetMapping("/accept/{id}/{actor}")
    public int acceptRole(@PathVariable String id,@PathVariable Integer actor){
        return roleService.acceptAdmin(id, actor);
    }

    @GetMapping("/confuse/{id}")
    public int confuseRole(@PathVariable String id){
        return roleService.confuseRole(id);
    }

}
