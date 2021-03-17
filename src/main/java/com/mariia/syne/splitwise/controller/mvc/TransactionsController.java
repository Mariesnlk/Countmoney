package com.mariia.syne.splitwise.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ui/transactions")
public class TransactionsController {

    @GetMapping("/list")
    public String showTransactionsList(){

        return "transaction/list";
    }

    @GetMapping("/read/{transaction_id}")
    public String showTransactionsRead(@PathVariable String transaction_id, Model model){

        model.addAttribute("transaction_id",transaction_id);

        return "transaction/read";
    }

    @GetMapping("/create")
    public String showTransactionsCreate(){

        return "transaction/create";
    }

    @GetMapping("/update/{transaction_id}")
    public String showTransactionsUpdate(@PathVariable String transaction_id, Model model){

        model.addAttribute("transaction_id",transaction_id);

        return "transaction/update";
    }
}
