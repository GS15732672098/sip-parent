package com.sip.mapper;

import com.sip.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    /**
     * 查询菜单列表
     * @param menu
     * @return
     */
    public List<Menu> queryMenuList(Menu menu);

    /**
     * 查询菜单的子列表
     * @param pid
     * @return
     */
    public List<Menu> queryMenuListByPid(Integer pid);

    /**
     * 查询菜单信息
     * @param menuid
     * @return
     */
    public Menu queryMenu(Integer menuid);

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    public Integer addMenu(Menu menu);

    /**
     * 更新菜单
     * @param menu
     * @return
     */
    public Integer updateMenu(Menu menu);

    /**
     * 删除菜单
     * @param menu
     * @return
     */
    public Integer deleteMenu(Menu menu);

    /**
     * 批量删除
     * @param menu
     * @return
     */
    public Integer batchDeleteMenu(Menu menu);

    /**
     * 查询父级菜单列表
     * @return
     */
    public List<Menu> queryParentMenuList();

}
