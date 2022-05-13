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

public class MemberChangeDAO {
    // URL、ユーザ名、パスワードの準備
    private String url = "jdbc:postgresql:gt";
    private String user = "student";
    private String pass = "himitu";
    
  //Memberテーブル全件検索
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

    public MemberChangeDAO() throws DAOException {
        try {
            // JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録の失敗しました。");
        }
    }
    public int updateMember(MemberBean MB) throws DAOException {
    	// SQL文の作成
    	String sql = "UPDATE Member SET name= ?, address= ?, tel = ?, mail = ?"
    			+ ", birthday = ?, password = ?, status = ? WHERE cn = ?";
    	try(// データベースへの接続
   			 Connection con = DriverManager.getConnection(url, user, pass);
   			 // PreparedStatementオブジェクトの取得
   			 PreparedStatement st = con.prepareStatement(sql);){
   				// 値のセット
   				st.setString(1, MB.getName());
   				st.setString(2, MB.getAddress());
   				st.setString(3, MB.getTel());
   				st.setString(4, MB.getMail());
   				st.setDate(5, MB.getBirthday());
   				st.setString(6, MB.getPassword());
   				st.setInt(7, MB.getStatus());
   				st.setInt(8, MB.getCn());
   				// SQLの実行
//   				int rows = st.executeUpdate();
				// 結果の取得
   				 return MB.getCn();
    		}catch (SQLException e) {
    			e.printStackTrace();
    			throw new DAOException("レコードの操作に失敗しました。");
    		}
    	}
    
}