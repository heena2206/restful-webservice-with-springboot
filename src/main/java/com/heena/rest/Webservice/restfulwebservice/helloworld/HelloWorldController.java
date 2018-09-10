package com.heena.rest.Webservice.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//controller
@RestController
public class HelloWorldController {

	@GetMapping("/helloworld")
	public String HelloWorld()
	{
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloworldbean()
	{
		return new HelloWorldBean("hello world!!!! tumki ki karacho?");
	}
	
	@GetMapping("/helloworld/pathvariable/{name}")
	public HelloWorldBean helloworldpathvariable(@PathVariable String name )
	{
		return new HelloWorldBean(String.format("hello world!!!! tumki ki karacho? mere ,%s",name));
	}
}
