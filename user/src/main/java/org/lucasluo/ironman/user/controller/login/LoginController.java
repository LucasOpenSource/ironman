package org.lucasluo.ironman.user.controller.login;

import org.lucasluo.ironman.user.service.login.LoginService;
import org.lucasluo.ironman.user.view.login.LoginRequest;
import org.lucasluo.ironman.user.view.login.LoginResponse;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }
}
