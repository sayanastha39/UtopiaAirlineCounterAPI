package com.ss.utopia.utopiaAirline.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ss.utopia.utopiaAirline.POJO.*;

@Repository

public interface UserDAO extends JpaRepository <User, Integer> {

	Optional<User> findByUsername(String username);
}
