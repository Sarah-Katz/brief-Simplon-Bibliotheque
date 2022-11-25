package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	/**
	 * Initializes the menu
	 */
	public static void startProgram() {
		try {
			List<Book> bookList = new ArrayList<Book>();
			Scanner in = new Scanner(System.in);
			System.out.println("Bienvenue dans le menu de navigation, vous souhaitez : ");
			System.out.println("1 - Enregistrer un nouveau livre");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			int userChoice = in.nextInt();
			
			switch (userChoice) {
			case 1:
				BookMaker.newBook(bookList);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
