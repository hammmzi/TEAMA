package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import bean.MemberBean;

public class MemberEntryDAO {
	// URL、ユーザ名、パスワードの準備
	private String url = "jdbc:postgresql:sample";
	private String user = "student";
	private String pass = "himitu";

	public MemberEntryDAO() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録の失敗しました。");
		}
	}

	public int addMember(MemberBean MB)
			throws DAOException {

		int status = 1;
//		int cn = 0;
//		String sql = "SELECT nextval ('cn_code_seq')";
//
//		try (// データベースに接続
//				Connection con = DriverManager.getConnection(url, user, pass);
//				// PreparedStatementオブジェクトを取得
//				PreparedStatement st = con.prepareStatement(sql);
//				// SQL実行
//				ResultSet rs = st.executeQuery();) {
//			if (rs.next()) {
//				cn = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new DAOException("レコード操作に失敗しました");
//		}

		String sql = "INSERT INTO member(name, address, tel,mail,birthday,password,status)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (// データベースに接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトを取得
				PreparedStatement st = con.prepareStatement(sql);
		) {
			st.setString(1, MB.getName());
			st.setString(2, MB.getAddress());
			st.setString(3, MB.getTel());
			st.setString(4, MB.getMail());
			st.setDate(5, MB.getBirthday());
			st.setString(6, MB.getPassword());
			st.setInt(7, status);

			// SQL文実行
			int rows = st.executeUpdate();
			return rows;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコード操作に失敗しました。");
		}

	}

}
