package com.sip.service;

import com.sip.pojo.Admin;

import java.util.List;

public interface AdminService {
    /**
     * 查询管理员列表
     * @param admin
     * @return
     */
    public List<Admin> queryAdminList(Admin admin);

    /**
     * 查看详情
     * @param adminid
     * @return
     */
    public Admin queryAdmin(Integer adminid);

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    public Integer addAdmin(Admin admin);

    /**
     * 修改管理员
     * @param admin
     * @return
     */
    public Integer updateAdmin(Admin admin);

    /**
     * 删除管理员
     * @param admin
     * @return
     */
    public Integer deleteAdmin(Admin admin);

    /**
     * 批量删除
     * @param admin
     * @return
     */
    public Integer batchDeleteAdmin(Admin admin);

    /**
     * 管理员登录
     * @param adminname
     * @param passowrd
     * @return
     */
    public Admin login(String adminname,String passowrd);
}
