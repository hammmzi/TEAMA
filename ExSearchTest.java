import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//★複数のAND検索のサンプル（未入力の有無を工夫して処理する）

class ExSearchTest {
	public static void main(String[] args) {
    	
//★フォームやBeanから取得するデータのイメージ↓★
//★文字はLikeを使えば空文字でよいが、数値と日付は工夫が必要★
//★今回は日付がempにないためDate型は参考として記載
    	//-------------------------
    	
    	int id = 3;					//なければ0にしておく
    	String name = "田";			//なければ"" 空文字
    	String tel = "05-3333-3333";//なければ"" 空文字
//    	Date birth = Date.valueOf("1990-01-01");//なければ"0001-01-01"にしておく
    	
    	//-------------------------
    	
    	// URL、ユーザ名、パスワードの準備
        String url = "jdbc:postgresql:sample";
        String user = "student";
        String pass = "himitu";
        
//★SQLの生成★
        
        //★文字列をLikeで曖昧検索する場合は先にそのまま書いておく
        String sql = "SELECT * FROM emp WHERE name like ? AND tel like ?";
        
        //★idがある場合
        if(id > 0) {
        	sql += " AND code = ?";
        //★ない場合（0以上のdept_idだったら全部になるため）
        }else {
        	sql += " AND code >= ?";
        }
        
//        //★birthがある場合
//        if(birth != null ) {
//        	sql += " AND birthday = ?";
//        //★ない場合（"0001-01-01"じゃない日付、だったら大体全部になるため）
//        }else {
//        	sql += " AND birthday != ?";
//        }

        
        try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
		try (// データベースへの接続
				 Connection con = DriverManager.getConnection(url, user, pass);
				 // PreparedStatementオブジェクトの取得
				 PreparedStatement st = con.prepareStatement(sql);){

//★パラメータの設定
        		st.setString(1,"%"+name+"%");
        		st.setString(2,"%"+tel+"%");
        		st.setInt(3,id);
//        		st.setDate(4,birth);
        		
                System.out.println(st);
        		
        		try (// SQLの実行
       			     ResultSet rs = st.executeQuery();) {
       			    // 結果の取得および表示
       			    while (rs.next()) {
       			    	System.out.print(rs.getInt("code") + " : ");
       			    	System.out.print(rs.getString("name") + " : ");
       			    	System.out.print(rs.getInt("age") + " : ");
       			    	System.out.println(rs.getString("tel"));
       			    }
       			 } catch (SQLException e) {
       					e.printStackTrace();
       			 }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}