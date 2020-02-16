package com.exp.controller;

import com.exp.model.pojo.Family;
import com.exp.service.FamilyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/family")
public class FamilyController {
    @Autowired
    FamilyService familyService;

    @RequestMapping("/add")
    public String addFamily(){
        return "/addFamily";
    }
    @RequestMapping("/add.do")
    public String addFamilyMethod(@Param("reporterTel") String reporterTel, @Param("psw") String psw){
        Family family = new Family();
        family.setAccount(reporterTel);
        family.setPsw(psw);
        int op = familyService.addFamily(family);
        if(op > 0)
            return "/success";
        return "/error";
    }

    @RequestMapping("/find")
    public String findFamily(){
        return "/findFamily";
    }
    @RequestMapping("/find.do")
    public String findFamilyMethod(Model model, @Param("id") int id){
        Family family = familyService.findFamilyById(id);
        model.addAttribute("family", family);
        return "/showFamily";
    }

    @RequestMapping("/test")
    public String test(){
        return "/test";
    }
}
