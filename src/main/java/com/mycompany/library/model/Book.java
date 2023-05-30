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
public class Book {
	
	private long bookId;
	
	private String bookName;
	
	private String author;
	
	private Date publishDate;

}
