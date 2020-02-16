package com.exp.controller;

import com.exp.model.pojo.Family;
import com.exp.model.pojo.Member;
import com.exp.model.vo.TLogVO;
import com.exp.service.FamilyService;
import com.exp.service.MemberService;
import com.exp.service.TLogService;
import com.exp.utli.Utils;
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

    @RequestMapping("/record")
    public String checkFamilyT(Model model, HttpServletRequest request){
        int fid = Integer.parseInt(request.getParameter("fid"));
        Family family = familyService.findFamilyById(fid);
        List<TLogVO> logVOS = tLogService.findTLogsByFid(fid, Utils.getDate());
        model.addAttribute("family", family);
        model.addAttribute("list", logVOS);
        model.addAttribute("date",Utils.getDate());
        return "/admin/today";
    }
}
