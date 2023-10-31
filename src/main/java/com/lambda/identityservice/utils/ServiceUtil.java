package com.lambda.identityservice.utils;
import com.lambda.identityservice.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServiceUtil {
    public ResponseDto getServiceResponse(Object responseObject) {
        return ResponseDto.builder()
                .status(Boolean.TRUE)
                .response(responseObject)
                .build();
    }
    public ResponseDto getErrorServiceResponse(String error) {
        return ResponseDto.builder()
                .status(Boolean.FALSE)
                .error(error)
                .build();
    }
}