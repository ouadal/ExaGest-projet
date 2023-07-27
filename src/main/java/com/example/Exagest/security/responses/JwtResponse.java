package com.example.Exagest.security.responses;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import static com.example.Exagest.security.utils.constants.JwtConstant.EXPIRATION_TIME;
import static com.example.Exagest.security.utils.constants.JwtConstant.TOKEN_PREFIX;

@Setter
@Getter
@RequiredArgsConstructor
@Data
public class JwtResponse {

    private String access_token;

    private String token_type = TOKEN_PREFIX;

    private long expiration_time = EXPIRATION_TIME;
}
