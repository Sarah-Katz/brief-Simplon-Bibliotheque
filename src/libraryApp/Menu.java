package libraryApp;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sarah Katz
 *
 */
public class Menu {

	/**
	 * Initializes the program and the book list If the file exists it asks the user
	 * if they want to import it
	 */
	public static void startProgram() {
		try {
			File file = new File("Liste_des_livres.csv");
			List<Book> bookList = new ArrayList<Book>();
			Library library = new Library(bookList);
			if (file.exists()) {
				Scanner in = new Scanner(System.in);
				System.out.println(
						"Fichier de la liste detecté, souhaitez-vous importer la liste des livres dans le programme ?");
				System.out.println("(Oui : o / Non : n)");
				String userResponse = in.nextLine();
				switch (userResponse) {
				case "o":
					CSVManager.importCSV(library, bookList);
					break;
				case "n":
					mainMenu(library, bookList);
					break;
				default:
					System.out.println("entrée invalide");
					startProgram();
				}
			} else {
				mainMenu(library, bookList);
			}
		} catch (InputMismatchException e) {
			System.out.println("Error in 'startProgram'");
			e.printStackTrace();
		}
	}

	/**
	 * This method calls the main menu to be displayed and let's user decide what
	 * they want to do using numbers for action selection through a switch
	 * 
	 * @param library
	 * @param bookList
	 */
	protected static void mainMenu(final Library library, final List<Book> bookList) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("_________________________________________________________");
			System.out.println("|                                                       |");
			System.out.println("|Bienvenue dans le menu de navigation, vous souhaitez : |");
			System.out.println("|1 - Enregistrer un nouveau livre                       |");
			System.out.println("|2 - Afficher la liste des livres                       |");
			System.out.println("|3 - Réserver , rendre ou modifier un livre             |");
			System.out.println("|4 - Importer la liste des livres en CSV                |");
			System.out.println("|5 - Exporter la liste des livres en CSV                |");
			System.out.println("|-------------------------------------------------------|");
			System.out.println("|6 - Fermer le programme                                |");
			System.out.println("|_______________________________________________________|");
			int userChoice = in.nextInt();
			switch (userChoice) {
			case 1:
				BookManager.newBook(library, bookList);
				break;
			case 2:
				BookManager.showBookList(library, bookList);
				break;
			case 3:
				BookManager.searchBook(library, bookList);
				break;			
			case 4:
				CSVManager.importCSV(library, bookList);
				break;
			case 5:
				CSVManager.exportCSV(library, bookList);
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("/!\\ Merci de renseigner le chiffre de l'action souhaitée /!\\");
				mainMenu(library, bookList);
			}
		} catch (InputMismatchException e) {
			System.out.println("/!\\ Merci de renseigner le chiffre de l'action souhaitée /!\\");
			mainMenu(library, bookList);
		}
	}
}
