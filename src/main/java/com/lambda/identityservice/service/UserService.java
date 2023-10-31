package com.lambda.identityservice.service;

import com.lambda.identityservice.domain.UserDomain;
import com.lambda.identityservice.dto.ResponseDto;

public interface UserService {
    ResponseDto getAllUsers ();

    ResponseDto addNewUser(UserDomain userDomain);

    ResponseDto getUserById(Long id);

    ResponseDto getUserByRole(String role);

}
