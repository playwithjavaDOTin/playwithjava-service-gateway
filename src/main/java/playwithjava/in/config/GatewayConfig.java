package playwithjava.in.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GatewayConfig  {

    @Bean
    public RouteLocator getLocator(RouteLocatorBuilder builder){

        /*Adding header value to incoming request*/
      /*  redirecting request to given url*/
        Function<PredicateSpec, Buildable<Route>> fn=
                p->p.path("/get")
                        .filters(f->f
                                        .addRequestHeader("JRF_TOKEN","token_value")
                                        .addRequestHeader("AUTH-TOKEN","Tokne"))
                                .uri("http://httpbin.org:80/");

      return  builder.routes()
                .route(fn).build();
    }

}
