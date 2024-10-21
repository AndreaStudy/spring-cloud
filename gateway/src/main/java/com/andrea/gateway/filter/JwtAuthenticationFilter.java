package com.andrea.gateway.filter;

import com.andrea.gateway.auth.JwtProvider;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<AbstractGatewayFilterFactory.NameConfig> {

    public final JwtProvider jwtProvider;

    public JwtAuthenticationFilter(JwtProvider jwtProvider) {
        super(NameConfig.class);
        this.jwtProvider = jwtProvider;
    }

    @Override
    public GatewayFilter apply(NameConfig config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = (ServerHttpRequest) exchange.getRequest();
            if(!request.getHeaders().containsKey("Authorization")) {
                return chain.filter(exchange);
            }
            String token = request.getHeaders().get("Authorization").get(0).replace("Bearer ", "");
//            todo: jwtProvider 에서 검증 메소드 불러오기
            return chain.filter(exchange);
        };
    }

}
