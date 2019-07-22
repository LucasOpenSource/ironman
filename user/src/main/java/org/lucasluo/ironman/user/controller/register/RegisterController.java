package org.lucasluo.ironman.user.controller.register;

import javax.annotation.Resource;
import org.lucasluo.ironman.user.business.user.UserBusiness;
import org.lucasluo.ironman.user.view.user.register.UserRegisterRequest;
import org.lucasluo.ironman.user.view.user.register.UserRegisterResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Resource
    private UserBusiness userBusiness;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public UserRegisterResponse userRegister(@RequestBody UserRegisterRequest request) {
        return userBusiness.userRegister(request);
    }
}
