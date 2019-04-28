package com.sip.service;

import com.sip.vo.MenuVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="sip-base")
public interface MenuClient {

    public static final String SERVICEPREFIX = "/menu";

    /**
     * 查询父级菜单列表
     * @return
     */
    @GetMapping(value = SERVICEPREFIX + "/queryParentMenuList")
    public List<MenuVo> queryParentMenuList();

    @GetMapping(value = SERVICEPREFIX + "/queryMenuListByPid/{pid}")
    public List<MenuVo> queryMenuListByPid(@PathVariable("pid") Integer pid);
}
