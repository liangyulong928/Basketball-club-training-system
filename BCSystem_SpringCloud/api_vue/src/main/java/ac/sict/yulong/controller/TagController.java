package ac.sict.yulong.controller;

import ac.sict.yulong.api.PlayerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
@CrossOrigin
public class TagController {

    @Autowired
    private PlayerClient tagClient;

    @RequestMapping("/addTag")
    public int addTag(@RequestParam String tagString){
        return tagClient.addTag(tagString);
    }
}
