package com.javapoc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InactiveApiConfig {

    @Value("${inactive.api.block:true}")
    private boolean blockInactiveApi;

    public boolean isBlockInactiveApi() {
        return blockInactiveApi;
    }

    public void setBlockInactiveApi(boolean blockInactiveApi) {
        this.blockInactiveApi = blockInactiveApi;
    }
}
