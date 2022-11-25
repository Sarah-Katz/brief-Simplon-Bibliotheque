package Library;

/**This class represents a book and it's informations : Title, Author, Genre, Number of pages and Number of copies.
 * @author Sarah Katz
 *
 */
public class Book {
	String title;
	String author;
	String genre;
	int pageNumber;
	int copies;
	
	/** This constructor creates an instance of Book
	 * @param title Book title
	 * @param author Book author
	 * @param genre Book genre
	 * @param pageNumber Number of pages in the book
	 * @param copies Number of copies of the book
	 */
	public Book(String title, String author, String genre, int pageNumber, int copies) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.pageNumber = pageNumber;
		this.copies = copies;
	}
}
