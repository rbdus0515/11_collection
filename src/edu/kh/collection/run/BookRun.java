package edu.kh.collection.run;

import edu.kh.collection.model.service.BookService;

public class BookRun {

	public static void main(String[] args) {

		BookService service = new BookService();
		
		service.displayMenu();
	}

}
