package libraryApp;

import java.util.List;

/**
 * This class represents a book and it's informations : Title, Author, Genre,
 * Number of pages and Number of copies.
 *
 * @author Sarah Katz
 *
 */
public class Book extends Library {
	private String title;
	private String author;
	private String genre;
	private int pageNumber;
	private int copies;

	/**
	 * This constructor creates an instance of Book using parameters
	 *
	 * @param bookList   the list containing books to be used in Library class
	 * @param title      Book title
	 * @param author     Book author
	 * @param genre      Book genre
	 * @param pageNumber Number of pages in the book
	 * @param copies     Number of copies of the book
	 * @param isRented   The book's availability
	 */
	public Book(final List<Book> bookList, final String title, final String author, final String genre, final int pageNumber, final int copies) {
		super(bookList);
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.pageNumber = pageNumber;
		this.copies = copies;
	}

	/**
	 * this method can be called to display informations about the books in bookList
	 *
	 * @return List of books registered in the program
	 */
	public StringBuilder showBookInfos() {
		StringBuilder result = new StringBuilder();
		result.append("Titre : ").append(this.getTitle()).append("\n");
		result.append("Auteur.ice : ").append(this.getAuthor()).append("\n");
		result.append("Genre : ").append(this.getGenre()).append("\n");
		result.append("Nombre de pages : ").append(this.getPageNumber()).append("\n");
		result.append("Nombre de copies : ").append(this.getCopies()).append("\n");
		return result;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(final String author) {
		this.author = author;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(final String genre) {
		this.genre = genre;
	}

	/**
	 * @return the number of pages
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber the number of pages to set
	 */
	public void setPageNumber(final int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the number of copies
	 */
	public int getCopies() {
		return copies;
	}

	/**
	 * @param copies the number of copies to set
	 */
	public void setCopies(final int copies) {
		this.copies = copies;
	}
}
