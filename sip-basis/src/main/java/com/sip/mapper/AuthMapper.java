package com.sip.mapper;

import com.sip.pojo.Auth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthMapper {

    /**
     * 查询管理员列表
     * @param auth
     * @return
     */
    public List<Auth> queryAuthList(Auth auth);

    /**
     * 查看详情
     * @param authid
     * @return
     */
    public Auth queryAuth(Integer authid);

    /**
     * 添加管理员
     * @param auth
     * @return
     */
    public Integer addAuth(Auth auth);

    /**
     * 修改管理员
     * @param auth
     * @return
     */
    public Integer updateAuth(Auth auth);

    /**
     * 删除管理员
     * @param auth
     * @return
     */
    public Integer deleteAuth(Auth auth);

    /**
     * 批量删除
     * @param auth
     * @return
     */
    public Integer batchDeleteAuth(Auth auth);
}
