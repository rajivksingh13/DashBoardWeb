/**
 * 
 */
package com.rajiv.dashboard.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;
import javax.persistence.GeneratedValue;

/**
 * @author rajk0517
 *
 */
@Component
@Entity
public class Message {
	
	@Id
	@GeneratedValue
	private long Id;
	private String message;
	
	public Message() {
		
	}
	
	public Message(String message) {
		super();
		//this.Id = Id;
		this.message = message;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Message [Id=" + Id + ", message=" + message + "]";
	}

}
