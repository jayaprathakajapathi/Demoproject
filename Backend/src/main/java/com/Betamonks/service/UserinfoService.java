package com.Betamonks.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Betamonks.entity.Userinfo;

import com.Betamonks.repository.UserinfoRepository;


@Service
public class UserinfoService {

	@Autowired
	UserinfoRepository userinfoRepository;

	@Autowired
	

	public List getAlldetails() {
		List users = new ArrayList();
		 userinfoRepository.findAll().forEach(userinfo -> users.add(userinfo));
		return users;
	}

	public Userinfo getuserById(int id) {
		return  userinfoRepository.findById(id).get();
	}
    public void saveOrUpdate(Userinfo userinfo) {
		
    	 userinfoRepository.save(userinfo);
	}

	 public void delete(int id) {
		 userinfoRepository.deleteById(id);
	}
}