package BookStore;

import java.util.Date;

/**
* A object representing a simplified version of a book.
* A book has a Date of publishing, an author, a number of pages expressed as an integer and 
* a String representing the International Standard Book Number.
* 
* @author Davide Spataro
*/
public class Book {
	
	private String author;
	private Date year;
	private int npages;
	private String ISBN;
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the year
	 */
	public Date getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(Date year) {
		this.year = year;
	}
	/**
	 * @return the npages
	 */
	public int getNpages() {
		return npages;
	}
	/**
	 * @param npages the npages to set
	 */
	public void setNpages(int npages) {
		this.npages = npages;
	}
	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}
	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	

}
