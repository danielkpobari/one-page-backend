package com.danitest.kpobaritest.service;


import com.danitest.kpobaritest.dto.request.UserRequest;
import com.danitest.kpobaritest.dto.response.ApiResponse;
import com.danitest.kpobaritest.model.User;

public interface UserService {
    ApiResponse<User> create(UserRequest userRequest);

    ApiResponse<User> getById(Long userId);

    ApiResponse<User> update(Long userId, UserRequest userRequest);
}
