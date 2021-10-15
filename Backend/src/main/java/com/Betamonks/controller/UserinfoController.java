package com.Betamonks.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Betamonks.entity.Userinfo;
import com.Betamonks.service.UserinfoService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserinfoController {

	@Autowired
	UserinfoService userinfoService;

	@GetMapping("/details")
	private List getAllUserinfo() {
		return userinfoService.getAlldetails();
	}

	@GetMapping("/details/{id}")
	private Userinfo getitem(@PathVariable("id") int id) {
		return userinfoService.getuserById(id);
	}
	@DeleteMapping("/details/{id}")
	private void delete(@PathVariable("id") int id) {
		userinfoService.delete(id);
	}

	@PostMapping("/details")
	private int saveUserinfo(@RequestBody Userinfo userinfo) {
		userinfoService.saveOrUpdate(userinfo);
		return userinfo.getId();
	}
}
