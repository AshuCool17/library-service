/**
 * 
 */
package com.mycompany.library.model;

import java.util.Date;

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
	
	private boolean isBookIssued;
	
	private Date issueDate;
	
	private Date returnDate;
	
	private double penalty;
	
	

}
