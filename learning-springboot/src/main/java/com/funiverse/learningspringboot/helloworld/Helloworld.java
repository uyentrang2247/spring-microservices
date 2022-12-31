package com.funiverse.learningspringboot.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController
public class Helloworld {

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWord(){
        return "Hello Trang";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
    public HelloWorldBean helloWordBean(){
        return new HelloWorldBean("Hey bae");
    }

    @GetMapping(path = "/hello-world-bean/{name}")
    public HelloWorldBean helloWordParam(@PathVariable String name){
        return new HelloWorldBean(String.format("Hey bae %s",name));
    }

}
