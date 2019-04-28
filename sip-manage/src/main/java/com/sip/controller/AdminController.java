package com.sip.controller;

import com.sip.service.AdminClient;
import com.sip.utils.MD5Utils;
import com.sip.utils.RedisOperator;
import com.sip.vo.AdminVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
@PropertySource("classpath:resource.properties")
public class AdminController {

    @Autowired
    private AdminClient adminClient;
	@Autowired
	private RedisOperator redisOperator;
	@Value("${USER_REDIS_SESSION}")
	private String USER_REDIS_SESSION;


    @GetMapping("/queryAdminInfo/{adminid}")
	@ResponseBody
    public AdminVo queryAdminInfo(@PathVariable("adminid") Integer adminid) {
        AdminVo adminVo = adminClient.queryAdminInfo(adminid);
        return adminVo;
    }
	
	/*@PostMapping("/generateCode")
	public Map<String,Object> generateCode(){
		
		String code = "";
	}*/

	/**
	 * 管理员登录
	 * @param adminname
	 * @param password
	 * @return
	 */
	@PostMapping("/login/{adminname}/{password}")
	@ResponseBody
	public Map<String,Object> login(@PathVariable("adminname") String adminname,@PathVariable("password") String password){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("code","1");
		result.put("message","登录成功！");
		try{
			// 1.校验用户名称是否为空
			if(adminname == null || adminname == ""){
				result.put("code","0");
				result.put("message","用户名不能为空！请输入用户名！");
				return result;
			}
			// 2.校验用户密码是否为空
			if(password == null || password == ""){
				result.put("code","0");
				result.put("message","登录密码不能为空！请输入密码！");
				return result;
			}
			/*// 3.校验验证码是否为空
			if(code == null || code == ""){
				result.put("code","0");
				result.put("message","验证不能为空！请输入验证码！");
				return result;
			}*/
			// 4.校验验证码是否正确
			// 从缓存中获取验证码
			/*String logincode = redisOperator.get("logincode");
			// 与用户输入的验证码进行比对，验证码正确，执行登录
			if(!logincode.equles(code)){
				result.put("code","2");
				result.put("message","验证码错误！请重新输入验证码！");
				return result;
			}*/
			// 5.执行登录
			// 密码MD5加密
			password = MD5Utils.byteArr2HexStr(password.getBytes());
			AdminVo adminVo = adminClient.login(adminname,password);
			if(adminVo == null){
				result.put("code","0");
				result.put("message","登录失败！用户名称或者密码错误！请重新输入！");
				return result;
			}
			// 用redis缓存模拟用户session
			// 置空用户密码
			adminVo.setPassword("");
			// 设置用戶token,由UUID+当前时间戳组成,保证唯一性
			String timeStamp = String.valueOf(new Date().getTime());
			String token = UUID.randomUUID().toString().replaceAll("-", "") + timeStamp;
			// 存储用户对象信息到redis中,设置过期时间为30分钟
			redisOperator.set(USER_REDIS_SESSION + ":" + adminVo.getAdminid(), token, 1000 * 60 * 30);
			adminVo.setToken(token);
			result.put("data",adminVo);
		} catch (Exception e) {	
			result.put("code","0");
			result.put("message","登录失败！用户名称或者密码错误！请重新输入！");
			e.printStackTrace();
			
		}		
		return result;		
	}

	/**
	 * 管理员登出
	 * @param adminid
	 * @return
	 */
	@PostMapping("/loginOut/{adminid}")
	@ResponseBody
	public Map<String,Object> loginOut(@PathVariable("adminid") Integer adminid){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("code","1");
		result.put("message","登出成功！");
		try {
			if(adminid == null){
				result.put("code","0");
				result.put("message","登出失败！");
				return result;
			}
			// 获取用户token
			String token = redisOperator.get(USER_REDIS_SESSION + ":" + adminid);
			if(StringUtils.isEmpty(token)){
				// 删除redis服务器中用户token信息
				redisOperator.del(USER_REDIS_SESSION + ":" + adminid);
			}
		} catch (Exception e) {
			result.put("code","0");
			result.put("message","登出失败！");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 跳转添加页面
	 * @param modelMap
	 * @return
	 */
	@GetMapping("/queryAdminAddPage")
	public String queryAdminAddPage(ModelMap modelMap){
		
		return "";
	}

	/**
	 * 添加管理员
	 * @param adminVo
	 * @return
	 */
	@PostMapping("/addAdmin")
	@ResponseBody
	public Map<String,Object> addAdmin(@RequestBody AdminVo adminVo){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			Integer row = adminClient.addAdmin(adminVo);
			if(row > 0){
				result.put("code","1");
				result.put("message","添加成功！");
			}
		} catch (Exception e) {
			result.put("code","0");
			result.put("message","添加失败！");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 跳转修改页面
	 * @param modelMap
	 * @param adminid
	 * @return
	 */
	@GetMapping("/queryAdminUpdatePage/{adminid}")
	public String queryAdminUpdatePage(ModelMap modelMap,@PathVariable("adminid") Integer adminid){
		AdminVo adminVo = null;
    	try {
			if(adminid != null){
				adminVo = adminClient.queryAdminInfo(adminid);
			}
		} catch (Exception e) {
			adminVo = new AdminVo();
			e.printStackTrace();
		}
		modelMap.put("admin", adminVo);
		return "";
	}
	
	@PostMapping("/updateAdmin")
	@ResponseBody
	public Map<String,Object> updateAdmin(@RequestBody AdminVo adminVo){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			Integer row = adminClient.updateAdmin(adminVo);
			if(row > 0){
				result.put("code","1");
				result.put("message","修改成功！");
			}
		} catch (Exception e) {
			result.put("code","0");
			result.put("message","修改失败！");
			e.printStackTrace();
		}
		return result;
	}
	
	@PostMapping("/deleteAdmin")
	@ResponseBody
	public Map<String,Object> deleteAdmin(@RequestBody AdminVo adminVo){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			Integer row = adminClient.deleteAdmin(adminVo);
			if(row > 0){
				result.put("code","1");
				result.put("message","删除成功！");
			}
		} catch (Exception e) {
			result.put("code","0");
			result.put("message","删除失败！");
			e.printStackTrace();
		}
		return result;
	}
	
	@PostMapping("/batchDeleteAdmin")
	@ResponseBody
	public Map<String,Object> batchDeleteAdmin(@RequestBody AdminVo adminVo){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			Integer row = adminClient.batchDeleteAdmin(adminVo);
			if(row > 0){
				result.put("code","1");
				result.put("message","删除成功！");
			}
		} catch (Exception e) {
			result.put("code","0");
			result.put("message","删除失败！");
			e.printStackTrace();
		}
		return result;
	}
	
}
