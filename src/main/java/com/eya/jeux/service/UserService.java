package com.eya.jeux.service;

import com.eya.jeux.entities.Role;
import com.eya.jeux.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles(); User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
}
