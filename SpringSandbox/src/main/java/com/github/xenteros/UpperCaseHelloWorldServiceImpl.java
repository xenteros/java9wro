package com.github.xenteros;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Profile("upper")
class UpperCaseHelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String helloWorld() {
        return "Hello World!".toUpperCase();
    }

    @Override
    public String helloName(String name) {
        return format("Hello %s!", name).toUpperCase();
    }
}
