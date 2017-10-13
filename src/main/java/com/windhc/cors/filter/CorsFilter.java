package com.windhc.cors.filter;


import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class CorsFilter extends OncePerRequestFilter {

    private static final String[] ALLOW_HEADERS = { "Content-Type", "Cache-Control", "Pragma", "Origin", "Cookie", "Link",
            "X-Total-Count", "*" };

    private String allowOrigin = "*";

    private String allowHeaders = "";

    private boolean allowCredentials = false;

    public void setAllowOrigin(String allowOrigin) {
        this.allowOrigin = allowOrigin;
    }

    public void setAllowHeaders(String allowHeaders) {
        this.allowHeaders = allowHeaders;
    }

    public void setAllowCredentials(boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (CorsUtils.isCorsRequest(request)) {
            response.setHeader("Access-Control-Allow-Origin", allowOrigin);
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Credentials", String.valueOf(allowCredentials));

            if (!StringUtils.isEmpty(allowHeaders)) {
                response.setHeader("Access-Control-Allow-Headers", allowHeaders);
                response.setHeader("Access-Control-Expose-Headers", allowHeaders);
            }
            if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
                response.setStatus(HttpServletResponse.SC_OK);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
