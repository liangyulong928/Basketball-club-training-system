package ac.sict.yulong.controller;

import ac.sict.yulong.mapper.AFMapper;
import ac.sict.yulong.pojo.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actor-function")
public class AFController {

    @Autowired
    private AFMapper afMapper;

    @GetMapping("/getFunction/{id}")
    public List<Function> getFunctionListById(@PathVariable String id){
        List<Function> functionListById = afMapper.getFunctionListById(id);
        return functionListById;
    }



}
