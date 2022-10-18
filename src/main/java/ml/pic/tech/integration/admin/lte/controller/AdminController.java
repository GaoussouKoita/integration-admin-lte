package ml.pic.tech.integration.admin.lte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping({"/", "/dashboard"})
    public String dash() {
        return "admin/dashboard";
    }

    @GetMapping("/dashboard/")
    public String dashList() {
        return "admin/liste";
    }

}
