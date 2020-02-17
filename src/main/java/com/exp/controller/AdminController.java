package com.exp.controller;

import com.exp.model.pojo.DailyLog;
import com.exp.model.pojo.Family;
import com.exp.model.pojo.Member;
import com.exp.model.vo.TLogVO;
import com.exp.service.DailyLogService;
import com.exp.service.FamilyService;
import com.exp.service.MemberService;
import com.exp.service.TLogService;
import com.exp.utli.Utils;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private TLogService tLogService;
    @Autowired
    private FamilyService familyService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private DailyLogService dailyLogService;

    @RequestMapping("/todayRecord")
    public String checkFamilyT(Model model, HttpServletRequest request){
        int fid = Integer.parseInt(request.getParameter("fid"));
        int page = Integer.parseInt(request.getParameter("page"));
        int number = Integer.parseInt(request.getParameter("number"));
        Family family = familyService.findFamilyById(fid);
        List<TLogVO> logVOS = tLogService.findTLogsByFid(fid, Utils.getDate());
        String isTest = "还没测完(⊙﹏⊙)，要不去催催?";
        if(logVOS.size() > 0){
            if(logVOS.get(0).gettLog().getTime().compareTo("14:30:00") < 0)
                isTest = "今日数据最后一次更新于"+logVOS.get(0).gettLog().getTime()+", 今天下午还没测，去催催?";
            else {
                isTest = "今日数据最后一次更新于"+logVOS.get(0).gettLog().getTime();
            }
        }
        List<TLogVO> logVOS1 = tLogService.findTLogsByFidWithPage(fid, page, number);
        int count = tLogService.getTLogsCountByFid(fid);
        model.addAttribute("isTest", isTest);
        model.addAttribute("family", family);
        model.addAttribute("todayList", logVOS);
        model.addAttribute("list", logVOS1);
        model.addAttribute("date",Utils.getDate());
        model.addAttribute("page", page);
        model.addAttribute("count", count);
        return "/admin/today2";
    }

    @RequestMapping("/errorPage")
    public String error(){
        return "/admin/notime";
    }

    @RequestMapping("/signIn.do")
    public String copyThat(HttpServletRequest request){
        String ip = Utils.getIPAddress(request);
        int aid = Integer.parseInt(request.getParameter("aid"));
        int fid = Integer.parseInt(request.getParameter("fid"));
        String kind = "admin";
        String time = Utils.getDateTime();
        String op = time+":"+kind+"-"+aid+"在"+ip+"下收到fid:"+fid+"的成员体温情况";
        DailyLog dailyLog = new DailyLog();
        dailyLog.setTime(time);
        dailyLog.setOperation(op);
        dailyLog.setUid(aid);
        dailyLog.setUserKind(kind);
        if(dailyLogService.addDailyLog(dailyLog) > 0){
            return "success";
        }
        return "error";
    }

    @RequestMapping("/info")
    public String getFamilyInfo(Model model, HttpServletRequest request){
        int fid = Integer.parseInt(request.getParameter("fid"));
        Family family = familyService.findFamilyById(fid);
        List<Member> members = memberService.findMembers(fid);
        model.addAttribute("family", family);
        model.addAttribute("members", members);
        model.addAttribute("family", family);
        model.addAttribute("members", members);
        return "admin/lookInfo";
    }
}
