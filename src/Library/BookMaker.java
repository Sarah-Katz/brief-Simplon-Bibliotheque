package Library;

import java.util.List;
import java.util.Scanner;

/**
 * This class contains the methods used to add new books to the library
 * 
 * @author Sarah Katz
 *
 */
public class BookMaker {

	public static void newBook(List<Book> bookList) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println(
					"Bonjour, nous allons enregistrer votre livre, merci de renseigner les informations suivantes :");
			System.out.println("Titre du livre :");
			String title = in.nextLine();
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
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void confirmNewBook(List<Book> bookList, String title, String author, String genre, int pageNumber,
			int copies, StringBuilder result, Scanner in) {
		System.out.println(result);
		System.out.println("Confirmez vous les informations renseignéees ? (Oui : o / Non : n)");
		String confirm = in.next();
		confirm.toLowerCase();
		switch (confirm) {
		case "o":
			Book book = new Book(title, author, genre, pageNumber, copies);
			bookList.add(book);
			System.out.println("Votre livre à bien été enregistré.");
			break;
		case "n":
			newBook(bookList);
			break;
		default:
			System.out.println("entrée invalide");
			confirmNewBook(bookList, title, author, genre, pageNumber, copies, result, in);
		}
	}

}
