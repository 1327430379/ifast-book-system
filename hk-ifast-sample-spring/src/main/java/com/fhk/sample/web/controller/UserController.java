package com.fhk.sample.web.controller;

import com.fhk.sample.common.module.SessionManager;
import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.dto.UserDTO;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 用户表
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;


    @RequestMapping("/register")
    public RestResponse<String> register(@RequestBody @Validated UserDTO userDTO) {
        userService.register(this.convert(userDTO, User.class));
        return RestResponse.SUCCEED;
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    public RestResponse<PageVO<User>> list(@RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                           @RequestParam(name = "pageSize", defaultValue = "20", required = false) Integer pageSize,
                                           @RequestParam("username")String username,
                                           @RequestParam("name")String name,
                                           @RequestParam("mobile")String mobile,
                                           @RequestParam("status")Integer status,
                                           @RequestParam("approveStatus")String approveStatus) {
        User user = new User();
        user.setUsername(username);
        user.setName(name);
        user.setMobile(mobile);
        user.setStatus(status);
        user.setApproveStatus(approveStatus);
        return RestResponse.success(userService.listByPage(pageNum, pageSize,user));
    }


    /**
     * 信息
     */
    @GetMapping("/{id}")
    public RestResponse<User> getById(@PathVariable("id") Integer id) {
        return RestResponse.success(userService.getById(id));
    }


    /**
     * 修改
     */
    @PostMapping("/update")
    public RestResponse<User> update(@RequestBody @Validated UserDTO user) {
        return RestResponse.success(userService.updateById(this.convert(user, User.class)));
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public RestResponse<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return RestResponse.VOID;
    }

    /**
     * 修改用户状态|启用或禁用
     *
     * @param id
     * @return
     */
    @DeleteMapping("/status/update")
    public RestResponse<Void> updateStatus(@RequestParam("id") Integer id,
                                           @RequestParam("status") Integer status) {
        userService.updateStatus(id, status);
        return RestResponse.VOID;
    }

    /**
     * 批准用户
     *
     * @param id
     * @return
     */
    @PostMapping("/approve")
    public RestResponse<Void> approve(@RequestParam("userId") Integer id) {
        userService.approve(id);
        return RestResponse.VOID;
    }


    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public RestResponse<Void> login(@RequestParam("username") String username,
                                    @RequestParam("password")String password,
                                    @RequestParam("role")String role) {
        userService.login(username,password,role);
        return RestResponse.VOID;
    }

    /**
     * 注销
     * @return
     */
    @PostMapping("/logout")
    public RestResponse<Void> login() {
        SessionManager.invalidate();
        return RestResponse.VOID;
    }

}
