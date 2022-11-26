package Library;

/**
 * This class represents a book and it's informations : Title, Author, Genre,
 * Number of pages and Number of copies.
 * 
 * @author Sarah Katz
 *
 */
public class Book {
	private String title;
	private String author;
	private String genre;
	private int pageNumber;
	private int copies;

	/**
	 * This constructor creates an instance of Book
	 * 
	 * @param title      Book title
	 * @param author     Book author
	 * @param genre      Book genre
	 * @param pageNumber Number of pages in the book
	 * @param copies     Number of copies of the book
	 */
	public Book(final String title, final String author, final String genre, final int pageNumber, final int copies) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.pageNumber = pageNumber;
		this.copies = copies;
	}

	/** TODO: doc this
	 * @return
	 */
	public StringBuilder showInfos() {
		StringBuilder result =  new StringBuilder();
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
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(final int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the copies
	 */
	public int getCopies() {
		return copies;
	}

	/**
	 * @param copies the copies to set
	 */
	public void setCopies(final int copies) {
		this.copies = copies;
	}
	
	
}
