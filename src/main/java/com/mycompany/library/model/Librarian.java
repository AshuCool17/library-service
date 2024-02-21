/**
 * 
 */
package com.mycompany.library.model;

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
public class Librarian {

	private long id;
	
	private String name;
	
	private String password;

	private String role;
	
	private boolean isActive;
}
