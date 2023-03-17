package com.sagem.emt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sagem.emt.dao.entity.User;
import com.sagem.emt.dao.repository.UserRepository;

@Service
public class UserService implements com.sagem.emt.service.UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
	return userRepository.findAll();
    }

    @Override
    public User save(User u) {
	return userRepository.save(u);
    }

    @Override
    public void deleteAll() {
	userRepository.deleteAll();
    }

    @Override
    public void delete(Long id) {
	userRepository.deleteById(id);
    }
}
