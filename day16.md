#DAY16
___

###JDBC
> 자바에서 데이터베이스에 접속할 수 있도록 하는 자바 API
> - JDBC는 데이터베이스에서 자료를 쿼리하거나 업데이트하는 방법을 제공
> - ex) oracle, mysql, mssql
>반환값 O : select - excutQuery()

>반환값 X : insert update delete - executUpdate()

###순서
>1) 드라이버 로드
 class.forName(jdbc.driver.OracleDriver);
2) 자바와 데이터베이스 연결
Connection conn=DriverManager.getConnect(url,uid,pwd)
3) SQL 명령어 사용
statement stmt=conn.createStatement();
ResutSet rs=stmt.executeQuery ("select * from gift");
=>반환 O(select 구문 사용)

4) 닫기(순차적)
rs.close
stmt.close
conn.close


라이브러리 위치: C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar
이 파일을
C:\Program Files\Java\jdk1.8.0_171\jre\lib\ext(장치관리 파일) 파일로 복사


######+참고 :http://blog.naver.com/PostView.nhn?blogId=reddezi&logNo=220943872649&categoryNo=24&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView


###gift 예제
---
	package ex03.jdbc;

	import java.util.*;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class giftSelect {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 드라이브
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "sj";
		String password = "oracle";
		Connection con = DriverManager.getConnection(url, user, password);
		// select
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM GIFT"); //필드명을 가리킴
		System.out.println("상품번호\t상품명\t최저가\t 최고가");
		while (rs.next()) {//next=> 한 줄 넘기기
			int gno = rs.getInt(1);// 인덱스 번호 or gno=re.getInt("gno");
			String name = rs.getString("gname");
			int gstart = rs.getInt("g_start");
			int gend = rs.getInt("g_end");
			System.out.println(gno + "\t" + name + "\t" + gstart + "\t" + gend);
		}
		// 반환
		rs.close();
		stmt.close();
		con.close();
	}
	}


___
	package ex03.jdbc;

	import java.sql.*;
	import java.util.Scanner;

	public class giftInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scan= new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "sj";
		String password = "oracle";
		Connection con = DriverManager.getConnection(url, user, password);
		//insert
		Statement stmt=con.createStatement();
		
	//String sql="insert into gift values("+ 12+",'"+"스팸세트"+"',"+900+" ," +9999+")"; //고정값
		
		//agruments 이용하여 입력
	//String sql="insert into gift values("+ args[0]+",'"+args[1]+"',"+args[2]+" ," +args[3]+")";//java를 통해 값 넣기

		//스캐너 이용 insert
		System.out.println("물품입력");
		String sql="insert into gift values("+ scan.nextLine()+",'"+scan.nextLine()+"',"+scan.nextLine()+" ," +scan.nextLine()+")";
		
		System.out.println(sql.toString());
		int result=stmt.executeUpdate(sql);
		System.out.println(result+"데이터 추가");
		con.close();
		}
	}

___
	package ex03.jdbc;

	import java.sql.Connection;
	import java.util.Scanner;
	import java.sql.*;

	import dbConn.CloseHelper;
	import dbConn.ConnectionHelper;

	public class giftUpdate {
	public static void main(String[] args) throws Exception{ //예외처리 위임
	Connection conn=ConnectionHelper.getConnection("oracle");
	//DML-update
	Statement stmt=conn.createStatement();//DML 명령 실행
	//고정값만 가능
	PreparedStatement pstmt=null; //DML 명령 실행
	ResultSet rs=stmt.executeQuery("select * from gift");
	
	System.out.println("상품번호\t상품명\t최저가\t 최고가");
	while (rs.next()) {//next=> 한 줄 넘기기
		int gno = rs.getInt(1);// 인덱스 번호 or gno=re.getInt("gno");
		String name = rs.getString("gname");
		int gstart = rs.getInt("g_start");
		int gend = rs.getInt("g_end");
		System.out.println(gno + "\t" + name + "\t" + gstart + "\t" + gend);
	}
	//update
	System.out.println("\n수정할 목록의 번호?");
	int num= new Scanner(System.in).nextInt();
	System.out.println(num + "를 바꾸시겠습니까? 몇번으로 ?");
	int gno=new Scanner(System.in).nextInt();
	pstmt=conn.prepareStatement("update gift set gno=? where gno="+num);
	//pstmt 가 명령문 저장.

	pstmt.setInt(1, gno); //=>setInt에서 ?로 찾아가서 
	//(물음표순서, 실제값)
	//	pstmt=conn.prepareStatement("update gift set gname=?,gno=? where gno="+num);
	//	pstmt.setInt(2, gno);
	//	pstmt.setString(1, gname); =>실제값에 직접 입력가능, 실제 값 전달 가능
	pstmt.executeUpdate();
	System.out.println(gno+" 수정 완료");
	
	CloseHelper.close(rs);
	CloseHelper.close(pstmt);
	
	}
	}


###dept2
---
	package dept2;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

	public class dept2Select {
	public static void main(String[] args) throws Exception {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String user = "sj";
	String password = "oracle";
	Connection con = DriverManager.getConnection(url, user, password);
	// select
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM DEPT2");
	System.out.println("코드\t부서이름\t지사번호\t지사위치");
	while(rs.next()) {
		String dCode=rs.getString("DCODE");
		String dName=rs.getString("dname");
		String pDept=rs.getString("pdept");
		String area=rs.getString("area");
		System.out.println(dCode + "\t" + dName + "\t" + pDept + "\t" + area);
	}
	rs.close();
	stmt.close();
	con.close();
	}
	}
___
	package dept2;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.Scanner;
	//oracle 명령어는 java에서 모두 문자열 취급
	public class dept2Insert {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "sj";
		String password = "oracle";
		//오픈
		Connection con = DriverManager.getConnection(url, user, password);
		// insert
		Statement stmt = con.createStatement();
		System.out.println("부서 번호, 이름, 지사번호, 지사위치 입력");
	//	int a=Integer.parseInt(scan.nextLine());
		String sql = "insert into gift values(" + args[0] + ",'" + args[1] + "'," + args[2] + " ," + args[3] + ")";
	//		run as-configure-agrument
	//	String sql="insert into dept2 values("+ a+","+scan.nextLine()+","+scan.nextLine()+"," +scan.nextLine()+")";

		System.out.println(sql.toString());
		int result = stmt.executeUpdate(sql);
		System.out.println(result + " 데이터 추가");
		con.close();
	}
	}

