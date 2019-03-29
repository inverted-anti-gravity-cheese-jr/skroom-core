package org.skroom.auth;

import org.springframework.beans.factory.annotation.Value;

/**
 * TokenGeneratorService
 */
public class TokenGeneratorService {

    @Value("org.skroom.jwt.key.bits")
    private int tokenKeyBits;

    @Value("org.skroom.jwt.key.id")
    private String tokenKeyId;
    
}