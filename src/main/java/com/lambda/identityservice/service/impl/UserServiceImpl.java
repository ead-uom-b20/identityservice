package com.lambda.identityservice.service.impl;

import com.lambda.identityservice.domain.UserDomain;
import com.lambda.identityservice.dto.ResponseDto;
import com.lambda.identityservice.repository.UserRepository;
import com.lambda.identityservice.service.UserService;
import com.lambda.identityservice.utils.ServiceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ServiceUtil serviceUtil;
    @Override
    public ResponseDto getAllUsers() {
        ResponseDto responseDto;
        try{
            List<UserDomain> userDomains = userRepository.findAll();
            responseDto =  serviceUtil.getServiceResponse(userDomains);
        } catch (Exception e){
            responseDto =  serviceUtil.getErrorServiceResponse("Error in fetching users");
        }
        return responseDto;
    }

    @Override
    public ResponseDto addNewUser(UserDomain userDomain) {
        ResponseDto responseDto;
        try{
            UserDomain savedUser = userRepository.save(userDomain);
            responseDto =  serviceUtil.getServiceResponse(savedUser);
        } catch (Exception e){
            responseDto =  serviceUtil.getErrorServiceResponse("Can not create new user");
        }
        return responseDto;
    }

    @Override
    public ResponseDto getUserById(Long id) {
        ResponseDto responseDto;
        try{
            Optional<UserDomain> userDomain = userRepository.findById(id);
            if(userDomain.isPresent()){
                responseDto =  serviceUtil.getServiceResponse(userDomain.get());
            }else{
                responseDto =  serviceUtil.getServiceResponse(null);
            }
        } catch (Exception e){
            responseDto =  serviceUtil.getErrorServiceResponse("Can not get user");
        }
        return responseDto;
    }

    @Override
    public ResponseDto getUserByRole(String role) {
        ResponseDto responseDto;
        try{
            List<UserDomain> userDomains = userRepository.findAllByUserrole(role);
            responseDto =  serviceUtil.getServiceResponse(userDomains);
        } catch (Exception e){
            responseDto =  serviceUtil.getErrorServiceResponse("Error in fetching users");
        }
        return responseDto;
    }

}