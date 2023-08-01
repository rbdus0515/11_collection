package edu.kh.collection.model.vo;

public class Book {
	
	private String title; // 제목
	private String name; // 작가
	private int price; // 가격
	private String cps; // 출판사
	private int bookNum; // 책번호
	
	public Book() {}

	public Book(String title, String name, int price, String cps, int bookNum) {
		super();
		this.title = title;
		this.name = name;
		this.price = price;
		this.cps = cps;
		this.bookNum = bookNum;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCps() {
		return cps;
	}

	public void setCps(String cps) {
		this.cps = cps;
	}

	@Override
	public String toString() {
		return bookNum + "번 도서 : Book [도서명= " + title + ", 작가명= " + name + 
				", 가격= " + price + "원" + ", 출판사= " + cps + "]";
	}

	
}
