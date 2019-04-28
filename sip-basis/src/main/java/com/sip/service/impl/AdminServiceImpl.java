package com.sip.service.impl;

import com.sip.mapper.AdminMapper;
import com.sip.pojo.Admin;
import com.sip.service.AdminService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Resource
    private AdminMapper adminMapper;

    private void machining(Admin admin){
        if(admin.getFlag()!=null && StringUtils.isNotEmpty(admin.getFlag())){
            if(admin.getFlag().equals("1")){

            }
        }
    }

    @Override
    public List<Admin> queryAdminList(Admin admin) {
        List<Admin> list = null;
        try {
            list = adminMapper.queryAdminList(admin);
            for (int i = 0; i < list.size(); i++) {
                machining(list.get(i));
            }
        } catch (Exception e) {
            list = new ArrayList<Admin>();
            e.printStackTrace();
            logger.error("查询管理员列表失败！", e);

        }
        return list;
    }

    @Override
    public Admin queryAdmin(Integer adminid) {
        Admin admin = new Admin();
        admin.setAdminid(adminid);
        try {
            admin = adminMapper.queryAdmin(admin);
        } catch (Exception e) {
            admin = new Admin();
            e.printStackTrace();
            logger.error("查询管理员详情失败！", e);
        }
        return admin;
    }

    @Override
    public Integer addAdmin(Admin admin) {
        Integer result = null;
        try {
            result = adminMapper.addAdmin(admin);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("添加管理员失败！", e);
        }
        return result;
    }

    @Override
    public Integer updateAdmin(Admin admin) {
        Integer result = null;
        try {
            result = adminMapper.updateAdmin(admin);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改管理员失败！", e);
        }
        return result;
    }

    @Override
    public Integer deleteAdmin(Admin admin) {
        Integer result = null;
        try {
            result = adminMapper.deleteAdmin(admin);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除管理员失败！", e);
        }
        return result;
    }

    @Override
    public Integer batchDeleteAdmin(Admin admin) {
        Integer result = null;
        try {
            result = adminMapper.batchDeleteAdmin(admin);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除管理员失败！", e);
        }
        return result;
    }

    @Override
    public Admin login(String adminname, String passowrd) {
        Admin admin = new Admin();
        admin.setAdminname(adminname);
        admin.setPassword(passowrd);
        try {
            admin = adminMapper.queryAdmin(admin);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("登录失败！",e);
        }
        return admin;
    }
}
