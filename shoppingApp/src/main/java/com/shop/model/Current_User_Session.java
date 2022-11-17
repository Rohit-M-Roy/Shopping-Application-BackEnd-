package com.shop.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Current_User_Session {
	
	@Id
	private Integer userId;
	private LocalDate localdate;
	private String key;

}
