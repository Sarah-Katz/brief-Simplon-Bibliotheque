
package libraryApp;

import java.util.List;

/**
 * This class represents a library and contains the list of all it's books
 * 
 * @author Sarah Katz
 *
 */
public class Library {
	private List<Book> bookList;
	
	Library(final List<Book> bookList) {
		this.setBookList(bookList);
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