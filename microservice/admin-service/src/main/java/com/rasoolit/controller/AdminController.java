package com.rasoolit.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rasoolit.bean.AdminBean;
import com.rasoolit.domain.Admin;
import com.rasoolit.repository.IAdminRepository;
import com.rasoolit.utility.AdminMapper;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminRepository adminRepo;

	@GetMapping(value = "/getAllAdmins")
	public ResponseEntity<List<AdminBean>> getAdminBoard() {

		Iterator<Admin> adminDomainsList = adminRepo.findAll().iterator();
		List<AdminBean> adminBeanList = AdminMapper.mapDomainListToBean(adminDomainsList);

		return new ResponseEntity<List<AdminBean>>(adminBeanList,HttpStatus.OK);
	}

	@PostMapping(value = "/addAdmin")
	public ResponseEntity<List<AdminBean>> addAdmin(@RequestBody AdminBean adminBean) {

		Admin admin = AdminMapper.mapBeanToDomain(adminBean);
		admin = adminRepo.save(admin);
		AdminMapper.mapDomainToBean(admin);
		Iterator<Admin> adminDomainsList = adminRepo.findAll().iterator();
		List<AdminBean> adminBeanList = AdminMapper.mapDomainListToBean(adminDomainsList);

		return new ResponseEntity<List<AdminBean>>(adminBeanList,HttpStatus.OK);

	}

	
	/*@GetMapping(value = "/deleteAdmin/{id}")
	public String delteAdmin(Model model, @PathVariable("id") int id) {
		adminService.deleteAdmin(id);

		Iterator<Admin> adminDomainsList = adminRepo.findAll().iterator();
		List<AdminBean> adminBeanList = AdminMapper.mapDomainListToBean(adminDomainsList);

		List<AdminBean> adminBeanList = adminService.getAllAdmins();
		model.addAttribute("adminList", adminBeanList);
		return "adminBoard";
	}

	@GetMapping(value = "/editAdmin/{id}")
	public String editAdmin(Model model, @PathVariable("id") int id) {

		Admin admin = adminRepo.findOne(id);
		AdminBean adminBean = AdminMapper.mapDomainToBean(admin);

		AdminBean adminBean = adminService.getAdminById(id);
		model.addAttribute("adminBean", adminBean);
		return "adminEdit";
	}

	@PostMapping(value = "/updateAdmin")
	public String updateAdmin(@ModelAttribute("adminBean") AdminBean adminBean) {

		Admin admin = AdminMapper.mapBeanToDomain(adminBean);
		admin = adminRepo.save(admin);
		adminBean = AdminMapper.mapDomainToBean(admin);

		adminBean = adminService.updateAdmin(adminBean);
		return "redirect:./getAdminBoard";

	}
*/
}
