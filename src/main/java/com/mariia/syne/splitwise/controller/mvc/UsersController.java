package com.mariia.syne.splitwise.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ui/users")
public class UsersController {

    @GetMapping("/list")
    public String showUsersList(){

        return "user/list";
    }

    @GetMapping("/read/{user_id}")
    public String showUsersRead(@PathVariable String user_id, Model model){

        model.addAttribute("user_id",user_id);

        return "user/read";
    }

    @GetMapping("/create")
    public String showUsersCreate(){

        return "user/create";
    }

    @GetMapping("/update/{user_id}")
    public String showUsersUpdate(@PathVariable String user_id, Model model){

        model.addAttribute("user_id",user_id);

        return "user/update";
    }
}
