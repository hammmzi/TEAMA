package bean;

import java.io.Serializable;
import java.sql.Time;

public class HotelBean implements Serializable {
	//フィールド
	private int id;
	private String name;
	private String region;
	private String address;
	private String tel;
	private String plan1;
	private String plan2;
	private int price1;
	private int price2;
	private Time in1;
	private Time out1;
	private Time in2;
	private Time out2;
	private int room1;
	private int room2;

	//ゲッターとセッター

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPlan1() {
		return plan1;
	}
	public void setPlan1(String plan1) {
		this.plan1 = plan1;
	}
	public String getPlan2() {
		return plan2;
	}
	public void setPlan2(String plan2) {
		this.plan2 = plan2;
	}
	public int getPrice1() {
		return price1;
	}
	public void setPrice1(int price1) {
		this.price1 = price1;
	}
	public int getPrice2() {
		return price2;
	}
	public void setPrice2(int price2) {
		this.price2 = price2;
	}
	public Time getIn1() {
		return in1;
	}
	public void setIn1(Time in1) {
		this.in1 = in1;
	}
	public Time getOut1() {
		return out1;
	}
	public void setOut1(Time out1) {
		this.out1 = out1;
	}
	public Time getIn2() {
		return in2;
	}
	public void setIn2(Time in2) {
		this.in2 = in2;
	}
	public Time getOut2() {
		return out2;
	}
	public void setOut2(Time out2) {
		this.out2 = out2;
	}
	public int getRoom1() {
		return room1;
	}
	public void setRoom1(int room1) {
		this.room1 = room1;
	}
	public int getRoom2() {
		return room2;
	}
	public void setRoom2(int room2) {
		this.room2 = room2;
	}
	//コンストラクタ
	public HotelBean(int id, String name, String region, String address,String tel,String plan1,
			String plan2,int price1,int price2,Time in1,Time out1, Time in2,Time out2,
			int room1,int room2) {
		this.id = id;
		this.name = name;
		this.region = region;
		this.address = address;
		this.tel = tel;
		this.plan1 = plan1;
		this.plan2 = plan2;
		this.price1 = price1;
		this.price2 = price2;
		this.in1 = in1;
		this.out1 = out1;
		this.in2 = in2;
		this.out2 = out2;
		this.room1 = room1;
		this.room2 = room2;
	}
	//コンストラクタ(オバロ)
	public HotelBean(String region, String address, int price1, int price2,
			Time in1,Time out1, Time in2,Time out2,int room1,int room2) {
		this.region = region;
		this.address = address;
		this.price1 = price1;
		this.price2 = price2;
		this.in1 = in1;
		this.out1 = out1;
		this.in2 = in2;
		this.out2 = out2;
		this.room1 = room1;
		this.room2 = room2;
	}
	
	public HotelBean(int id,String name, String region, String address) {
		this.region = region;
		this.name = name;
		this.id = id;
		this.address = address;
	}
	
	public HotelBean(String region, String address) {
		this.region = region;
		this.address = address;
	}
	public HotelBean(String region, String name, int room1, int room2) {
		this.region = region;
		this.name = name;
		this.room1 = room1;
		this.room2 = room2;
	}
	
	public HotelBean() {
		
	}
}