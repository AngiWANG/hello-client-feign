package com.allinpay.sample.hello.client.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello-service")
public interface HelloService {

	@RequestMapping("/hello")
	String hello();

	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public String hello(@RequestParam("name") String name);

	/**
	 * 查询用户
	 * 
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/hello3", method = RequestMethod.POST)
	public String hello(@RequestBody User user);
}
