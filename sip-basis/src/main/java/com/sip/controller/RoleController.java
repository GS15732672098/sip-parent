package com.sip.controller;

import com.sip.pojo.Role;
import com.sip.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询角色列表
     * @param role
     * @return
     */
    @GetMapping("/queryRoleList")
    public List<Role> queryRoleList(@RequestBody Role role) {
        List<Role> list = roleService.queryRoleList(role);
        return list;
    }

    /**
     * 查看详情
     * @param roleid
     * @return
     */
    @GetMapping("/queryRole/{roleid}")
    public Role queryRole(@PathVariable("roleid") Integer roleid) {
        Role role = roleService.queryRole(roleid);
        return role;
    }

}
