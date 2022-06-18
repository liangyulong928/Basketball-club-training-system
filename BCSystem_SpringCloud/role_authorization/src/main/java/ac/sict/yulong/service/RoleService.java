package ac.sict.yulong.service;

import ac.sict.yulong.client.NoticeClient;
import ac.sict.yulong.mapper.RoleMapper;
import ac.sict.yulong.pojo.Admin;
import ac.sict.yulong.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AdminService adminService;

    @Autowired
    private NoticeClient noticeClient;

    public List<Role> getRoleList(Admin admin){
        return roleMapper.getRoleList(admin.getId(),admin.getOffice());
    }

    public int acceptAdmin(String id,Integer actor){
        Admin admin = adminService.getAdmin(id);
        noticeClient.acceptNotice(id);
        admin.setActor(actor);
        admin.setStatus(1);
        return adminService.updateAdmin(admin);
    }

    public int confuseRole(String id){
        Admin admin = adminService.getAdmin(id);
        if (noticeClient.confuseRole(id)!=0){
            return adminService.deleteAdmin(admin);
        }
        else return 0;
    }
}
