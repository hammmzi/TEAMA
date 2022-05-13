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

public class MemberSearchDAO {
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
    	      
    			
    			MemberBean bean = new MemberBean(cn, name, address, tel, mail, birthday);
    			list.add(bean);
    		}
    		//会員一覧をListとして返す
    		return list;
    	} catch (SQLException e) {
    		e.printStackTrace();
    		throw new DAOException("レコードの取得に失敗しました。");
    	}
    }
    public MemberSearchDAO() throws DAOException {
	        try {
	            // JDBCドライバの登録
				Class.forName("org.postgresql.Driver");
	        } catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new DAOException("JDBCドライバの登録の失敗しました。");
	        }
	    }
    public List<MemberBean> findMember(String name ,String address 
    		,String tel ,String mail ,Date birthday) throws DAOException {
		// SQL文の作成
		String sql = "SELECT * FROM Member WHERE name LIKE ? AND address"
				+ " LIKE ? AND tel LIKE ? AND mail LIKE ?";		                                   
		try(// データベースへの接続
			 Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);){
				// 値のセット
				st.setString(1, "%" + name +"%");
				st.setString(2, "%" + address +"%");
				st.setString(3, "%" + tel +"%");
				st.setString(4, "%" + mail +"%");
				if(birthday != null ) {
				    sql += " AND birthday = ?";
				//★ない場合（"0001-01-01"じゃない日付、だったら大体全部になるため）
				}else {
					sql += " AND birthday != ?";
				}
				st.setDate(5, birthday);
				
				System.out.println(st);
				
				try (// SQLの実行
					 ResultSet rs = st.executeQuery();) {
					// 結果の取得
					List<MemberBean> list = new ArrayList<MemberBean>();
					while (rs.next()) {
						int tempCN = rs.getInt("CN");
						String tempName = rs.getString("name");
						String tempTel = rs.getString("tel");
						String tempAddress = rs.getString("address");
						String tempMail = rs.getString("mail");
						Date tempBirthday = rs.getDate("birthday");
						
						MemberBean bean = new MemberBean(tempCN, tempName, tempAddress, tempTel, tempMail, tempBirthday);
						list.add(bean);
					}
					// 取得した値をListとして返す
					return list;
				}catch (SQLException e) {
					e.printStackTrace();
					throw new DAOException("レコードの操作に失敗しました。");
				}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
    }
    
    public MemberBean logincheck(String mail, String password)throws DAOException {
		// SQL文の作成
		String sql = "SELECT * FROM Member where mail = ? AND password = ? AND status != 2";
		try(// データベースへの接続
				 Connection con = DriverManager.getConnection(url, user, pass);
				 // PreparedStatementオブジェクトの取得
				 PreparedStatement st = con.prepareStatement(sql);){
					// 値のセット
					st.setString(1, mail);
					st.setString(2, password);
					try (// SQLの実行
						 ResultSet rs = st.executeQuery();) {
						// 結果の取得
						MemberBean bean = null;
						while (rs.next()) {
							int tempCn = rs.getInt("cn");
							String tempName = rs.getString("name");
							String tempAddress = rs.getString("address");
							String tempTel = rs.getString("tel");
							String tempMail = rs.getString("mail");
							Date tempBirthday = rs.getDate("birthday");
							String tempPassword = rs.getString("password"); 
							int tempStatus = rs.getInt("status");
							bean = new MemberBean(tempCn, tempName, tempAddress, tempMail, tempTel,
									tempBirthday, tempPassword, tempStatus);
						}
						return bean;
					}catch (SQLException e) {
						e.printStackTrace();
						throw new DAOException("レコードの操作に失敗しました。");
					}
			}catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}
	    }
}