package com.github.xenteros;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Primary
@Service
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
