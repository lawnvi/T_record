package com.exp.controller;

import com.exp.model.pojo.Family;
import com.exp.service.FamilyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nanxi")
public class FamilyController {
    @Autowired
    FamilyService familyService;

    @RequestMapping("/addFamily")
    public String addFamily(){
        return "/addFamily";
    }
    @RequestMapping("/addFamily.do")
    public String addFamilyMethod(@Param("name") String name, @Param("address") String address){
        Family family = new Family();
        family.setAddress(address);
        family.setName(name);
        int op = familyService.addFamily(family);
        if(op > 0)
            return "success";
        return "error";
    }

    @RequestMapping("/findFamily")
    public String findFamily(){
        return "/findFamily";
    }
    @RequestMapping("/findFamily.do")
    public String findFamilyMethod(Model model, @Param("id") int id){
        Family family = familyService.findFamilyById(id);
        model.addAttribute("family", family);
        return "/showFamily";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
