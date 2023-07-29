package com.example.Exagest.utils;

import com.example.Exagest.security.responses.HttpSuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ResponsesUtil {

    public static HttpSuccessResponse successResponse(HttpStatus status, String message, Object data) {
        HttpSuccessResponse response = new HttpSuccessResponse();
        response.setStatus(status);
        response.setMessage(message);
        response.setStatusCode(status.value());
        response.setData(data);
        return response;
    }
}
