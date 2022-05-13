package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.ReserveBean;

public class ReserveDAO {
	// URL、ユーザ名、パスワードの準備
	private String url = "jdbc:postgresql:gt";
	private String user = "student";
	private String pass = "himitu";

	public ReserveDAO() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録の失敗しました。");
		}
	}
	
	//予約情報をDBに追加
	public int addReserve(ReserveBean RB) throws DAOException {
		// 予約番号の取得 Serial型の暗黙シーケンスから取得
		int id = 0;
		String sql = "SELECT nextval('Reserve_id_seq')";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);
				// SQLの実行
				ResultSet rs = st.executeQuery();) {
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}

		// 予約情報を追加するSQL文
		sql = "INSERT INTO Reserve(id, hotel_id, member_CN, check_in check_out, plan_id, room) VALUES(?, ?, ?, ?, ?, ?, ?)";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// 商品名と値段の設定
			st.setInt(1, id);
			st.setInt(2, RB.getHotel_id());
			st.setInt(3, RB.getMember_cn());
			st.setDate(4, RB.getCheck_in());
			st.setDate(5, RB.getCheck_out());
			st.setInt(6, RB.getPlan_id());
			st.setInt(7, RB.getRoom());
			// SQLの実行
			st.executeUpdate();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}
	
	//予約件数のチェック
	public boolean checkReserve(int member_CN) throws DAOException {
		// SQL文の作成
		String sql = "SELECT COUNT(*) FROM Reserve WHERE member_CN = ?";

		try (// データベースへの接続
			Connection con = DriverManager.getConnection(url, user, pass);
			// PreparedStatementオブジェクトの取得
			PreparedStatement st = con.prepareStatement(sql);){
			//CNの設定
			st.setInt(1, member_CN);
			
			try (// SQLの実行
				ResultSet rs = st.executeQuery();) {
				int count = 0;
				if (rs.next()) {
					count = rs.getInt(1);
				}
				if (count >= 5) {
					return false;
				} else {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの操作に失敗しました。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}
}
