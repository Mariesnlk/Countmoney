package com.mariia.syne.splitwise.controller.mvc;

import com.mariia.syne.splitwise.entity.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ui/transactions")
public class TransactionsController {

    @GetMapping("/list")
    public String showTransactionsList(Model model){
        model.addAttribute("user_id",0);
        return "transaction/list";
    }

    @GetMapping("/list/user/{user_id}")
    public String showTransactionsByUser(@PathVariable String user_id, Model model){

        model.addAttribute("user_id",user_id);

        return "transaction/list";
    }

    @GetMapping("/list/group/{group_id}")
    public String showTransactionsByGroup(@PathVariable String group_id, Model model){

        model.addAttribute("group_id",group_id);

        return "transaction/list";
    }

    @GetMapping("/read/{transaction_id}")
    public String showTransactionsRead(@PathVariable String transaction_id, Model model){

        model.addAttribute("transaction_id",transaction_id);

        return "transaction/read";
    }

    @GetMapping("/create")
    public String showTransactionsCreate(Model model){
        Integer userId = ((Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId_users();
        model.addAttribute("user_id",userId);

        return "transaction/create";
    }

    @GetMapping("/update/{transaction_id}")
    public String showTransactionsUpdate(@PathVariable String transaction_id, Model model){

        model.addAttribute("transaction_id",transaction_id);

        return "transaction/update";
    }
}
