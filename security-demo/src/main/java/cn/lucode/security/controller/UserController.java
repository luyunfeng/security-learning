package cn.lucode.security.controller;

import cn.lucode.security.dto.User;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunfeng.lu
 * @create 2017/11/5.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/query")
    @JsonView(User.PrintUser.class)
    public List<User> query(){
        List<User> list=new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }

    @GetMapping("/get/info/{id:\\d+}")
    @JsonView(User.PrintUserDetail.class)
    public User getUserInfo(){
        User user=new User();
        user.setName("lucode");
        return user;
    }
}
