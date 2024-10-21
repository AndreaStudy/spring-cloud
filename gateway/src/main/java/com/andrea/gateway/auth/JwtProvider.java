package com.andrea.gateway.auth;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JwtProvider {
    @Value("${jwt.secret}")
    private String secretKey;

    /**
     * 토큰 검증
     * @param token jwtToken
     * @return true(유효) / false(X)
     */
    public boolean validateToken(String token) {
        try {
            // 토큰 파싱
            log.info("토큰검증");
            Jwts.parserBuilder()
                    .setSigningKey(Decoders.BASE64.decode(secretKey))
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            log.info("토큰검증 실패 : 토큰 만료");
            return false;
        } catch (Exception e) {
            log.info("토큰검증 실패 : 토큰 오류");
            return false;
        }
    }

}