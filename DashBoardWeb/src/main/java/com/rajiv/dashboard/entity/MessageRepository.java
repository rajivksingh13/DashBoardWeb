/**
 * 
 */
package com.rajiv.dashboard.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rajk0517
 *
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	

}
