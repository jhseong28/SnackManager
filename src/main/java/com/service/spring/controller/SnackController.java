package com.service.spring.controller;

import com.service.spring.domain.Snack;
import com.service.spring.service.AdminService;
import com.service.spring.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class SnackController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminService adminService;
    @GetMapping("admin/selectAll.do")
    public String doSelectAllAdmin(Model model) {
        try {
            List<Snack> snacks = adminService.selectAll();
            System.out.println(snacks);
            model.addAttribute("snacks", snacks);
            model.addAttribute("title", "관리자 - 전체 재고 조회");
            return "adminInventory";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("student/selectAll.do")
    public String doSelectAllStudent(Model model) {
        try {
            List<Snack> snacks = studentService.selectAll();
            System.out.println("snacks size = " + snacks.size());
            model.addAttribute("snacks", snacks);
            model.addAttribute("title", "학생 - 전체 재고 조회");
            return "studentInventory";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
