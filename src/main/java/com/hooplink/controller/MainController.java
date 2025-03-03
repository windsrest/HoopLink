package com.hooplink.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // 데이터 설정
        model.addAttribute("totalUsers", 1482);
        model.addAttribute("todayVisitors", 247);
        return "dashboard";
    }
}