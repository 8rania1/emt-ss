package com.sagem.emt.service;

import java.util.List;

import com.sagem.emt.dao.entity.User;

public interface UserService {

    public List<User> getAll();

    public User save(User u);

    public void deleteAll();

    public void delete(Long id);

}
