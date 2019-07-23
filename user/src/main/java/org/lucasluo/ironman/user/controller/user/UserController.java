package org.lucasluo.ironman.user.controller.user;

import javax.annotation.Resource;
import lombok.extern.java.Log;
import org.lucasluo.ironman.user.business.user.UserBusiness;
import org.lucasluo.ironman.user.view.user.GetAllUsersResponse;
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

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public GetAllUsersResponse createUser() {
        return userBusiness.getAllUsers();
    }

}
