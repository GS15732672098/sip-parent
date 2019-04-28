package com.sip.service;

import com.sip.pojo.Role;

import java.util.List;

public interface RoleService {
    /**
     * 查询角色列表
     * @param role
     * @return
     */
    public List<Role> queryRoleList(Role role);

    /**
     * 查看详情
     * @param roleid
     * @return
     */
    public Role queryRole(Integer roleid);

    /**
     * 添加角色
     * @param role
     * @return
     */
    public Integer addRole(Role role);

    /**
     * 修改角色
     * @param role
     * @return
     */
    public Integer updateRole(Role role);

    /**
     * 删除角色
     * @param role
     * @return
     */
    public Integer deleteRole(Role role);

    /**
     * 批量删除
     * @param role
     * @return
     */
    public Integer batchDeleteRole(Role role);
}
