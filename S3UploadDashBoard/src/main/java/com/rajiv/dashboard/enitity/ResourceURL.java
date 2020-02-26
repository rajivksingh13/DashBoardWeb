/**
 * 
 */
package com.rajiv.dashboard.enitity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * @author rajk0517
 *
 */
@Component
@Entity
public class ResourceURL {
	
	@Id
	@GeneratedValue
	private long Id;
	private String resourceURL;
	
	public ResourceURL() {
	}
	
	public ResourceURL(String resourceURL) {
		super();
		//Id = id;
		this.resourceURL = resourceURL;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getResourceURL() {
		return resourceURL;
	}
	public void setResourceURL(String resourceURL) {
		this.resourceURL = resourceURL;
	}
	
	@Override
	public String toString() {
		return "ResourceURL [Id=" + Id + ", resourceURL=" + resourceURL + "]";
	}

}
