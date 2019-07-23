package org.lucasluo.ironman.user.business.user;

import com.lucasluo.ironman.common.utils.StringUtils;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.lucasluo.ironman.base.result.ResultMessage;
import org.lucasluo.ironman.user.entity.UserRegisterEntity;
import org.lucasluo.ironman.user.entity.user.UserEntity;
import org.lucasluo.ironman.user.model.User;
import org.lucasluo.ironman.user.service.user.UserService;
import org.lucasluo.ironman.user.utils.UserUtils;
import org.lucasluo.ironman.user.view.user.GetAllUsersResponse;
import org.lucasluo.ironman.user.view.user.register.UserRegisterRequest;
import org.lucasluo.ironman.user.view.user.register.UserRegisterResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class UserBusiness {
    @Resource
    private UserService userService;

    public UserRegisterResponse userRegister(UserRegisterRequest request) {
        UserRegisterResponse response = new UserRegisterResponse();
        UserRegisterEntity userRegisterEntity = request.getData();
        if(userRegisterEntity == null
            || StringUtils.isNullOrWhitespace(userRegisterEntity.getUsername())
            || StringUtils.isNullOrWhitespace(userRegisterEntity.getPassword())) {
            response.setMessage(ResultMessage.INVALID_PARAMETER.getValue());
        } else {
            User user = new User();
            SecureRandom ran = null;
            try {
                ran = SecureRandom.getInstance("SHA1PRNG");
                user.setPrimaryKey(ran.nextLong());
                user.setUserName(userRegisterEntity.getUsername());
                user.setPassword(userRegisterEntity.getPassword());
                user.setRealName(userRegisterEntity.getRealname());
                Date date = new Date();
                user.setCreator(userRegisterEntity.getUsername());
                user.setCreateTime(date);
                user.setModifier(userRegisterEntity.getUsername());
                user.setModifyTime(date);
                UserUtils.signPassword(user);
                userService.addUser(user);
                response.setMessage(ResultMessage.REGISTER_USER_SUCCEED.getValue());
            } catch (NoSuchAlgorithmException e) {
                log.error("生成主键错误", e);
                response.setMessage(ResultMessage.FAIL.getValue());
            }
        }
        return response;
    }

    public GetAllUsersResponse getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserEntity> userEntities = new ArrayList<>();
        GetAllUsersResponse response = new GetAllUsersResponse(ResultMessage.SUCCESS.getValue());
        if(CollectionUtils.isEmpty(users)) {
            response.setMessage(ResultMessage.FAIL.getValue());
        } else {
            users.forEach((user) -> {
                UserEntity userEntity = new UserEntity();
                userEntity.setPrimaryKey(user.getPrimaryKey());
                userEntity.setUserName(user.getUserName());
                userEntity.setPassword(user.getPassword());
                userEntity.setRealName(user.getRealName());
                userEntity.setCreator(user.getCreator());
                userEntity.setCreateTime(user.getCreateTime());
                userEntity.setModifier(user.getModifier());
                userEntity.setModifyTime(user.getModifyTime());
                userEntities.add(userEntity);
            });
            response.setData(userEntities);
        }
        return response;
    }
}
