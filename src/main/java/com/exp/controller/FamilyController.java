package com.exp.controller;

import com.exp.model.pojo.Family;
import com.exp.model.pojo.Member;
import com.exp.model.pojo.TLog;
import com.exp.service.FamilyService;
import com.exp.service.MemberService;
import com.exp.service.TLogService;
import com.exp.utli.Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/family")
public class FamilyController {
    @Autowired
    private FamilyService familyService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private TLogService tLogService;

    /**
     * 注册家庭单位
     * @return
     */
    @RequestMapping("/register")
    public String addFamily(){
        return "/addFamily";
    }
    @RequestMapping("/add.do")
    @ResponseBody
    public String addFamilyMethod(@Param("reporterTel") String reporterTel, @Param("psw") String psw, @Param("familyName") String familyName){
        Family family = new Family();
        family.setName(familyName);
        family.setAccount(reporterTel);
        family.setPsw(psw);
        int op = familyService.addFamily(family);
        System.out.println(op);
        if(op > 0)
            return "success";
        return "error";
    }

    /**
     * 家庭单位登录
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "/login";
    }
    @RequestMapping("/login.do")
    @ResponseBody
    public String loginMethod(HttpServletResponse response, Model model, @Param("account")String account, @Param("psw")String psw){
        Family family = new Family();
        family.setAccount(account);
        family.setPsw(psw);
        family = familyService.loginFamily(family);
        if (family != null){
            model.addAttribute("family", family);
            Utils.addCookie("familyAccount", family.getAccount(), response, 10*60, "/");
            Utils.addCookie("loginToken", Utils.getRandom(16), response, 10*60, "/");
            return "success";
        }
        return "error";
    }

    @RequestMapping("/mine")
    public String index(HttpServletRequest request, Model model){
        Family family = familyService.findFamilyByAccount(Utils.getCookie(request, "familyAccount"));
        model.addAttribute("family", family);
        List<Member> list = memberService.findMembers(family.getId());
        model.addAttribute("memberList", list);
        return "/family/index";
    }

    @RequestMapping("/reportT.do")
    @ResponseBody
    public String reportTemperature(HttpServletRequest request){
        List<TLog> logs = new ArrayList<>();
        String[] t = request.getParameterValues("t");
        String[] notes = request.getParameterValues("notes");
        String[] mid = request.getParameterValues("id");
        for(int i = 0; i < mid.length; i++){
            TLog log = new TLog();
            log.setMid(Integer.parseInt(mid[i]));
            log.setT(Double.parseDouble(t[i]));
            log.setNotes(notes[i]);
            logs.add(log);
        }
        if(tLogService.reportTs(logs)){
            return "success";
        }
        return "../errorPage";
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
