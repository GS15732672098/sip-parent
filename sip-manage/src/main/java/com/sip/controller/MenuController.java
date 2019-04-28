package com.sip.controller;

import com.sip.service.MenuClient;
import com.sip.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuClient menuClient;

    @GetMapping(value="/queryParentMenuList")
    public Map<String,Object> queryParentMenuList(){
      Map<String,Object> result = new LinkedHashMap<String,Object>();
      result.put("code","1");
      result.put("message","查询父级菜单列表成功！");
      try {
          List<MenuVo> plist = menuClient.queryParentMenuList();
          result.put("data",plist);
      } catch (Exception e) {
          e.printStackTrace();
          result.put("code","0");
          result.put("message","查询父级菜单列表失败！");
      }
      return result;
    }

    /**
     * 根据父级菜单id查询子菜单列表
     * @param pid
     * @return
     */
    @GetMapping(value="/queryMenuListByPid/{pid}")
    public Map<String,Object> queryMenuListByPid(@PathVariable("pid") Integer pid){
        Map<String,Object> result = new LinkedHashMap<String,Object>();
        result.put("code","1");
        result.put("message","查询子菜单列表成功！");
        try {
            List<MenuVo> clist = menuClient.queryMenuListByPid(pid);
            result.put("data",clist);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code","0");
            result.put("message","查询子菜单列表失败！");
        }
        return result;
    }



}
