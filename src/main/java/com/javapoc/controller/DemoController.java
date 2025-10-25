package com.javapoc.controller;

import com.javapoc.annotation.InactiveApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/active")
    public String activeApi() {
        System.out.println("Active API called successfully.");
        return "This is an ACTIVE API response.";
    }

    @GetMapping("/inactive")
    @InactiveApi(reason = "This API is inactive if you need this functionality please contact support team.")
    public String inactiveApi() {
        System.out.println("This line should never be executed.");
        return "Inactive API — should be blocked.";
    }
    @GetMapping("/inactivetest2")
    @InactiveApi
    public String oldAPI() {
        System.out.println("This line should never be executed.");
        return "Any response from old API.";
    }


    @PostMapping("/hello")
    public String sayHello(@RequestBody String name) {
        System.out.println("Hello API executed for: " + name);
        return "Hello " + name + " from active API!";
    }
}
