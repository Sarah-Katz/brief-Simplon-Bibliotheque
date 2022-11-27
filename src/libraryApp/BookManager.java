package libraryApp;

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
	protected static void newBook(final Library library, final List<Book> bookList) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Retour menu : 'm'");
			System.out.println(
					"Bonjour, nous allons enregistrer votre livre, merci de renseigner les informations suivantes :");
			System.out.println("Titre du livre : ");
			String title = in.nextLine();
			switch (title) {
			case "m":
				Menu.mainMenu(library, bookList);
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
				confirmNewBook(library, bookList, title, author, genre, pageNumber, copies, result, in);
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
	protected static void searchBook(final Library library, final List<Book> bookList) {
		try {
			List<Book> bookOfSearchedAuthor = new ArrayList<Book>();
			Scanner in = new Scanner(System.in);
			System.out.println("Retour menu : 'm'");
			System.out.println("Veuillez entrer le nom de l'auteur.ice du livre recherché :");
			String searchedAuthor = in.nextLine();
			searchedAuthor.toLowerCase();
			switch (searchedAuthor) {
			case "m":
				Menu.mainMenu(library, bookList);
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
						System.out.println(book.showBookInfos());
					}
					isFoundResult = true;
					confirmSearchBook(library, bookList, in, isFoundResult, bookOfSearchedAuthor);
				} else {
					confirmSearchBook(library, bookList, in, isFoundResult, bookOfSearchedAuthor);
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
	protected static void showBookList(final Library library, final List<Book> bookList) {
		for (Book book : bookList) {
			System.out.println(book.showBookInfos());
		}
		Menu.mainMenu(library, bookList);
	}

	// confirmation menu for newBook()
	private static void confirmNewBook(final Library library, final List<Book> bookList, final String title, final String author,
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
			Menu.mainMenu(library, bookList);
			break;
		case "n":
			newBook(library, bookList);
			break;
		default:
			System.out.println("entrée invalide");
			confirmNewBook(library, bookList, title, author, genre, pageNumber, copies, result, in);
		}
	}

	// confirmation menu for searchBook()
	private static void confirmSearchBook(final Library library, final List<Book> bookList, final Scanner in, final boolean isFoundResult,
			final List<Book> bookOfSearchedAuthor) {
		if (isFoundResult == true) {
			System.out.println("Souhaitez-vous modifier les informations d'un livre ? Oui : o / Non : n");
			String userSearchChoice = in.next();
			switch (userSearchChoice) {
			case "o":
				searchBookByTitle(library, bookList, bookOfSearchedAuthor);
				break;
			case "n":
				System.out.println("Souhaitez-vous effectuer une nouvelle recherche ? (Oui : o / Non : n)");
				String userChoice = in.next();
				switch (userChoice) {
				case "o":
					searchBook(library, bookList);
					break;
				case "n":
					Menu.mainMenu(library, bookList);
					break;
				default:
					confirmSearchBook(library, bookList, in, isFoundResult, bookOfSearchedAuthor);
				}
				break;
			default:
				System.out.println("entrée invalide");
				confirmSearchBook(library, bookList, in, isFoundResult, bookOfSearchedAuthor);
			}

		} else {
			System.out.println(
					"Aucun livres de cet.te auteur.ice n'est présent, souhaitez vous effectuer une nouvelle recherche ? (Oui : o / Non : n)");
		}
		String userChoice = in.next();
		switch (userChoice) {
		case "o":
			searchBook(library, bookList);
			break;
		case "n":
			Menu.mainMenu(library, bookList);
			break;
		default:
			System.out.println("entrée invalide");
			confirmSearchBook(library, bookList, in, isFoundResult, bookOfSearchedAuthor);
		}
	}

	// search menu for book modifying
	private static void searchBookByTitle(final Library library, final List<Book> bookList, final List<Book> bookOfSearchedAuthor) {
		Scanner in = new Scanner(System.in);
		System.out.println("Renseignez le titre du livre à modifier :");
		String searchTitle = in.nextLine();
		searchTitle.toLowerCase();
		for (Book book : bookOfSearchedAuthor) {
			if (searchTitle.equalsIgnoreCase(book.getTitle())) {
				System.out.println("Vous avez selectionné" + " " + book.getTitle());
				System.out.println("Confirmez vous la selection ? (Oui : o / Non : n)");
				String userResponse = in.next();
				switch (userResponse) {
				case "o":
					Book selectedBook = book;
					bookModifier(library, bookList, selectedBook);
					break;
				case "n":
					searchBookByTitle(library, bookList, bookOfSearchedAuthor);
					break;
				default:
					System.out.println("entrée invalide");
					searchBookByTitle(library, bookList, bookOfSearchedAuthor);
				}
			} else {
				System.out.println("Aucun titre corespondant, merci de choisir dans cette liste :");
				for (Book books : bookOfSearchedAuthor) {
					System.out.println(books.showBookInfos());
				}
				searchBookByTitle(library, bookList, bookOfSearchedAuthor);
			}
		}
	}

	// menu for book modifying
	private static void bookModifier(final Library library, final List<Book> bookList, final Book book) {
		Scanner in = new Scanner(System.in);
		System.out.println("Vous souhaitez modifier :");
		System.out.println("1 - le titre");
		System.out.println("2 - l'auteur.ice");
		System.out.println("3 - le genre");
		System.out.println("4 - le nombre de pages");
		System.out.println("5 - le nombre de copies");
		System.out.println("6 - Retour au menu principal");
		int userChoice = in.nextInt();
		in.nextLine(); // Consume newline left-over to workaround a bug found at
						// https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
		switch (userChoice) {
		case 1:
			System.out.println("Inserez le nouveau titre :");
			String newTitle = in.nextLine();
			book.setTitle(newTitle);
			break;
		case 2:
			System.out.println("Inserez le/a nouveau/elle auteur.ice :");
			String newAuthor = in.nextLine();
			book.setAuthor(newAuthor);
			bookModifier(library, bookList, book);
			break;
		case 3:
			System.out.println("Inserez le nouveau genre :");
			String newGenre = in.nextLine();
			book.setGenre(newGenre);
			bookModifier(library, bookList, book);
			break;
		case 4:
			System.out.println("Inserez le nouveau nombre de pages :");
			int newPageNumber = in.nextInt();
			book.setPageNumber(newPageNumber);
			bookModifier(library, bookList, book);
			break;
		case 5:
			System.out.println("Inserez le nouveau nombre de copies :");
			int newCopies = in.nextInt();
			book.setCopies(newCopies);
			bookModifier(library, bookList, book);
			break;
		case 6:
			Menu.mainMenu(library, bookList);
			break;
		default:
			System.out.println("entrée invalide");
			bookModifier(library, bookList, book);
		}
		bookModifier(library, bookList, book);
	}
}
