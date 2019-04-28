package com.sip.controller;

import com.sip.pojo.Admin;
import com.sip.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 查询管理员列表
     * @param admin
     * @return
     */
    @GetMapping("/queryAdminList")
    public List<Admin> queryAdminList(@RequestBody Admin admin) {
        List<Admin> list = adminService.queryAdminList(admin);
        return list;
    }

    /**
     * 查看管理员详情
     * @param adminid
     * @return
     */
    @GetMapping("/queryAdmin/{adminid}")
    public Admin queryAdminList(@PathVariable("adminid") Integer adminid) {
        Admin admin = adminService.queryAdmin(adminid);
        return admin;
    }

    /**
     * 管理员登录
     * @param adminname
     * @param password
     * @return
     */
    @PostMapping("/login/{adminname}/{password}")
    public Admin login(@PathVariable("adminname") String adminname,@PathVariable("password") String password){
        Admin admin = adminService.login(adminname,password);
        return admin;
    }
}
