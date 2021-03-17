package com.mariia.syne.splitwise.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ui/typeTransactions")
public class TypeTransactionController {

    @GetMapping("/list")
    public String showTypeTransactionsList(){

        return "typeTransaction/list";
    }

    @GetMapping("/read/{typeTransaction_id}")
    public String showTypeTransactionsRead(@PathVariable String typeTransaction_id, Model model){

        model.addAttribute("typeTransaction_id",typeTransaction_id);

        return "typeTransaction/read";
    }

    @GetMapping("/create")
    public String showTypeTransactionsCreate(){

        return "typeTransaction/create";
    }

    @GetMapping("/update/{typeTransaction_id}")
    public String showTypeTransactionsUpdate(@PathVariable String typeTransaction_id, Model model){

        model.addAttribute("typeTransaction_id",typeTransaction_id);

        return "typeTransaction/update";
    }
}
