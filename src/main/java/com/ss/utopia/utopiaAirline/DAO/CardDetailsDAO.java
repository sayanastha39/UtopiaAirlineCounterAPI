
package com.ss.utopia.utopiaAirline.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ss.utopia.utopiaAirline.POJO.*;

@Repository

public interface CardDetailsDAO extends JpaRepository<CardDetails, Integer> {

}