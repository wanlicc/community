package life.wan.learn.community.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublishController {

    @GetMapping("/publish")
    public String publish(Model model) {
        return "publish";
    }


}
