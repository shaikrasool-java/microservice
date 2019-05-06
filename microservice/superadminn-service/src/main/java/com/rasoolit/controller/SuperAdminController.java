package com.rasoolit.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.rasoolit.exceptionmapper.CustomExceptionMapper;
import com.rasoolit.exceptionmapper.ErrorDetails;
import com.rasoolit.service.SuperAdminService;

@ControllerAdvice
@RestController
@RequestMapping("/superadmin")
public class SuperAdminController {
	@Autowired
	private SuperAdminService superService;

	@PostMapping(value = "/addAdmin")
	public ResponseEntity<String> addAdminBySuperAdmin(@RequestBody String adminBody) {
		JSONObject json = new JSONObject(adminBody);
		System.out.println(json.toString());
		String id = (String) json.get("hospId");
		int hid = Integer.parseInt(id);
		System.out.println(hid);
		String hospInfo = null;
		hospInfo = superService.getHospInfoById(hid);
		json.put("hospId", hospInfo);
		System.out.println(hospInfo);
		System.out.println(json.toString());
		String adminInfo = superService.addAdmin(json.toString());
		return new ResponseEntity<>(adminInfo, HttpStatus.OK);

	}

	@ExceptionHandler(CustomExceptionMapper.class)
	public final ResponseEntity<ErrorDetails> handleException(CustomExceptionMapper cm, WebRequest req) {
		ErrorDetails ed = new ErrorDetails("enter valid data", cm.getMessage());
		req.getDescription(false);
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
}
