package edu.miu.ent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ads")
public class SysAdminController {

    @GetMapping("/sysadmin")
    public String displaySysAdminPage() {
        return "secured/sysadmin/sysadmin";
    }
}
