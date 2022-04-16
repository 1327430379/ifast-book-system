 package com.fhk.sample.web.controller;

import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.dto.UserDTO;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 用户表
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController{
    @Autowired
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
    public List<User> list(){
        PageUtils page = userService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/{id}")
    public RestResponse<User> getById(@PathVariable("id") Integer id){
		return RestResponse.success(userService.getById(id));
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public User update(@RequestBody @Validated UserDTO user){
		userService.updateById(user);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		userService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
