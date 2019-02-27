package com.rollingstone.spring.service;

import com.rollingstone.spring.dao.UserDaoRepository;
import com.rollingstone.spring.model.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl
		implements UserService {

    @Autowired private UserDaoRepository userDao;

    @Override
    public User save(User user) {
	return userDao.save(user);
    }

    @Override
    public Optional<User> get(long id) {
	return userDao.findById(id);
    }

    @Override
    public Page<User> getUsersByPage(Integer pageNumber, Integer pageSize) {
	Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userName").descending());
	return userDao.findAll(pageable);
    }

    @Override
    public void update(long id, User user) {
	userDao.save(user);
    }

    @Override
    public void delete(long id) {
	userDao.deleteById(id);
    }

}
