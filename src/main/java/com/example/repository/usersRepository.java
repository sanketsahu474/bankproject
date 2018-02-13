package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.users;


@Repository("useRepository")
public interface usersRepository  extends CrudRepository<users, Integer> {
	 users findByCardno(String cardno);
}
