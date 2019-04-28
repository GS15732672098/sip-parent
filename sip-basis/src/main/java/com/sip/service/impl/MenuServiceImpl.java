package com.sip.service.impl;

import com.sip.mapper.MenuMapper;
import com.sip.pojo.Menu;
import com.sip.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> queryMenuList(Menu menu) {
        List<Menu> list = null;
        try {
            list = menuMapper.queryMenuList(menu);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询菜单列表失败！", e);
        }
        return list;
    }

    @Override
    public List<Menu> queryMenuListByPid(Integer pid) {
        List<Menu> list = null;
        try {
            list = menuMapper.queryMenuListByPid(pid);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询菜单列表失败！", e);
        }
        return list;
    }

    @Override
    public Menu queryMenu(Integer menuid) {
        Menu menu = null;
        try {
            menu = menuMapper.queryMenu(menuid);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询菜单信息失败！", e);
        }
        return menu;
    }

    @Override
    public Integer addMenu(Menu menu) {
        Integer result = null;
        try {
            result = menuMapper.addMenu(menu);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("添加菜单失败！", e);
        }
        return result;
    }

    @Override
    public Integer updateMenu(Menu menu) {
        Integer result = null;
        try {
            result = menuMapper.updateMenu(menu);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改菜单失败！", e);
        }
        return result;
    }

    @Override
    public List<Menu> queryParentMenuList() {
        List<Menu> list = null;
        try {
            list = menuMapper.queryParentMenuList();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询父级菜单列表失败！", e);
        }
        return list;
    }

    @Override
    public Integer deleteMenu(Menu menu) {
        Integer result = null;
        try {
            result = menuMapper.deleteMenu(menu);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除菜单失败！", e);
        }
        return result;
    }

    @Override
    public Integer batchDeleteMenu(Menu menu) {
        Integer result = null;
        try {
            result = menuMapper.batchDeleteMenu(menu);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除菜单失败！", e);
        }
        return result;
    }
}
