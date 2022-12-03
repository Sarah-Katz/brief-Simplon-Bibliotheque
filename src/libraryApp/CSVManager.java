package libraryApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
	private static final String DELIMITER = "\\|";
	private static final String SEPARATOR = "\n";
	private static final String HEADER = "Titre,Auteur.ice,Genre,Nombre de pages,Nombre de copies";

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
				bookListCSV.append(b.getTitle()).append(DELIMITER);
				bookListCSV.append(b.getAuthor()).append(DELIMITER);
				bookListCSV.append(b.getGenre()).append(DELIMITER);
				bookListCSV.append(pageNumberString).append(DELIMITER);
				bookListCSV.append(copiesString).append(SEPARATOR);
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
				bookListCSV.close();
				Menu.mainMenu(library, bookList);
			default:
				bookListCSV.close();
				System.out.println("entrée invalide");
				exportCSV(library, bookList);
			}

		} catch (InputMismatchException e) {
			System.out.println("___________________________________________________________");
			System.out.println("|Une erreur relative à l'entrée utilisateur s'est produite|");
			System.out.println("|_________________________________________________________|");
			exportCSV(library, bookList);
		} catch (IOException e1) {
			System.out.println("__________________________________________________________");
			System.out.println("|Une erreur relative à l'export du fichier s'est produite|");
			System.out.println("|________________________________________________________|");
			Menu.mainMenu(library, bookList);
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
				String[] bookInfo = str.split(DELIMITER);
				String title = bookInfo[0];
				String author = bookInfo[1];
				String genre = bookInfo[2];
				String pageNumberString = bookInfo[3];
				String copiesString = bookInfo[4];
				Integer pageNumber;
				Integer copies;
				try {
					pageNumber = Integer.valueOf(pageNumberString);
				} catch (NumberFormatException errPages) {
					pageNumber = 0;
					StringBuilder error = new StringBuilder();
					error.append("Erreur sur le livre : ").append(bookInfo[0]).append("\n")
							.append("Nombre de page invalide, nouvelle entrée = 0");
					System.out.println(error);
				}
				try {
					copies = Integer.valueOf(copiesString);
				} catch (NumberFormatException errCopies) {
					copies = -1;
					StringBuilder error = new StringBuilder();
					error.append("Erreur sur le livre : ").append(bookInfo[0]).append("\n")
							.append("Nombre d'exemplaires invalide, nouvelle entrée = -1");
					System.out.println(error);
				}
				Book book = new Book(bookList, title, author, genre, pageNumber, copies);
				newBookList.add(book);
			}
			System.out.println("Liste importée !");
			Menu.mainMenu(library, newBookList);
		} catch (IOException e) {
			System.out.println("________________________________");
			System.out.println("|                              |");
			System.out.println("| /!\\  Fichier inexistant /!\\  |");
			System.out.println("|______________________________|");
			System.out.println("________________________________________________________________________________");
			System.out.println("|                                                                              |");
			System.out.println("|Pour importer un fichier, déplacez-le à la racine du programme et nommez-le : |");
			System.out.println("|Liste_des_livres.csv                                                          |");
			System.out.println("|______________________________________________________________________________|");
			Menu.mainMenu(library, bookList);
		}
		catch (NumberFormatException e) {
			System.out.println("___________________________________________________________________________________");
			System.out.println("|                                                                                 |");
			System.out.println("|Une erreur existe dans le fichier, veuillez verifier ses données et son formatage|");
			System.out.println("|_________________________________________________________________________________|");
			Menu.mainMenu(library, bookList);
		}
	}
}
