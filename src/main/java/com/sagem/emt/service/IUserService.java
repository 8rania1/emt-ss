package com.sagem.emt.service;

import java.util.List;

import com.sagem.emt.dao.entity.User;

public interface IUserService {

	public List<User>getAll();
	   public User addUser(User u);
	   public void deleteAll();
	   public void deleteUser(Long id);

}
