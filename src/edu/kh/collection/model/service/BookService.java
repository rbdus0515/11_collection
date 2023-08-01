package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.kh.collection.model.vo.Book;

public class BookService {
	
	Scanner sc = new Scanner(System.in);
	
	private List<Book> library = new ArrayList<Book>();
	private List<Book> favList = new ArrayList<Book>();
	
	public BookService() {
		
		library.add( new Book ("책1", "작가1", 10000, "출판사1", 1111) );
		library.add( new Book ("책2", "작가2", 20000, "출판사1", 2222) );
		library.add( new Book ("책3", "작가3", 30000, "출판사1", 3333) );
		library.add( new Book ("책4", "작가4", 40000, "출판사1", 4444) );
		library.add( new Book ("책5", "작가5", 50000, "출판사1", 5555) );
		
	}
	
	public void displayMenu() {
		
		try {

			int menuNum = 0;
			do {

				System.out.println("===== 도서 목록 프로그램 =====");
				System.out.println("1. 도서 등록");
				System.out.println("2. 도서 조회");
				System.out.println("3. 도서 정보 수정");
				System.out.println("4. 도서 정보 삭제");
				System.out.println("5. 도서 즐겨찾기 추가");
				System.out.println("6. 도서 즐겨찾기 삭제");

				System.out.println("0. 프로그램 종료");

				System.out.print("\n 메뉴선택 >> ");


				menuNum = sc.nextInt();
				System.out.println(); // 줄바꿈

				switch(menuNum) {
				case 1 : System.out.println( addBook() ); break;
				case 2 : bookList(library) ; break;
				case 3 : System.out.println( editBook() ); break;
				case 4 : System.out.println( deleteBook() ); break;
				case 5 : System.out.println( addFavorite() ); break;
				case 6 : System.out.println( deleteFavorite() ); break;
				case 0 : System.out.println("프로그램 종료..."); break;
				default : System.out.println("메뉴에 작성된 번호만 입력해주세요."); break;
				}
				
			} while(menuNum != 0);
				
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 1. 도서 등록 메서드
	 */
	public String addBook() {
		
		System.out.println("===== 도서 등록 =====");
		
		System.out.println("도서 번호 : ");
		int bookNum = sc.nextInt();
		sc.nextLine();
		
		System.out.print("도서명 : ");
		String title = sc.nextLine();
		
		System.out.print("작가명 : ");
		String name = sc.nextLine();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("출판사 : ");
		String cps = sc.nextLine();
		
		Book newBook = new Book(title, name, price, cps, bookNum);
		
		library.add(newBook);
		
		return "등록완료";
		
	}

	/**
	 * 2. 도서 전체 조회 메서드
	 */
	public void bookList(List<Book> list) {
		
		System.out.println("===== 도서 조회 =====");

		if(list.isEmpty()) {
			System.out.println("등록된 도서가 없습니다. 도서를 등록해주세요.");
		} else {
			for(Book temp : list) {
				System.out.println(temp);
			}
		}
		
		
	}
	
	/**
	 * 3. 도서 정보 수정 메서드
	 */
	public String editBook() {
		bookList(library);
		
		int editMenu = 0;
		
		System.out.println("===== 도서 정보 수정 =====");
		
		
		System.out.print("수정할 도서 번호 입력 : ");
		int bookNum = sc.nextInt();
		
		boolean flag = true;
		
		for(Book temp : library) {
			
			if(temp.getBookNum() == bookNum) {
				flag = false;
				
				System.out.println("1. 도서명");
				System.out.println("2. 작가명");
				System.out.println("3. 가격");
				System.out.println("4. 출판사");
				System.out.println("0. 종료");
				System.out.println("어떤 정보를 수정하시겠습니까?");
				
				// 번호를 받고 번호에 맞는 값 수정
				editMenu = sc.nextInt();
				sc.nextLine();
				
				switch(editMenu) {
				case 1 :  System.out.println("== 도서명 수정 ==");
				System.out.print("수정할 도서명을 입력하세요 : ");
				String title = sc.nextLine();
				temp.setTitle(title);
				break;
				
				case 2 :  System.out.println("== 작가명 수정 ==");
				System.out.print("수정할 작가명을 입력하세요 : ");
				String name = sc.nextLine();
				temp.setTitle(name);
				break;
				
				case 3 :  System.out.println("== 가격 수정 ==");
				System.out.print("수정할 가격을 입력하세요 : ");
				String price = sc.nextLine();
				temp.setTitle(price);
				break;
				
				case 4 :  System.out.println("== 도서 출판사 수정 ==");
				System.out.print("수정할 출판사을 입력하세요 : ");
				String cps = sc.nextLine();
				temp.setTitle(cps);
				break;
				
				case 0 : System.out.println("종료합니다."); break;
				
				default : System.out.println("잘못 입력하셨습니다."); break;
				}
			}

			if(flag) {
				return "일치하는 도서번호가 없습니다.";
			}
		}
		return "수정 완료";
	}
	
	/**
	 * 4. 도서 정보 제거 메서드
	 */
	public String deleteBook() {
		
		System.out.println("===== 도서 정보 제거 =====");
		
		bookList(library);
		
		System.out.print("제거할 도서 인덱스 입력 : ");
		int deletNum = sc.nextInt();
		
		for( Book temp : library ) {
			if(temp.getBookNum() == deletNum) {
				int index = library.indexOf(temp);
				
				System.out.print("정말 삭제 하시겠습니까? (Y/N) : ");
				
				char ch = sc.next().toUpperCase().charAt(0);
				
				if(ch == 'Y') {
					library.remove(index);
					break;
				} else {
					return "삭제를 진행하지 않습니다.";
				}
			}
			
		}
		
		return "삭제 끝";
		
	}
	
	/**
	 * 5. 도서 즐겨찾기 메서드 
	 */
	public String addFavorite() {
		
		System.out.println("===== 도서 즐겨찾기 =====");
		
		System.out.print("도서 등록번호 : ");
		int input = sc.nextInt();
		
		boolean flag = true;
		
		for(Book temp : library) {
			if(temp.getBookNum() == input) {
				favList.add(temp);
				flag = false;
			}
		}
		
		if(flag) {
			return "등록 번호가 없습니다.";
		} else {
			return "등록 성공";
		}
		
		
	}
	
	/**
	 * 6. 도서 즐겨찾기 삭제 메서드
	 */
	public String deleteFavorite() {
		bookList(favList);

		
		System.out.println("===== 도서 즐겨찾기 삭제 =====");
		
		System.out.print("즐겨찾기 삭제할 도서 번호 입력 : ");
		int input = sc.nextInt();
		
		boolean flag = true;
		
	
		for( Book temp : library ) {
			if(temp.getBookNum() == input) {
				int index = favList.indexOf(temp);
				System.out.print("정말 삭제 하시겠습니까? (Y/N) : ");
				char ch = sc.next().toUpperCase().charAt(0);


				if(ch == 'Y') {
					favList.remove(index);

					flag = false;

					break;
				}
			}
		}
		if(flag) {
			return "등록 번호가 없습니다.";
		} else {
			return "등록 성공";
		}
		
	}
	
	
	
	
	
	
	
	
	
}


























