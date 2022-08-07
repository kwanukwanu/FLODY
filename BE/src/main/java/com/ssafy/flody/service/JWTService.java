package com.ssafy.flody.service;

public interface JWTService {
    public String decodeToken(String token) throws Exception;
}
