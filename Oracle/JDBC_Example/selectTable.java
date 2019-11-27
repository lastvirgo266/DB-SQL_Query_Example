import java.sql.*;

public class selectTable {
	public static void main(String[] argv)
	{
		Connection conn;
		Statement stmt;
		ResultSet rs;
		try{
			//드라이버를 로딩한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//연결을 설정한다.
			conn = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:XE", 
				"book_ex", "book_ex");
			stmt = conn.createStatement();
			
			//SQL문을 실행한다.
			rs = stmt.executeQuery("SELECT * FROM customer");
			while(rs.next())
			{
				//데이터를 받아온다.
				String no = rs.getString(1);		       //컬럼위치 지정, 숫자로도 지정할수있고
				String name = rs.getString("c_name");   //컬럼이름 지정 , 애트리뷰트 이름으로 바로 지정할수있음
				String addr = rs.getString(3);	
				String phone = rs.getString("c_phone");	
				String dist = rs.getString(5);	

				//결과를 출력한다.
				System.out.println(" NO : " + no);
				System.out.println(" NAME : " + name);
				System.out.println(" ADDRESS : " + addr);
				System.out.println(" PHONE : " + phone);
				System.out.println(" DIST : " + dist);
				System.out.println(" ================================================== ");
			}
			//Result Set를 닫는다. (SQL문)
			rs.close();
			//Statement를 닫는다. (STAMEMENT문)
			stmt.close();
			//연결을 닫는다. (커넥션)
			conn.close();
		}catch(Exception e){e.printStackTrace();}
	}
}
