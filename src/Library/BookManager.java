package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class contains the methods used to add new books to the library
 * 
 * @author Sarah Katz
 *
 */
public class BookManager {

	/**
	 * This method lets the user instance a new Book in bookList using parameters
	 * he'll input
	 * 
	 * @param bookList List of books registered in the program
	 */
	protected static void newBook(List<Book> bookList) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Retour menu : 'm'");
			System.out.println(
					"Bonjour, nous allons enregistrer votre livre, merci de renseigner les informations suivantes :");
			System.out.println("Titre du livre : ");
			String title = in.nextLine();
			switch (title) {
			case "m":
				Menu.mainMenu(bookList);
			default:
				System.out.println("L'auteur.ice du livre :");
				String author = in.nextLine();
				System.out.println("Le genre du livre :");
				String genre = in.nextLine();
				System.out.println("Le nombre de page :");
				int pageNumber = in.nextInt();
				System.out.println("Le nombre de copies :");
				int copies = in.nextInt();
				System.out.println("Veuillez confirmer les informations renseignées");
				StringBuilder result = new StringBuilder();
				result.append("Titre : ").append(title).append("\n").append("Auteur.ice : ").append(author).append("\n")
						.append("Genre : ").append(genre).append("\n").append("Nombre de pages : ").append(pageNumber)
						.append("\n").append("Nombre de copies : ").append(copies);
				confirmNewBook(bookList, title, author, genre, pageNumber, copies, result, in);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * This method let's the user search a list of books by author name *
	 * 
	 * @param bookList List of books registered in the program
	 */
	protected static void searchBook(List<Book> bookList) {
		try {
			List<Book> bookOfSearchedAuthor = new ArrayList<Book>();
			Scanner in = new Scanner(System.in);
			System.out.println("Retour menu : 'm'");
			System.out.println("Veuillez entrer le nom de l'auteur.ice du livre recherché :");
			String searchedAuthor = in.nextLine();
			switch (searchedAuthor) {
			case "m":
				Menu.mainMenu(bookList);
			default:
				boolean isFoundResult = false;
				for (Book book : bookList) {
					if (book.getAuthor().equalsIgnoreCase(searchedAuthor)) {
						bookOfSearchedAuthor.add(book);
					}
				}
				if (bookOfSearchedAuthor.size() > 0) {
					System.out.println("Voici les livres de cet.te auteur.ice :");
					for (Book book : bookOfSearchedAuthor) {
						System.out.println(book.showInfos());
					}
					isFoundResult = true;
					confirmSearchBook(bookList, in, isFoundResult);
				} else {
					confirmSearchBook(bookList, in, isFoundResult);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * This method will display infos about all books in the bookList param
	 * 
	 * @param bookList List of books registered in the program
	 */
	protected static void showBookList(final List<Book> bookList) {
		for (Book book : bookList) {
			System.out.println(book.showInfos());
		}
		Menu.mainMenu(bookList);
	}

	// confirmation menu for newBook inputs
	private static void confirmNewBook(final List<Book> bookList, final String title, final String author,
			final String genre, final int pageNumber, final int copies, final StringBuilder result, final Scanner in) {
		System.out.println(result);
		System.out.println("Confirmez vous les informations renseignéees ? (Oui : o / Non : n)");
		String confirm = in.next();
		confirm.toLowerCase();
		switch (confirm) {
		case "o":
			Book book = new Book(title, author, genre, pageNumber, copies);
			bookList.add(book);
			System.out.println("Votre livre à bien été enregistré.");
			Menu.mainMenu(bookList);
			break;
		case "n":
			newBook(bookList);
			break;
		default:
			System.out.println("entrée invalide");
			confirmNewBook(bookList, title, author, genre, pageNumber, copies, result, in);
		}
	}

	// confirmation menu when searchBook() returns no result
	private static void confirmSearchBook(final List<Book> bookList, final Scanner in, final boolean isFoundResult) {
		if (isFoundResult == true) {
			System.out.println("Souhaitez vous effectuer une nouvelle recherche ? (Oui : o / Non : n)");
		} else {
			System.out.println(
					"Aucun livres de cet.te auteur.ice n'est présent, souhaitez vous effectuer une nouvelle recherche ? (Oui : o / Non : n)");
		}
		String userChoice = in.next();
		switch (userChoice) {
		case "o":
			searchBook(bookList);
			break;
		case "n":
			Menu.mainMenu(bookList);
			break;
		default:
			System.out.println("entrée invalide");
		}
	}

}
