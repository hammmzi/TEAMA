package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import bean.HotelBean;




public class HotelDeleteDAO {
    // URL、ユーザ名、パスワードの準備
    private String url = "jdbc:postgresql:gt";
    private String user = "student";
    private String pass = "himitu";

    public HotelDeleteDAO() throws DAOException {
        try {
            // JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録の失敗しました。");
        }
    }
    
    //Hotelテーブル全件検索
    public List<HotelBean> find() throws DAOException {
//    	SQL文の作成
    	String sql = "SELECT * FROM Hotel";	
    		
    	try (//データベースへの登録
    		Connection con = DriverManager.getConnection(url, user, pass);
    		//PreparedStatementオブジェクトの取得
    		PreparedStatement st = con.prepareStatement(sql);
    		//SQLの実行
    		ResultSet rs = st.executeQuery();){
    		//結果の取得
    		List<HotelBean> list = new ArrayList<HotelBean>();
    		while (rs.next()) {
    			int id = rs.getInt("id");
    			String region = rs.getString("region");
    			String name = rs.getString("name");
    			String address = rs.getString("address");
    			String tel = rs.getString("tel");
    			String plan1 = rs.getString("plan1");
    			String plan2 = rs.getString("plan2");
    			int price1 = rs.getInt("price1");
    			int price2 = rs.getInt("price2");
    			Time in1 = rs.getTime("in1");
    			Time out1 = rs.getTime("out1");
    			Time in2 = rs.getTime("in2");
    			Time out2 = rs.getTime("out2");
    			int room1 = rs.getInt("room1");
    			int room2 = rs.getInt("room2");
    			
    			HotelBean bean = new HotelBean(id, region, name, address, tel, plan1, plan2, 
    											price1, price2, in1, out1, in2, out2, room1, room2);
    			list.add(bean);
    		}
    		//商品一覧をListとして返す
    		return list;
    	} catch (SQLException e) {
    		e.printStackTrace();
    		throw new DAOException("レコードの取得に失敗しました。");
    	}
    }
    
    
    //宿情報を削除する
    public int deleteHotel(int id) throws DAOException {
    	//SQL文の作成
        String sql = "DELETE FROM Hotel WHERE id = ?";

        try (// データベースへの接続
            Connection con = DriverManager.getConnection(url, user, pass);
			// PreparedStatementオブジェクトの取得
			PreparedStatement st = con.prepareStatement(sql);){
        	//プレースホルダの設定
        	st.setInt(1, id);
        	// SQLの実行
			int rows = st.executeUpdate();
			return rows;
        } catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
        }
        
        
    }
}