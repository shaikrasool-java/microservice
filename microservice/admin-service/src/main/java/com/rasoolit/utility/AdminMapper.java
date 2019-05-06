package com.rasoolit.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rasoolit.bean.AdminBean;
import com.rasoolit.domain.Admin;

public class AdminMapper {

	public static Admin mapBeanToDomain(AdminBean adminBean) {
		Admin admin = new Admin();
		admin.setId(adminBean.getId());
		admin.setFirstName(adminBean.getFirstName());
		admin.setLastName(adminBean.getLastName());
		admin.setEmail(adminBean.getEmail());
		admin.setPassword(adminBean.getPassword());
		admin.setConfPswd(adminBean.getConfPswd());
		admin.setMobile(adminBean.getMobile());
		admin.setStatus((adminBean.isStatus()));
		admin.setHospId(adminBean.getHospId());
				return admin;
	}// mapBeanToDomain

	public static AdminBean mapDomainToBean(Admin admin) {
		AdminBean adminBean = new AdminBean();
		
		adminBean.setFirstName(admin.getFirstName());
		adminBean.setLastName(admin.getLastName());
		adminBean.setEmail(admin.getEmail());
		adminBean.setPassword(admin.getPassword());
		adminBean.setConfPswd(admin.getConfPswd());
		adminBean.setMobile(admin.getMobile());
		adminBean.setStatus((admin.isStatus()));
		adminBean.setId(admin.getId());
		adminBean.setHospId(admin.getHospId());
		return adminBean;

			}
	
	public static List<AdminBean> mapDomainListToBean(Iterator<Admin> adminList){
		List<AdminBean> adminBeansList = null;
		if(adminList != null) {
			adminBeansList = new ArrayList<AdminBean>();
			while(adminList.hasNext()) {
				adminBeansList.add(mapDomainToBean(adminList.next()));
			}
		}
		return adminBeansList;
	}

}
