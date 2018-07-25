#DAY17
___

######oracle 라이브러리 추가
project-bulid path-config build path- add library-user library

###GIFT

	//giftupdate
	//최저, 최고 가격 변경
	System.out.println(gno+"의 최저, 최고 가격 변경");
	int min=Integer.parseInt(new Scanner(System.in).nextLine()) ;
	int max=Integer.parseInt(new Scanner(System.in).nextLine());
	pstmt=conn.prepareStatement("update gift set g_start=?, g_end=? where gno="+gno);
	pstmt.setInt(1, min);
	pstmt.setInt(2, max);
	pstmt.executeUpdate();
	System.out.println(gno+" 수정 완료");
    
    
***

###GIFT-2

	//conntectionhelper
    package dbConn;

	//중복되는 DB 연결 정보 해결
	import java.sql.*;
	public class ConnectionHelper {
	public static Connection getConnection(String dsn) {
	Connection conn=null;
	try {
		if(dsn.equals("mysql")) {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampleDB","sj","mysql");
		
		}
		else if	(dsn.equals("oracle")) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String user = "sj";
			String password = "oracle";
			conn = DriverManager.getConnection(url, user, password);
		}
	} catch (Exception e) {
		// TODO: handle exception
	//		System.out.println(e.getMessage());
		e.printStackTrace();
	}finally {
		return conn;
	}
	
	}

	public static Connection getConnection(String dsn,String userid, String pwd) {
	Connection conn=null;
	try {
		if(dsn.equals("mysql")) {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampleDB",userid,pwd);
		
		}
		else if	(dsn.equals("oracle")) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			conn = DriverManager.getConnection(url, userid, pwd);
		}
	} catch (Exception e) {
		// TODO: handle exception
	//		System.out.println(e.getMessage());
		e.printStackTrace();
	}finally {
		return conn;
	}
	}
	}
___
	//closehelper
    package dbConn;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.*;

	public class CloseHelper {
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {

			}
		}
	}

	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			} finally {

			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();

			} catch (Exception e) {
				// TODO: handle exception
			} finally {

			}
		}
	}
	public static void close(PreparedStatement pstmt) {
		if(pstmt!=null) {
			try {
				pstmt.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				
			}
		}
	}
	}
___
	//DML 명령처리
	package ex01;
	import dbConn.*;
	import java.io.UnsupportedEncodingException;
	import java.sql.*;
	import java.util.Scanner;

	public class CRUDtest {
	static Scanner scan = new Scanner(System.in);
	PreparedStatement pstmt = null;
	String sql = null;
	public Connection conn = null;
	ResultSet rs = null;

	public void menu() throws Exception {
		while (true) {
			System.out.println("\n##### JDBC Query ###\n");
			System.out.println("1.전체보기");
			System.out.println("2.레코드 삽입");
			System.out.println("3.레코드 수정");
			System.out.println("4.레코드 삭제");
			System.out.println("5.종료");
			String ch = scan.nextLine();

			switch (ch) {
			case "1":
				select();
				break;
			case "2":
				insert();
				break;
			case "3":
				update();
				break;
			case "4":
				delete();
				break;
			case "5":
				close();
				System.exit(0);// 프로그램 강제 종료
			default:
				break;
			}
		}
	}

	//연결
	public void connect() {
		conn = ConnectionHelper.getConnection("oracle");
	}

	public void select() {
		try {
			sql = "select * from gift";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("상품번호\t상품명\t최저가\t 최고가");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert() throws SQLException, UnsupportedEncodingException {
		System.out.print("gno = ");
		int gno = scan.nextInt();
		System.out.print("gname = ");
		String gname = scan.next();
		System.out.print("g_start = ");
		int g_start = scan.nextInt();
		System.out.print("g_end = ");
		int g_end = scan.nextInt();

		sql = "insert into gift values(?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, gno);
		// pstmt.setString(2, gname);
		pstmt.setString(2, new String(gname.getBytes("UTF-8"), "UTF-8"));
		pstmt.setInt(3, g_start);
		pstmt.setInt(4, g_end);
		int result = pstmt.executeUpdate();
		System.out.println(result + " : 데이터 추가 완료");
		select();
	}

	public void update() throws SQLException {
		System.out.println("\n수정할 목록의 번호?");
		int num = Integer.parseInt(scan.nextLine());
		System.out.println(num + "를 몇번으로 바꾸시겠습니까?");
		int gno = Integer.parseInt(scan.nextLine());
		System.out.println("상품이름");
		String name = scan.nextLine();// scan.next();
		System.out.println("최저");
		int min = Integer.parseInt(scan.nextLine());
		System.out.println("최고");
		int max = Integer.parseInt(scan.nextLine());
		sql = "update gift set gno=? ,gname=?, g_start=?, g_end=? where gno=" + num;
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, gno);
		pstmt.setString(2, name);
		pstmt.setInt(3, min);
		pstmt.setInt(4, max);

		pstmt.executeUpdate();
		System.out.println(gno + " 수정 완료");
		select();
	}

	public void delete() throws SQLException {
		System.out.println("어떤 목록 삭제? 번호 입력");
		int gno = scan.nextInt();
		sql = "delete gift where gno=" + gno;
		pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		select();
	}

	public void close() {
		CloseHelper.close(conn); //static임.
	}
	}
___
	package ex01;

	import java.io.UnsupportedEncodingException;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class MainEntry {
	public static void main(String[] args) throws Exception {
	//	Scanner sc = new Scanner(System.in);
		CRUDtest c = new CRUDtest();
		c.connect();
		c.menu();
	
	}
	}
---

###Dept2
	
    //
    package ex02;

	import java.io.UnsupportedEncodingException;
	import java.sql.*;
	import java.util.Scanner;

	import dbConn.CloseHelper;
	import dbConn.ConnectionHelper;

	public class CRUDtest {
	Connection conn=null;
	Scanner scan=new Scanner(System.in);
	String sql;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public void menu() throws Exception {
		while (true) {
			System.out.println("\n##### JDBC Query ###\n");
			System.out.println("1.전체보기");
			System.out.println("2.레코드 삽입");
			System.out.println("3.레코드 수정");
			System.out.println("4.레코드 삭제");
			System.out.println("5.종료");
			String ch = scan.nextLine();

			switch (ch) {
			case "1":
				select();
				break;
			case "2":
				insert();
				break;
			case "3":
				update();
				break;
			case "4":
				delete();
				break;
			case "5":
				close();
				System.exit(0);// 프로그램 강제 종료
			default:
				break;
			}
		}
	}
	public CRUDtest() {
		conn=ConnectionHelper.getConnection("oracle");
	}

	public void select() throws SQLException {
		sql="select * from dept2";
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		System.out.println("부서번호\t부서\t지사번호\t지사\t");
		while(rs.next()) {
			
			System.out.println(rs.getInt(1)+"\t"+ rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
		}
	}
	
	public void insert() throws SQLException, UnsupportedEncodingException {
		System.out.println("부서번호, 부서, 지사번호, 지사, 입력");
		int dcode=Integer.parseInt(scan.nextLine());
		String dname=scan.nextLine();
		int dept=Integer.parseInt(scan.nextLine());
		String area=scan.nextLine();
		sql="insert into dept2 values(?,?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, dcode);
		pstmt.setString(2, new String(dname.getBytes("UTF-8"), "UTF-8"));
		pstmt.setInt(3, dept);
		pstmt.setString(4, new String(area.getBytes("UTF-8"), "UTF-8"));
		pstmt.executeUpdate();
		System.out.println("추가 완료");
		select();
	
	}
	public void update() throws SQLException {
		//
		System.out.println("\n수정할 목록의 번호?");
		int num=Integer.parseInt(scan.nextLine());
		System.out.println(num + "를 몇번으로 바꾸시겠습니까?");
		int gno = Integer.parseInt(scan.nextLine());
		sql="update dept2 set dcode=? where dcode="+num;
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, gno);
		
		pstmt.executeUpdate();
		System.out.println(gno + " 수정 완료");
		select();

	}
	public void delete() throws SQLException{
		System.out.println("어떤 목록 삭제? 번호 입력");
		int gno = scan.nextInt();
		sql = "delete dept2 where dcode=" + gno;
		pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		select();
	}
	public void close() {
		CloseHelper.close(conn); //static임.
	}
	}
___
	package ex02;

	import java.sql.SQLException;

	public class DeptEntry {
	public static void main(String[] args) throws Exception {
	 CRUDtest crud=new CRUDtest();
	 crud.menu();
	}
	}



