package com.windhc.cors.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.util.StringUtils;
import com.windhc.cors.filter.CorsFilter;

/**
 * @author windhc
 */
@Configuration
@ConditionalOnClass(CorsFilter.class)
@ConditionalOnWebApplication
@EnableConfigurationProperties(CorsProperties.class)
@ConditionalOnProperty(prefix = "cors", name = "enabled", havingValue = "true")
public class CorsAutoConfiguration {

    @Autowired
    private CorsProperties properties;

    @Bean
    public FilterRegistrationBean corsFilterChainRegistration() {

        if (properties.isAllowCredentials()) {
            if(StringUtils.isEmpty(properties.getAllowOrigin().trim())) {
                throw new IllegalStateException("Allow origin can not be null if allow credentials of CORS");
            }
//            Preconditions.checkState(!"*".equals(allowOrigin),
//                    "Allow origin can not be wildcard '*' if allow credentials of CORS");
        }

        CorsFilter corsFilter = new CorsFilter();
        if (!StringUtils.isEmpty(properties.getAllowOrigin().trim())) {
            corsFilter.setAllowOrigin(properties.getAllowOrigin());
        }
        corsFilter.setAllowHeaders(properties.getAllowHeaders());
        corsFilter.setAllowCredentials(properties.isAllowCredentials());

        FilterRegistrationBean registration = new FilterRegistrationBean(corsFilter);
        registration.addUrlPatterns("/*");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return registration;
    }
}
