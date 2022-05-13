package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import bean.HotelBean;

public class HotelEntryDAO {
	// URL、ユーザ名、パスワードの準備
	private String url = "jdbc:postgresql:sample";
	private String user = "student";
	private String pass = "himitu";

	public HotelEntryDAO() throws DAOException {
		// JDBCドライバの登録
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録の失敗しました。");
		}

	}

	// hotel追加
		public int addHotel(HotelBean HB) throws DAOException {
//	public int addHotel(int id, String name, String region, String address, String tel, 
//			String plan1, String plan2, int price1, int price2, Time in1, Time out1,Time in2, Time out2, int room1, int room2) throws DAOException {
		
		
		String sql = "INSERT INTO hotel(id,name, region, address, tel,"
				+ " plan1, plan2, in1, out1, in2,out2, price1, price2, room1,room2) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try(//データベースに接続
				Connection con = DriverManager.getConnection(url, user, pass);
				//PreparedStatementオブジェクトを取得
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, HB.getId());
			st.setString(2,HB.getName());
			st.setString(3, HB.getRegion());
			st.setString(4, HB.getAddress());
			st.setString(5, HB.getTel());
			st.setString(6, HB.getPlan1());
			st.setString(7, HB.getPlan2());
			st.setTime(8, HB.getIn1());
			st.setTime(9, HB.getOut1());
			st.setTime(10, HB.getIn2());
			st.setTime(11, HB.getOut2());
			st.setInt(12, HB.getPrice1());
			st.setInt(13, HB.getPrice2());
			st.setInt(14, HB.getRoom1());
			st.setInt(15, HB.getRoom2());
			
			//SQL文実行
			int rows = st.executeUpdate();
			return rows;

			}
			 catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコード操作に失敗しました。");
		}

	}


}