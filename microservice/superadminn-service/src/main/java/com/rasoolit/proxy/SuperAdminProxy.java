package com.rasoolit.proxy;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.rasoolit.exceptionmapper.CustomExceptionMapper;

@Component
public class SuperAdminProxy {
	@Autowired
	private Environment env;

	public String getHospitalById(int id) {
		RestTemplate rt = new RestTemplate();
		String hospUri = env.getProperty("hosp.geturi.baseUri")+id;
//		URI uri = new URI(hospUri + "findHospital/" + id);
//		System.out.println(uri);
		System.out.println(env.getProperty("hosp.geturi.baseUri"));

		String hospInfo = rt.getForObject(hospUri, String.class);

		return hospInfo;
	}

	public String createAdmin(String adminBody) {
		RestTemplate rt = new RestTemplate();
		
		String uri = env.getProperty("admin.geturi.baseUri");
		System.out.println(uri);
		HttpHeaders header = new HttpHeaders();
		header.set("content-type", "application/json");
		HttpEntity<String> req = new HttpEntity<String>(adminBody, header);
	String	adminInfo= rt.postForObject(uri, req, String.class);
            System.out.println(adminInfo);
            if(adminInfo==null&&adminInfo.equals("")) {
            	throw new CustomExceptionMapper("Plz enter valid data", 500);
            }
            return adminInfo;
	}
}
