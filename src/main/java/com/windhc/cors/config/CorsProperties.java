package com.windhc.cors.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author windhc
 */
@ConfigurationProperties(prefix = "cors")
public class CorsProperties {

    /**
     * required
     * Enable cross-origin request handling for the specified path pattern.
     * <p>Exact path mapping URIs (such as {@code "/admin"}) are supported as
     * well as Ant-style path patterns (such as {@code "/admin/**"}).
     * <p>By default, all origins, all headers, credentials and {@code GET},
     * {@code HEAD}, and {@code POST} methods are allowed, and the max age
     * is set to 30 minutes.
     */
    private Boolean enabled;

    /**
     * Enable cross-origin request handling for the specified path pattern.
     * <p>Exact path mapping URIs (such as {@code "/admin"}) are supported as
     * well as Ant-style path patterns (such as {@code "/admin/**"}).
     * <p>By default, all origins, all headers, credentials and {@code GET},
     * {@code HEAD}, and {@code POST} methods are allowed, and the max age
     * is set to 30 minutes.
     * pathPattern the path pattern to enable CORS handling for
     */
    private String mappingPathPattern = "/**";

    /**
     * Set the origins to allow, e.g. {@code "http://domain1.com"}.
     * <p>The special value {@code "*"} allows all domains.
     * <p>By default, all origins are allowed.
     */
    private String[] allowedOrigins = {"*"};

    /**
     * Set the HTTP methods to allow, e.g. {@code "GET"}, {@code "POST"}, etc.
     * <p>The special value {@code "*"} allows all methods.
     * <p>By default "simple" methods {@code GET}, {@code HEAD}, and {@code POST}
     * are allowed.
     */
    private String[] allowedMethods;

    /**
     * Set the list of headers that a pre-flight request can list as allowed
     * for use during an actual request.
     * <p>The special value {@code "*"} may be used to allow all headers.
     * <p>A header name is not required to be listed if it is one of:
     * {@code Cache-Control}, {@code Content-Language}, {@code Expires},
     * {@code Last-Modified}, or {@code Pragma} as per the CORS spec.
     * <p>By default all headers are allowed.
     */
    private String[] allowedHeaders = {"*"};

    /**
     * Set the list of response headers other than "simple" headers, i.e.
     * {@code Cache-Control}, {@code Content-Language}, {@code Content-Type},
     * {@code Expires}, {@code Last-Modified}, or {@code Pragma}, that an
     * actual response might have and can be exposed.
     * <p>Note that {@code "*"} is not supported on this property.
     * <p>By default this is not set.
     */
    private String[] exposedHeaders;

    /**
     * Configure how long in seconds the response from a pre-flight request
     * can be cached by clients.
     * <p>By default this is set to 1800 seconds (30 minutes).
     */
    private Long maxAge = 1800L;

    /**
     * Whether user credentials are supported.
     * <p>By default this is set to {@code true} in which case user credentials
     * are supported.
     */
    private Boolean allowCredentials = true;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getMappingPathPattern() {
        return mappingPathPattern;
    }

    public void setMappingPathPattern(String mappingPathPattern) {
        this.mappingPathPattern = mappingPathPattern;
    }

    public String[] getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(String[] allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public String[] getAllowedMethods() {
        return allowedMethods;
    }

    public void setAllowedMethods(String[] allowedMethods) {
        this.allowedMethods = allowedMethods;
    }

    public String[] getAllowedHeaders() {
        return allowedHeaders;
    }

    public void setAllowedHeaders(String[] allowedHeaders) {
        this.allowedHeaders = allowedHeaders;
    }

    public String[] getExposedHeaders() {
        return exposedHeaders;
    }

    public void setExposedHeaders(String[] exposedHeaders) {
        this.exposedHeaders = exposedHeaders;
    }

    public Long getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Long maxAge) {
        this.maxAge = maxAge;
    }

    public Boolean getAllowCredentials() {
        return allowCredentials;
    }

    public void setAllowCredentials(Boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
    }
}
