package ac.sict.yulong.service;

import ac.sict.yulong.mapper.AdminMapper;
import ac.sict.yulong.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin getAdmin(String id){
        return adminMapper.selectByPrimaryKey(id);
    }

    public int updateAdmin(Admin admin){
        return adminMapper.updateByPrimaryKey(admin);
    }

    public int deleteAdmin(Admin admin){
        return adminMapper.delete(admin);
    }

}
