/**
 * 
 */
package com.rajiv.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rajiv.dashboard.enitity.ResourceURL;


/**
 * @author rajk0517
 *
 */
@Repository
public interface ResourceURLRepository extends JpaRepository<ResourceURL, Long>{

}
