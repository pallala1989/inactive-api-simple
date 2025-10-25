package com.javapoc.aspect;

import com.javapoc.annotation.InactiveApi;
import com.javapoc.config.InactiveApiConfig;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Component
public class InactiveApiAspect {

    @Autowired
    private InactiveApiConfig config;

    @Before("@annotation(inactiveApi)")
    public void beforeInactiveApiCall(InactiveApi inactiveApi) {
        if (config.isBlockInactiveApi()) {
            System.out.println("Blocked Inactive API call: " + inactiveApi.reason());
            throw new ResponseStatusException(HttpStatus.GONE, inactiveApi.reason());
        } else {
            System.out.println("Inactive API called but blocking is DISABLED: " + inactiveApi.reason());
        }
    }
}
