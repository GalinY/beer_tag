package com.beerdemo.demo.repositories;

import com.beerdemo.demo.entities.Role;

public interface RoleRepository {

	public Role loadUserRightsByUserRightsName(String name) ;
}
