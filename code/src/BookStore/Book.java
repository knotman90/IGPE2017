package BookStore;

import java.util.Date;

import Sorting.IComparable;

/**
* A object representing a simplified version of a book.
* A book has a Date of publishing, an author, a number of pages expressed as an integer and 
* a String representing the International Standard Book Number.
* 
* @author Davide Spataro
*/
public class Book implements IComparable{
	
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
	
	/**
	 * A Book compares strictly greater than another if 
	 * year > rhs.year || (year == rhs.year) && npages > rhs.npages
	 */
	@Override
	public boolean compare(IComparable book) {
		Book rhs = (Book)book;
		if(year.after(rhs.getYear())) 
				return true;
		else
			if(year.equals(rhs.year) && npages > rhs.npages)
				return true;
		return false;		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [author=" + author + ", year=" + year + ", npages="
				+ npages + ", ISBN=" + ISBN + "]";
	}
	

}
