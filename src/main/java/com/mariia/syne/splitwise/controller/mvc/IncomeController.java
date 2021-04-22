package com.mariia.syne.splitwise.controller.mvc;

import com.mariia.syne.splitwise.entity.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ui/incomes")
public class IncomeController {

    @GetMapping("/list")
    public String showIncomesList(){

        return "income/list";
    }

    @GetMapping("/read/{income_id}")
    public String showIncomesRead(@PathVariable String income_id, Model model){

        model.addAttribute("income_id",income_id);

        return "income/read";
    }

    @GetMapping("/create")
    public String showIncomesCreate(Model model){
        Integer userId = ((Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId_users();
        model.addAttribute("user_id",userId);

        return "income/create";
    }

    @GetMapping("/update/{income_id}")
    public String showIncomesUpdate(@PathVariable String income_id, Model model){

        model.addAttribute("income_id",income_id);

        return "income/update";
    }
}
