package libraryApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sarah Katz
 *
 */
public class Menu {

	/**
	 * Initializes the program and the book list
	 */
	public static void startProgram() {
		List<Book> bookList = new ArrayList<Book>();
		mainMenu(bookList);
	}

	/**
	 * This method calls the main menu to be displayed and let's user decide what
	 * they want to do using numbers for action selection through a switch
	 * 
	 * @param bookList
	 */
	protected static void mainMenu(final List<Book> bookList) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("-------------------------------------------------------");
			System.out.println("Bienvenue dans le menu de navigation, vous souhaitez : ");
			System.out.println("1 - Enregistrer un nouveau livre");
			System.out.println("2 - Afficher la liste des livres");
			System.out.println("3 - Rechercher ou modifier un livre");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("-------------------------------------------------------");

			int userChoice = in.nextInt();

			switch (userChoice) {
			case 1:
				BookManager.newBook(bookList);
				break;
			case 2:
				BookManager.showBookList(bookList);
				break;
			case 3:
				BookManager.searchBook(bookList);
				break;
			default:
				System.out.println("entrée invalide");
				mainMenu(bookList);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
