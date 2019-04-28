package com.sip.service.impl;

import com.sip.mapper.RoleMapper;
import com.sip.pojo.Role;
import com.sip.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryRoleList(Role role) {
        List<Role> list = null;
        try {
            list = roleMapper.queryRoleList(role);
        } catch (Exception e) {
            list = new ArrayList<Role>();
            e.printStackTrace();
            logger.error("查询角色列表失败！", e);
        }
        return list;
    }

    @Override
    public Role queryRole(Integer roleid) {
        Role role = null;
        try {
            role = roleMapper.queryRole(roleid);
        } catch (Exception e) {
            role = new Role();
            e.printStackTrace();
            logger.error("查询角色列表失败！", e);
        }
        return role;
    }

    @Override
    public Integer addRole(Role role) {
        Integer result = null;
        try {
            result = roleMapper.addRole(role);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("添加角色失败！", e);
        }
        return result;
    }

    @Override
    public Integer updateRole(Role role) {
        Integer result = null;
        try {
            result = roleMapper.updateRole(role);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改角色失败！", e);
        }
        return result;
    }

    @Override
    public Integer deleteRole(Role role) {
        Integer result = null;
        try {
            role.setFlag("0");
            result = roleMapper.deleteRole(role);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除角色失败！", e);
        }
        return result;
    }

    @Override
    public Integer batchDeleteRole(Role role) {
        Integer result = null;
        try {
            role.setFlag("0");
            result = roleMapper.batchDeleteRole(role);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除角色失败！", e);
        }
        return result;
    }
}
