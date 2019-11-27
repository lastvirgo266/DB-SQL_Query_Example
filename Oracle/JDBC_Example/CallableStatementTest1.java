import java.sql.*;

public class CallableStatementTest1 {
	public static void main(String[] argv)
	{
		Connection conn;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:XE", 
					"book_ex", "book_ex");
		
		CallableStatement cs; //객체 변수 선언
		
		//INPUT_PHONW_NUMBER 라는 프로시저를 선언함
		cs = conn.prepareCall("{call INPUT_PHONE_NUMBER (?, ?)}");

		cs.setString(1, "이기태");
		cs.setString(2, "111-1111");
		cs.executeUpdate();

		cs.setString(1, "장대망");
		cs.setString(2, "222-2222");
		cs.executeUpdate();

		cs.close();
		conn.close();
	}catch(Exception e)
         {e.printStackTrace();}
  }
}
