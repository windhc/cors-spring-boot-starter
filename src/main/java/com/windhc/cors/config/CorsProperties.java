package com.windhc.cors.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author windhc
 */
@ConfigurationProperties(prefix = "cors")
public class CorsProperties {

    private Boolean enabled;

    private String allowOrigin;

    /**
     * 用于设置Access-Control-Allow-Headers/Access-Control-Expose-Headers
     */
    private String allowHeaders;

    /**
     * 用于设置Access-Control-Allow-Credentials
     */
    private boolean allowCredentials = false;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getAllowOrigin() {
        return allowOrigin;
    }

    public void setAllowOrigin(String allowOrigin) {
        this.allowOrigin = allowOrigin;
    }

    public String getAllowHeaders() {
        return allowHeaders;
    }

    public void setAllowHeaders(String allowHeaders) {
        this.allowHeaders = allowHeaders;
    }

    public boolean isAllowCredentials() {
        return allowCredentials;
    }

    public void setAllowCredentials(boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
    }
}
