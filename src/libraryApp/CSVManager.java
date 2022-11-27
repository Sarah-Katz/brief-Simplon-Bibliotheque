package libraryApp;

import java.io.FileWriter;
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
	private static final String HEADER = "Titre,Auteur.ice,Genre,Nombre de pages,Nombre de copies";

	
	/**This method exports the list of books in the Library in a .csv file
	 * 
	 * @param library the Library containing bookList 
	 * @param bookList the bookList you want exported in .csv
	 */
	protected static void exportCSV(final Library library, final List<Book> bookList) {
		FileWriter bookListCSV = null;
		try {
			bookListCSV = new FileWriter("Liste_des_livres.csv");
			bookListCSV.append(HEADER).append(SEPARATOR).append(SEPARATOR);
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
				System.out.println("Le fichier à bien été exporté, il se trouve dans le dossier racine du programme sous le nom 'Liste_des_livres.csv'");
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
}
