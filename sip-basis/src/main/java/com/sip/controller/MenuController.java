package com.sip.controller;

import com.sip.pojo.Menu;
import com.sip.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping(value="/queryParentMenuList")
    public List<Menu> queryParentMenuList(){
        List<Menu> list = menuService.queryParentMenuList();
        return list;
    };

    @GetMapping(value="/queryMenuListByPid/{pid}")
    public List<Menu> queryMenuListByPid(@PathVariable("pid") Integer pid){
        List<Menu> list = menuService.queryMenuListByPid(pid);
        return list;
    };
}
