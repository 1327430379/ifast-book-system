package com.fhk.sample.web.controller;

import com.fhk.sample.common.constants.CommonConstants;
import com.fhk.sample.common.exception.BusinessException;
import com.fhk.sample.common.module.SessionManager;
import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.dto.UserDTO;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.UserService;
import com.fhk.sample.util.BizAssert;
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


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public RestResponse<User> register(@RequestBody @Validated(value = UserDTO.InsertGroup.class) UserDTO userDTO) {
        BizAssert.isTrue(isValidRole(userDTO.getRole()), "不存在该角色操作权限");
        return RestResponse.success(userService.register(this.convert(userDTO, User.class)));
    }


    private boolean isValidRole(String role) {
        return (CommonConstants.ROLE_CUSTOMER.equals(role) || CommonConstants.ROLE_MODERATOR.equals(role));
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public RestResponse<PageVO<User>> list(@RequestParam(name = "pageNum", defaultValue = "0", required = false) Integer pageNum,
                                           @RequestParam(name = "pageSize", defaultValue = "20", required = false) Integer pageSize,
                                           @RequestParam(name = "username", required = false) String username,
                                           @RequestParam(name = "name", required = false) String name,
                                           @RequestParam(name = "mobile", required = false) String mobile,
                                           @RequestParam(name = "status", required = false) Integer status,
                                           @RequestParam(name = "approveStatus", required = false) String approveStatus) {
        User user = new User();
        user.setUsername(username);
        user.setName(name);
        user.setMobile(mobile);
        user.setStatus(status);
        user.setApproveStatus(approveStatus);
        return RestResponse.success(userService.listByPage(pageNum, pageSize, user));
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    public RestResponse<User> getById(@PathVariable("id") Integer id) {
        return RestResponse.success(userService.getById(id));
    }


    /**
     * 修改
     */
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public RestResponse<User> update(@RequestBody @Validated(value = UserDTO.UpdateGroup.class) UserDTO user) {
        return RestResponse.success(userService.updateById(this.convert(user, User.class)));
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public RestResponse<Void> delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return RestResponse.VOID;
    }

    /**
     * 修改用户状态|启用或禁用
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/status/update",method = RequestMethod.POST)
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
    @RequestMapping(value = "/approve",method = RequestMethod.POST)
    public RestResponse<Void> approve(@RequestParam("id") Integer id) {
        userService.approve(id);
        return RestResponse.VOID;
    }


    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public RestResponse<Void> login(@RequestParam("username") String username,
                                    @RequestParam("password") String password,
                                    @RequestParam("role") String role) {
        BizAssert.isTrue(isValidRole(role), "不存在该角色操作权限");
        try {
            userService.login(username, password, role);
        } catch (BusinessException e) {
//            if (ExceptionCode.PASSWORD_INPUT_ERROR.getCode().equals(e.getCode())) {
//                userService.incrRetries(username);
//            }
            return RestResponse.fail(e.getCode(), e.getMessage());
        }
        return RestResponse.VOID;
    }

    /**
     * 注销
     *
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public RestResponse<Void> logout() {
        SessionManager.invalidate();
        return RestResponse.VOID;
    }

    @RequestMapping(value = "/current/user",method = RequestMethod.GET)
    public RestResponse<Object> getCurrentSession() {
        return RestResponse.success(SessionManager.getCurrentUserSession());
    }

}
