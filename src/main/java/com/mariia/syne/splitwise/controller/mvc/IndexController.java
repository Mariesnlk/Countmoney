package com.mariia.syne.splitwise.controller.mvc;

import com.mariia.syne.splitwise.model.Users;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String showPrivateCabinet(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("ROLE_USER")) {
            Integer user_id = ((Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId_users();
            model.addAttribute("user_id", user_id);

            return "user/read";

        } else return "/index.html";

    }

    @GetMapping("about")
    public String showAboutPage() {

        return "/about.html";

    }

    @GetMapping("contacts")
    public String showContactsPage() {

        return "/contacts.html";

    }


}
