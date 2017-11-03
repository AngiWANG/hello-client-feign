package com.allinpay.sample.hello.client.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloClientController {

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private HelloService helloService;

	@RequestMapping(value = "/helloClientFeign1", method = RequestMethod.GET)
	public String hello1() {
		logger.info("helloClientFeign1 received.");
		return helloService.hello();
	}

	@RequestMapping(value = "/helloClientFeign2", method = RequestMethod.GET)
	public String hello2() {
		logger.info("helloClientFeign2 received.");
		StringBuilder sb = new StringBuilder();
		sb.append(helloService.hello()).append("\n");
		sb.append(helloService.hello("world")).append("\n");
		sb.append(helloService.hello("world", 90)).append("\n");
		sb.append(helloService.hello(new User("world", 90)));
		return sb.toString();
	}
}
