package edu.kh.collection.model.service;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Book;

public class BookService {
	
	Scanner sc = new Scanner(System.in);
	
	private List<Book> bookList = new LinkedList<Book>();
	
	public BookService() {
		
		bookList.add( new Book ("용의자X의 헌신", "히가시노게이고", 15120, "제인출판사") );
		bookList.add( new Book ("용의자X의 헌신", "히가시노게이고", 15120, "제인출판사") );
		bookList.add( new Book ("용의자X의 헌신", "히가시노게이고", 15120, "제인출판사") );
		bookList.add( new Book ("용의자X의 헌신", "히가시노게이고", 15120, "제인출판사") );
	
	}
	
	public void displayMenu() {
		
		int menuNum = 0;
		
		do {

			System.out.println("===== 도서 목록 프로그램 =====");
			System.out.println("1. 도서 등록");
			System.out.println("2. 등록 도서 전체 조회");
			System.out.println("3. 도서 정보 수정");
			System.out.println("4. 도서 정보 삭제");
			System.out.println("5. 도서 좋아요 추가");
			System.out.println("6. 도서 좋아요 삭제");

			System.out.println("0. 프로그램 종료");

			System.out.print("\n 메뉴선택 >> ");

			try {

				menuNum = sc.nextInt();
				System.out.println(); // 줄바꿈

				switch(menuNum) {
				case 1 : System.out.println( addBook() ); break;
				case 2 : selectAll(); break;
				case 3 : System.out.println( updateBook() ); break;
				case 4 : System.out.println( removeBook() ); break;
				case 5 : System.out.println("도서 좋아요 추가"); break;
				case 6 : System.out.println("도서 좋아요 삭제"); break;
				case 0 : System.out.println("프로그램 종료..."); break;
				default : System.out.println("메뉴에 작성된 번호만 입력해주세요.");
				}

			} catch(InputMismatchException e) {
				System.out.println("\n error : 입력 형식이 유효하지 않습니다. 다시 시도해주세요.");

				sc.nextLine(); // 입력 버퍼에 남아있는 잘못된 문자열 제거

				menuNum = -1; // 첫 반복시 잘못 입력하는 경우
				// menuNum이 0을 가지고 있어 종료되는데
				// 이를 방지하기 위해 임의값 -1 대입
			}

		} while(menuNum != 0);
		
		
		
		
	}
	
	/**
	 * 1. 도서 등록 메서드
	 */
	public String addBook() throws InputMismatchException {
		
		System.out.println("===== 도서 등록 =====");
		
		System.out.print("도서명 : ");
		String title = sc.next();
		
		System.out.print("작가명 : ");
		String name = sc.next();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("출판사 : ");
		String cps = sc.next();
		
		if( bookList.add (new Book (title, name, price, cps) ) ) {
			return "성공";
		} else {
			return "실패";
		}
		
	}

	/**
	 * 2. 도서 전체 조회 메서드
	 */
	public void selectAll() throws InputMismatchException {
		
		System.out.println("===== 도서 전체 조회 =====");

		if(bookList.isEmpty()) {
			System.out.println("도서 정보가 없습니다.");
			return;
		}
		int index = 0;
		for(Book b : bookList) {
			
			System.out.print((index++) + "번 : ");
			System.out.println(b);
			
		}
		
		
	}
	
	/**
	 * 3. 도서 정보 수정 메서드
	 */
	public String updateBook() {
		
		System.out.println("===== 도서 정보 수정 =====");
		
		System.out.print("검색할 인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		if(bookList.isEmpty()) {
			return"검색 할 도서가 없습니다.";
		} else if ( index < 0 ) {
			return "음수는 입력하실 수 없습니다.";
		} else if ( index >= bookList.size()) {
			return "범위를 벗어난 값을 입력할 수 없습니다.";
		} else {
			
			
			return "수정 완료";
		}
		
		
		
	}
	
	/**
	 * 4. 도서 정보 제거 메서드
	 */
	public String removeBook() throws InputMismatchException {
		
		System.out.println("===== 도서 정보 제거 =====");
		
		System.out.print("제거할 도서 인덱스 입력 : ");
		int index = sc.nextInt();
		
		if(bookList.isEmpty()) {
			return "검색 할 도서가 없습니다.";
		} else if (index < 0) {
			return "음수는 입력하실 수 없습니다.";
		} else if (index >= bookList.size()) {
			return "입력 범위를 벗어나셨습니다.";
		} else {
			System.out.println("정말 삭제 하시겠습니까? (Y/N)");
			char ch = sc.next().toUpperCase().charAt(index);
			
			if(ch == 'Y') {
				Book temp = bookList.remove(index);
				return temp.getTitle() + "의 정보가 삭제되었습니다.";
			} else {
				return "취소";
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
}


























