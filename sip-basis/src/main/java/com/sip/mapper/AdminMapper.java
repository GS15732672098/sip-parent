package com.sip.mapper;

import com.sip.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    /**
     * 查询管理员列表
     * @param admin
     * @return
     */
    public List<Admin> queryAdminList(Admin admin);

    /**
     * 查看详情
     * @param admin
     * @return
     */
    public Admin queryAdmin(Admin admin);

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
}
