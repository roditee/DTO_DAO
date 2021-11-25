package dbProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public BookDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/dbreport?serverTimezone=UTC";
			String user = "root";
			String pwd = "1234";
			
			con = DriverManager.getConnection(url, user, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 public void insertBook(BookDTO bookDTO) {
		 try {
			String sql = "insert into book values(?, ?, ?, ?, ?, ?)";
			 
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1, bookDTO.getBookNo());
			 pstmt.setString(2, bookDTO.getBookTitle());
			 pstmt.setString(3, bookDTO.getBookAuthor());
			 pstmt.setInt(4, bookDTO.getBookYear());
			 pstmt.setInt(5, bookDTO.getBookPrice());
			 pstmt.setString(6, bookDTO.getBookPublisher());
			 
			 pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 public void selectBook() {
		 try {
			 String sql = "select * from book order by bookNo";
			 
			 pstmt = con.prepareStatement(sql);
			 rs = pstmt.executeQuery(sql);
			 
			 while(rs.next()) {
				 String bookNo = rs.getString(1);
				 String bookTitle = rs.getString(2);
				 String bookAuthor = rs.getString(3);
				 int bookYear = rs.getInt(4);
				 int bookPrice = rs.getInt(5);
				 String bookPublisher = rs.getString(6);
				 
				 System.out.format("%-4s\t%-8s\t%3s\t%4d\t%-7d\t%5s\n",
						 bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
				 }
				
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
	 }
}