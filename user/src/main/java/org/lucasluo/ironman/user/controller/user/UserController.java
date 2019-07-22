package org.lucasluo.ironman.user.controller.user;

import javax.annotation.Resource;
import lombok.extern.java.Log;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.lucasluo.ironman.base.result.ResultMessage;
import org.lucasluo.ironman.user.business.user.UserBusiness;
import org.lucasluo.ironman.user.view.user.CreateUserRequest;
import org.lucasluo.ironman.user.view.user.CreateUserResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserBusiness userBusiness;

    @RequiresPermissions(value = {"user:create"}, logical = Logical.AND)
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        log.info("/user");
        return new CreateUserResponse(ResultMessage.SUCCESS.toString());
    }
}
