package dbProject;

import java.util.Scanner;

public class BookTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("도서 정보 등록");
		System.out.println("----------------------\n");
		
		System.out.print("도서번호 입력 : ");
		String bookNo = sc.nextLine();
		
		System.out.print("도서명 입력 : ");
		String bookTitle = sc.nextLine();
		
		System.out.print("저자 입력 : ");
		String bookAuthor = sc.nextLine();
		
		System.out.print("출판년도 입력 : ");
		int bookYear = Integer.parseInt(sc.nextLine());
		
		System.out.print("가격 입력 : ");
		int bookPrice = Integer.parseInt(sc.nextLine());
		
		System.out.print("출판사 입력 : ");
		String bookPublisher = sc.nextLine();
		
		BookDTO bookDTO = new BookDTO(bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
		BookDAO bookDAO = new BookDAO();
		
		bookDAO.insertBook(bookDTO);
		bookDAO.selectBook();
	}
}