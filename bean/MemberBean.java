package bean;

import java.io.Serializable;
import java.sql.Date;

public class MemberBean implements Serializable {
	//フィールド
	private int cn;
	private String name;
	private String address;
	private String tel;
	private String mail;
	private Date birthday;
	private String password;
	private int status;
	/**
	 * @return cn
	 */
	public int getCn() {
		return cn;
	}
	/**
	 * @param cn セットする cn
	 */
	public void setCn(int cn) {
		this.cn = cn;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel セットする tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail セットする mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday セットする birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status セットする status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	//コンストラクタ
	public MemberBean(int cn ,String name ,String address ,String tel ,String mail ,Date birthday ,String password ,int status) {
		this.cn = cn;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
		this.birthday = birthday;
		this.password = password;
		this.status = status;
	}
	//コンストラクタ(オバロ)
	public MemberBean(int cn ,String name ,String address ,String tel ,String mail ,Date birthday) {
		this.cn = cn;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
		this.birthday = birthday;
	}
	public MemberBean(String name ,String address ,String tel ,String mail ,Date birthday) {
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
		this.birthday = birthday;
	}
	
	public MemberBean(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}
	
	public MemberBean(int cn ,int status) {
		this.cn = cn;
		this.status = status;
	}
	
	public MemberBean(int cn) {
		this.cn = cn;
	}
	
	public MemberBean() {
		
	}
}