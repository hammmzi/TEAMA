package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MemberBean;

public class MemberLeaveDAO {
    // URL、ユーザ名、パスワードの準備
    private String url = "jdbc:postgresql:gt";
    private String user = "student";
    private String pass = "himitu";

    public MemberLeaveDAO() throws DAOException {
        try {
            // JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録の失敗しました。");
        }
    }
///Memberテーブル全件検索
    public List<MemberBean> find() throws DAOException {
//    	SQL文の作成
    	String sql = "SELECT * FROM Member";	
    		
    	try (//データベースへの登録
    		Connection con = DriverManager.getConnection(url, user, pass);
    		//PreparedStatementオブジェクトの取得
    		PreparedStatement st = con.prepareStatement(sql);
    		//SQLの実行
    		ResultSet rs = st.executeQuery();){
    		//結果の取得
    		List<MemberBean> list = new ArrayList<MemberBean>();
    		while (rs.next()) {
    			int cn = rs.getInt("cn");
    			String name = rs.getString("name");
    			String address = rs.getString("address");
    			String tel = rs.getString("tel");
    			String mail = rs.getString("mail");
    			Date birthday = rs.getDate("birthday");
    			String password = rs.getString("password");
    			int status = rs.getInt("status");
    			
    			MemberBean bean = new MemberBean(cn, name, address, tel, mail, birthday, password, status);
    			list.add(bean);
    		}
    		//会員一覧をListとして返す
    		return list;
    	} catch (SQLException e) {
    		e.printStackTrace();
    		throw new DAOException("レコードの取得に失敗しました。");
    	}
    }
    
    	
    	public int updateMemberStatus(int cn ,int status) throws DAOException {
    		// SQL文の作成
//    		String sql = "UPDATE status SET cn = ? WHERE status = ?";
    		String sql = "UPDATE member SET status = 2 WHERE cn = ?";
    		
    		try (// データベースへの接続
    			 Connection con = DriverManager.getConnection(url, user, pass);
    			 // PreparedStatementオブジェクトの取得
    			 PreparedStatement st = con.prepareStatement(sql);) {
    			// プレースホルダーの設定
    			st.setInt(1, cn);
    			st.setInt(2, status);
    			// SQLの実行
    			int rows = st.executeUpdate();
    			return rows;
    		} catch (SQLException e) {
    			e.printStackTrace();
    			throw new DAOException("レコードの操作に失敗しました。");
    		}
    	}
    }