package com.github.xenteros;

import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/hello-world")
public class HelloWorldController {

    @RequestMapping
    public String helloWorld(){
        return "Hello World!";
    }


    @RequestMapping(method = GET, value = "/param")
    public String helloNameParam(@RequestParam(required = false, defaultValue = "Anonymous") String name) {
        return format("Hello %s!", name);

    }


    @RequestMapping(method = GET, value = "/var/{name}")
    public String helloNamePathVariable(@PathVariable String name) {
        return format("Hello %s!", name);

    }

    @PostMapping("/body")
    public String helloNameBody(@RequestBody String name){
        return format("Hello %s!", name);
    }

}
