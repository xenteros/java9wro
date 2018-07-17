package com.github.xenteros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/hello-world")
public class HelloWorldController {


    private HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping
    public String helloWorld(){
        return helloWorldService.helloWorld();
    }


    @RequestMapping(method = GET, value = "/param")
    public String helloNameParam(@RequestParam(required = false, defaultValue = "Anonymous") String name) {
        return helloWorldService.helloName(name);
    }


    @RequestMapping(method = GET, value = "/var/{name}")
    public String helloNamePathVariable(@PathVariable String name) {
        return helloWorldService.helloName(name);

    }

    @PostMapping("/body")
    public String helloNameBody(@RequestBody String name){
        return helloWorldService.helloName(name);
    }

}
