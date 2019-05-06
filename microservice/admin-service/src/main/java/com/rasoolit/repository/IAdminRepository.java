package com.rasoolit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rasoolit.domain.Admin;
@Repository
public interface IAdminRepository extends CrudRepository<Admin, Integer> {

}
