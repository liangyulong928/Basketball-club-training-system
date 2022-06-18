package ac.sict.yulong.api;


import ac.sict.yulong.pojo.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("role-authorization")
@RequestMapping("/role-author")
public interface RoleClient {
    @RequestMapping("/getRoleList/{id}")
    public List<Role> getRoleList(@PathVariable String id);

    @GetMapping("/accept/{id}/{actor}")
    public int acceptRole(@PathVariable String id,@PathVariable Integer actor);

    @GetMapping("/confuse/{id}")
    public int confuseRole(@PathVariable String id);

}
