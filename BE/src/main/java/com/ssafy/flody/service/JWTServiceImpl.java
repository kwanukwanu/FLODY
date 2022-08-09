package com.ssafy.flody.service;

import com.ssafy.flody.config.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JWTServiceImpl implements JWTService{
    private final JwtTokenProvider jwtTokenProvider;

    public String decodeToken(String token) throws Exception {
        return jwtTokenProvider.decodeToken(token);
    }
}
