package com.dxc.model;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="newspaper")
public class Newspaper {
	@Id
	@Column(name="floorno")
	private int floorno;
	@Column(name="shelfno")
	private String shelfno;
	@Column(name="name")
	private String name;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name ="date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
	Date date;
	public Newspaper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Newspaper(int floorno, String shelfno, String name, String strDate) throws ParseException {
		super();
		this.floorno = floorno;
		this.shelfno = shelfno;
		this.name = name;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		date = sdf.parse(strDate);
		
	}
	public int getFloorno() {
		return floorno;
	}
	public void setFloorno(int floorno) {
		this.floorno = floorno;
	}
	public String getShelfno() {
		return shelfno;
	}
	public void setShelfno(String shelfno) {
		this.shelfno = shelfno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		
		String strDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
		return "Newspaper [floorno=" + floorno + ", shelfno=" + shelfno + ", name=" + name + ", date=" + strDate + "]";
	}
	
}
