package com.mariia.syne.splitwise.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ui/groups")
public class GroupsController {

    @GetMapping("/list")
    public String showGroupsList(){

        return "group/list";
    }

    @GetMapping("/read/{group_id}")
    public String showGroupsRead(@PathVariable String group_id, Model model){

        model.addAttribute("group_id",group_id);

        return "group/read";
    }

    @GetMapping("/create")
    public String showGroupsCreate(Model model){

        return "group/create";
    }

    @GetMapping("/update/{group_id}")
    public String showGroupsUpdate(@PathVariable String group_id, Model model){

        model.addAttribute("group_id",group_id);

        return "group/update";
    }
}
