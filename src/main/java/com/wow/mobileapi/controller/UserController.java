package com.wow.mobileapi.controller;

import com.wow.mobileapi.dto.ApiResponse;
import com.wow.mobileapi.util.ResponseUtil;
import com.wow.mobileapi.util.ValidatorUtil;
import com.wow.user.model.EndUser;
import com.wow.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{endUserId}", method = RequestMethod.GET)
    public ApiResponse getEndUserById(@PathVariable Integer endUserId) {
        ApiResponse apiResponse = new ApiResponse();
        if (endUserId == null) {
            apiResponse.setResCode("40000");
            apiResponse.setResMsg("请指定用户ID");
        } else {
            EndUser endUser = userService.getEndUserById(endUserId);
            apiResponse.setResCode("0");
            apiResponse.setResMsg("success");
            apiResponse.setData(endUser);
        }
        return apiResponse;
    }

    /**
     * 用户注册(创建新用户)
     * @param newEndUser
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ApiResponse register(@Validated @RequestBody EndUser newEndUser, BindingResult result) {
        ApiResponse apiResponse = new ApiResponse();

        if (result.hasErrors()) {
            ResponseUtil.setResponse(apiResponse,"40000");
            Map<String, String> map = ValidatorUtil.getErrors(result);
            apiResponse.setData(map);
        } else {
            boolean isRegisterSuccess = false;
            int i= userService.register(newEndUser);
            if (i==1) {
                isRegisterSuccess = true;
            }
            ResponseUtil.setResponse(apiResponse,"0");
            apiResponse.setData(isRegisterSuccess);
        }
        return apiResponse;
    }

    /**
     * 修改用户信息
     * @param endUserId
     * @return
     */
    @RequestMapping(value = "/{endUserId}", method = RequestMethod.PUT)
    public ApiResponse updateUser(@RequestBody EndUser updatedEndUser, @PathVariable Integer endUserId) {
        ApiResponse apiResponse = new ApiResponse();
        if (updatedEndUser.getId() == null) {
            updatedEndUser.setId(endUserId);
        }
        boolean isSuccess =  (userService.updateEndUser(updatedEndUser) == 1);
        ResponseUtil.setResponse(apiResponse,"0");
        apiResponse.setData(isSuccess);
        return apiResponse;
    }

    @RequestMapping(value = "/{endUserId}", method = RequestMethod.DELETE)
    public ApiResponse deleteUser(@PathVariable Integer endUserId) {
        ApiResponse apiResponse = new ApiResponse();
        boolean isSuccess = (userService.deleteUser(endUserId)==1);
        ResponseUtil.setResponse(apiResponse,"0");
        apiResponse.setData(isSuccess);
        return apiResponse;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ApiResponse isExistedUserByMobile(
            @RequestParam(value = "mobile", required = true) String mobile) {
        ApiResponse apiResponse = new ApiResponse();
        boolean isSuccess = (userService.isExistedUser(mobile));
        ResponseUtil.setResponse(apiResponse,"0");
        apiResponse.setData(isSuccess);
        return apiResponse;
    }

}