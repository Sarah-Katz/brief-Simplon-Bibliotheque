/**
 * 
 */
package libraryApp;

import java.util.List;

/**
 * @author Sarah Katz
 *
 */
public class Library {
	private List<Book> bookList;
	
	Library(final List<Book> bookList) {
		this.setBookList(bookList);
	}
	
	public  void exportBookList() {
		
	}

	/**
	 * @return the bookList
	 */
	public List<Book> getBookList() {
		return bookList;
	}

	/**
	 * @param bookList the bookList to set
	 */
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
}