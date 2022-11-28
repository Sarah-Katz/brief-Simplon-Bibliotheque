package libraryApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * This class contains methods used to export and import CSV files containing
 * informations on the book list
 * 
 * @author Sarah Katz
 *
 */
public class CSVManager {
	private static final String DELIMITER = ",";
	private static final String SEPARATOR = "\n";
	private static final String HEADER = "Titre,Auteur.ice,Genre,Nombre de pages,Nombre de copies,Est loué ?";

	/**
	 * This method exports the list of books in the Library in a .csv file
	 * 
	 * @param library  the Library containing bookList
	 * @param bookList the bookList you want exported in .csv
	 */
	protected static void exportCSV(final Library library, final List<Book> bookList) {
		FileWriter bookListCSV = null;
		try {
			bookListCSV = new FileWriter("Liste_des_livres.csv");
			bookListCSV.append(HEADER).append(SEPARATOR);
			Iterator<Book> it = bookList.iterator();
			while (it.hasNext()) {
				Book b = (Book) it.next();
				int pageNumber = b.getPageNumber();
				String pageNumberString = Integer.toString(pageNumber);
				int copies = b.getCopies();
				String copiesString = Integer.toString(copies);
				String rented;
				if (b.isRented() == true) {
					rented = "true";
				} else {
					rented = "false";
				}
				bookListCSV.append(b.getTitle()).append(DELIMITER);
				bookListCSV.append(b.getAuthor()).append(DELIMITER);
				bookListCSV.append(b.getGenre()).append(DELIMITER);
				bookListCSV.append(pageNumberString).append(DELIMITER);
				bookListCSV.append(copiesString).append(DELIMITER);
				bookListCSV.append(rented).append(SEPARATOR);
			}
			Scanner in = new Scanner(System.in);
			System.out.println("Confirmez vous vouloir exporter la liste ? (Oui : o / Non : n)");
			String userChoice = in.nextLine();
			userChoice.toLowerCase();
			switch (userChoice) {
			case "o":
				bookListCSV.close();
				System.out.println(
						"Le fichier à bien été exporté, il se trouve dans le dossier racine du programme sous le nom 'Liste_des_livres.csv'");
				Menu.mainMenu(library, bookList);
				break;
			case "n":
				bookListCSV = null;
				Menu.mainMenu(library, bookList);
			default:
				bookListCSV = null;
				System.out.println("entrée invalide");
				exportCSV(library, bookList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method imports the list of books in the Library from a .csv file The
	 * .csv file must be named "Liste_des_livres.csv" and be in the root folder of
	 * the program
	 * 
	 * @param library  the Library containing bookList
	 * @param bookList the bookList you want imported from the .csv
	 */
	protected static void importCSV(final Library library, final List<Book> bookList) {
		try {
			List<Book> newBookList = new ArrayList<Book>();
			File file = new File("Liste_des_livres.csv");
			Scanner in = new Scanner(file);
			in.nextLine(); // Skips the first line in the .CSV to have an exception cause by non decimal
							// characters in rows where Integers are wanted
			while (in.hasNext()) {
				String str = in.nextLine();
				String[] bookInfo = str.split(",");
				String title = bookInfo[0];
				String author = bookInfo[1];
				String genre = bookInfo[2];
				String pageNumberA = bookInfo[3];
				String copiesA = bookInfo[4];
				boolean isRented;
				if ("true".equalsIgnoreCase(bookInfo[5])) {
					isRented = true;
				} else {
					isRented = false;
				}
				Integer pageNumber = Integer.valueOf(pageNumberA);
				Integer copies = Integer.valueOf(copiesA);
				Book book = new Book(title, author, genre, pageNumber, copies, isRented);
				System.out.println("Liste importée !");
				newBookList.add(book);
			}
			Menu.mainMenu(library, newBookList);
		} catch (IOException e) {
			System.out.println("_________________________________");
			System.out.println("|                               |");
			System.out.println("| /!\\  Fichier innexistant /!\\  |");
			System.out.println("|_______________________________|");
			System.out.println("________________________________________________________________________________");
			System.out.println("|                                                                              |");
			System.out.println("|Pour importer un fichier, déplacez-le à la racine du programme et nommez-le : |");
			System.out.println("|Liste_des_livres.csv                                                          |");
			System.out.println("|______________________________________________________________________________|");
			Menu.mainMenu(library, bookList);
		}
	}
}
