package com.codebyamir.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codebyamir.model.User;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
	 User findByEmail(String email);
	 User findByConfirmationToken(String confirmationToken);
	 Optional<User> findUserByConfirmationToken(String confirmationToken);
	 Optional<User> findUserByEmail(String email);

	 @Query(value = "select * from user u where u.first_name like %:keyword% or u.last_name like %:keyword%",nativeQuery = true)
	 List<User> findByKeyword(@Param("keyword") String keyword);
}