package com.egoday.earsample.spring.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
		return String.format("greeting %s", name);
	}

}
