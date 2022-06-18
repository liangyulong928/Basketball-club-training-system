package ac.sict.yulong.controller;

import ac.sict.yulong.api.AFRounterClient;
import ac.sict.yulong.pojo.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actor-function")
@CrossOrigin
public class AFRounterController {

    @Autowired
    private AFRounterClient afRounterClient;

    @RequestMapping("/getFunctionListById")
    public List<Function> getFunctionListById(@RequestParam String id){
        return afRounterClient.getFunctionListById(id);
    }
}
