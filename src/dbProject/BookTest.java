package dbProject;

import java.util.Scanner;

public class BookTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� ���� ���");
		System.out.println("----------------------\n");
		
		System.out.print("������ȣ �Է� : ");
		String bookNo = sc.nextLine();
		
		System.out.print("������ �Է� : ");
		String bookTitle = sc.nextLine();
		
		System.out.print("���� �Է� : ");
		String bookAuthor = sc.nextLine();
		
		System.out.print("���ǳ⵵ �Է� : ");
		int bookYear = Integer.parseInt(sc.nextLine());
		
		System.out.print("���� �Է� : ");
		int bookPrice = Integer.parseInt(sc.nextLine());
		
		System.out.print("���ǻ� �Է� : ");
		String bookPublisher = sc.nextLine();
		
		BookDTO bookDTO = new BookDTO(bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
		BookDAO bookDAO = new BookDAO();
		
		bookDAO.insertBook(bookDTO);
		bookDAO.selectBook();
	}
}