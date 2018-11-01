package org.skroom.auth;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * TokenGeneratorService
 */
public class TokenGeneratorService {

    private final int tokenKeyBits;

    private final String tokenKeyId;

    @Inject
    public TokenGeneratorService(@Named("org.skroom.jwt.key.id") String tokenKeyId, @Named("org.skroom.jwt.key.bits") int tokenKeyBits) {
        this.tokenKeyBits = tokenKeyBits;
        this.tokenKeyId = tokenKeyId;

        System.out.println(tokenKeyBits);
        System.out.println(tokenKeyId);
    }

    
}