package playwithjava.in.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class GlobalLogConfig implements GlobalFilter {

    /*Its will log entry for each call to going through service-gateway*/

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("############# path :  "+exchange.getRequest().getPath()+" "+exchange.getRequest().getMethod());
        return chain.filter(exchange);
    }
}
