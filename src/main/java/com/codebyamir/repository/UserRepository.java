package com.codebyamir.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codebyamir.model.User;

import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
	 User findByEmail(String email);
	 User findByConfirmationToken(String confirmationToken);
	 Optional<User> findUserByConfirmationToken(String resetToken);
	 Optional<User> findUserByEmail(String email);
}