package com.cloudgateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/loginServiceFallBack")
    public String loginServiceFallBack() {
        return "Login Service is taking longer than expected to respond." +
                " Please check back in sometime ";
    }

    @GetMapping("/registerServiceFallBack")
    public String registerServiceFallBack() {
        return "Register Service is taking longer than expected to respond." +
                " Please check back in sometime.";
    }
}