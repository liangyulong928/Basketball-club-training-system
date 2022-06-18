package ac.sict.yulong.api;

import ac.sict.yulong.pojo.Function;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("actor-function-rounter")


@RequestMapping("/actor-function")
public interface AFRounterClient {

    /*
    * 功能：获取该管理员所拥有的权限
    * 参数：管理员ID
    * */
    @GetMapping("/getFunction/{id}")
    public List<Function> getFunctionListById(@PathVariable String id);
}
