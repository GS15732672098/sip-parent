package com.sip.service;

import com.sip.vo.AdminVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("sip-basis")
public interface AdminClient {

    public static final String SERVICEPREFIX = "/admin";

    /**
     * 查询详情
     * @param adminid
     * @return
     */
    @GetMapping(value = SERVICEPREFIX + "/queryAdmin/{adminid}")
    public AdminVo queryAdminInfo(@PathVariable("adminid") Integer adminid);

    /**
     * 添加管理员
     * @param adminVo
     * @return
     */
    @PostMapping(value = SERVICEPREFIX + "/addAdmin")
    public Integer addAdmin(@RequestBody AdminVo adminVo);

    /**
     * 删除管理员
     * @param adminVo
     * @return
     */
    @PostMapping(value = SERVICEPREFIX + "/updateAdmin")
    public Integer updateAdmin(@RequestBody AdminVo adminVo);

    /**
     * 删除管理员
     * @param adminVo
     * @return
     */
    @PostMapping(value = SERVICEPREFIX + "/deleteAdmin")
    public Integer deleteAdmin(@RequestBody AdminVo adminVo);

    /**
     * 批量删除管理员
     * @param adminVo
     * @return
     */
    @PostMapping(value = SERVICEPREFIX + "/batchDeleteAdmin")
    public Integer batchDeleteAdmin(@RequestBody AdminVo adminVo);

    @PostMapping(value = SERVICEPREFIX + "/login/{adminname}{password}")
    public AdminVo login(@PathVariable("adminname") String adminname,@PathVariable("password") String password);


}
