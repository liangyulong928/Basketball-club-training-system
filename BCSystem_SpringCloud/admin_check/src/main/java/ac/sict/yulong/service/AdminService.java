package ac.sict.yulong.service;

import ac.sict.yulong.mapper.AdminMapper;
import ac.sict.yulong.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    static private String KEY_WORD = "871e40437a3a623530d807586fdda8ac";

    public Admin queryByPhone(String id){
        return adminMapper.queryByPhone(id);
    }

    public Admin queryById(String id){
        return adminMapper.selectByPrimaryKey(id);
    }

    public int insertAdmin(Admin admin){
        return adminMapper.insert(admin);
    }

    public List<Admin> findAll(){
        return adminMapper.selectAll();
    }

    public int updateAdmin(String id,String password){
        Admin admin = adminMapper.selectByPrimaryKey(id);
        admin.setKeyword(password);
        int i = adminMapper.updateByPrimaryKey(admin);
        return i;
    }

    public int postOut(String id,String office,Integer actor){
        Admin admin = adminMapper.selectByPrimaryKey(id);
        admin.setActor(actor);
        admin.setOffice(office);
        return adminMapper.updateByPrimaryKey(admin);
    }

    public int deleteUser(String id){
        Admin admin = adminMapper.selectByPrimaryKey(id);
        return adminMapper.delete(admin);
    }

    public String addUser(String name,String phone,String office){
        String id = UUID.randomUUID().toString();
        while (adminMapper.selectByPrimaryKey(id)!=null){
            id = UUID.randomUUID().toString();
        }
        int insert = adminMapper.insert(new Admin(id, name, office, KEY_WORD, phone, 0));
        if (insert!=0){
            return id;
        }
        else return null;
    }

    public List<Admin> getRegistrarList(String office){
        return adminMapper.getRegistrarList(office);
    }

}
