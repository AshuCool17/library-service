/**
 * 
 */
package com.mycompany.library.model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private int id;
	
	private String name;
	
	private String password;
	
	private boolean isBookIssued;
	
	private LocalDate issueDate;
	
	private LocalDate returnDate;
	
	private double penalty;
	
	private boolean hasSubscription;
	
	private String country;
	
	private List<String> books;
	
	private boolean isActive;

}
