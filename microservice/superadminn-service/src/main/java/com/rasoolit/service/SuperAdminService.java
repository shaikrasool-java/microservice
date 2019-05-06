package com.rasoolit.service;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rasoolit.proxy.SuperAdminProxy;

@Service
public class SuperAdminService {
	@Autowired
	private SuperAdminProxy  sproxy;
	
	public String getHospInfoById(int id)  {
		return sproxy.getHospitalById(id);	
	}
public String addAdmin(String adminBody) {
	System.out.println("SuperAdminService.addAdmin()"+adminBody);
	return sproxy.createAdmin(adminBody);
}
}
