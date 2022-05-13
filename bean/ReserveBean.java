package bean;

import java.io.Serializable;
import java.sql.Date;

public class ReserveBean implements Serializable {
	//フィールド
	private int hotel_id;
	private int member_cn;
	private Date check_in;
	private Date check_out;
	private int plan_id;
	private int room;
	
	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public int getMember_cn() {
		return member_cn;
	}

	public void setMember_cn(int member_cn) {
		this.member_cn = member_cn;
	}

	public Date getCheck_in() {
		return check_in;
	}

	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
	}

	public Date getCheck_out() {
		return check_out;
	}

	public void setCheck_out(Date check_out) {
		this.check_out = check_out;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	//コンストラクタ
	public ReserveBean(int hotel_id,int member_cn,Date check_in,Date check_out,int plan_id,int room) {
		this.hotel_id = hotel_id;
		this.member_cn = member_cn;
		this.check_in = check_in;
		this.check_out = check_out;
		this.plan_id = plan_id;
		this.room = room;
	}
	
	//コンストラクタ(複数)
	
	public ReserveBean(int member_cn) {
		this.member_cn = member_cn;
	}
	
	public ReserveBean() {
	
	}
}