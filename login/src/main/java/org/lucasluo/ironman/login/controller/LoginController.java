package org.lucasluo.ironman.login.controller;

import javax.annotation.Resource;
import org.lucasluo.ironman.login.business.LoginBusiness;
import org.lucasluo.ironman.login.entity.UserEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Resource
    private LoginBusiness loginBusiness;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(RequestEntity<UserEntity> request) {
        return loginBusiness.login(request);
    }
}
