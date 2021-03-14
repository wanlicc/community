package life.wan.learn.community.controller;

import life.wan.learn.community.mapper.UserMapper;
import life.wan.learn.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) throws Exception {

        Cookie[] cookies= request.getCookies();

        if(!ObjectUtils.isEmpty(cookies)){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("token")){
                    String token =cookie.getValue();
                    User user =userMapper.findByToken(token);
                    if(user !=null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }


        return "index";
    }
}
