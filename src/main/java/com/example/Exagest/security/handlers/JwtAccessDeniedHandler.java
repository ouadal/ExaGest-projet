package com.example.Exagest.security.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.Exagest.security.responses.HttpErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;

import static com.example.Exagest.security.utils.constants.JavaConstant.ACCESS_DENIED_MESSAGE;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        HttpErrorResponse errorResponse = new HttpErrorResponse();
        errorResponse.setStatus(UNAUTHORIZED);
        errorResponse.setStatusCode(UNAUTHORIZED.value());
        errorResponse.setReason(UNAUTHORIZED.getReasonPhrase());
        errorResponse.setMessage(ACCESS_DENIED_MESSAGE);
        httpServletResponse.setContentType(APPLICATION_JSON_VALUE);
        httpServletResponse.setStatus(FORBIDDEN.value());
        OutputStream outputStream = httpServletResponse.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream, errorResponse);
        outputStream.flush();
    }
}
