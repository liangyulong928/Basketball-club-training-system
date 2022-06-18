package ac.sict.yulong.api;

import ac.sict.yulong.pojo.Admin;
import ac.sict.yulong.pojo.Office;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("admin-check")

@RequestMapping("/admin")
public interface AdminClient {
    /*
    * 功能：通过手机号查询管理员信息
    * 参数：管理员手机号
    * */
    @GetMapping("/login/{id}")
    public Admin queryByPhone(@PathVariable String id);

    /*
     * 功能：修改密码
     * 参数：管理员ID，修改后的密码
     * */
    @GetMapping("/pwdUpdate/{id}/{password}")
    public int pwdUpdate(@PathVariable String id,@PathVariable String password);

    /*
     * 功能：根据ID查询管理员信息
     * 参数：管理员ID
     * */
    @GetMapping("/getAdmin/{id}")
    public Admin queryById(@PathVariable String id);

    /*
     * 功能：管理员注册
     * 参数：管理员姓名、手机号、所属单位ID
     * */
    @GetMapping("/signup/{name}/{phone}/{office}")
    public int signUp(@PathVariable String name,@PathVariable String phone,@PathVariable String office);

    /*
     * 功能：获取俱乐部所有所属单位列表
     * 参数：无
     * */
    @GetMapping("/getOfficeList")
    public List<Office> getOffice();

    /*
     * 功能：通过职位号查询职位名称
     * 参数：职位号
     * */
    @GetMapping("/searchActorNameById/{id}")
    public String searchActorNameById(@PathVariable String id);

    /*
     * 功能：通过单位号查询单位名称
     * 参数：单位号
     * */
    @GetMapping("/searchOfficeNameById/{id}")
    public String searchOfficeNameById(@PathVariable String id);

    /*
    * 功能：获取管理员可操作单位列表
    * 参数：管理员单位
    * */
    @GetMapping("/searchOfficeListByOffice/{office}")
    public List<Office> searchOfficeListByOffice(@PathVariable String office);

    /*
    * 功能：用户职位调动
    * 参数：被调动者id，调动后的单位，调动后的角色
    * */
    @GetMapping("/postOut/{id}/{office}/{actor}")
    public int postOut(@PathVariable String id,@PathVariable String office,@PathVariable Integer actor);

    /*
    * 功能：删除用户
    * 参数：被删除者id
    * */
    @GetMapping("/deleteUser/{id}")
    public int deleteUser(@PathVariable String id);

    @GetMapping("/getRegistrarList/{office}")
    public List<Admin> getRegistrarList(@PathVariable String office);
}
