package jspservlet.vo;

public class Product {
	private int price;
	private int number;
	private String name;
	private String picture;
	private int id;
	private int buynum;
	private String details;
	private double totalprice;
public Product()
{
	
}

public Product(int id,String name,int price,int number,String picture,int buynum)
{
	this.id = id;
	this.name = name;
	this.picture = picture;
	this.price = price;
	this.number = number;
	this.buynum = buynum;
	
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getNumber() {
	return number;
}

public void setNumber(int number) {
	this.number = number;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPicture() {
	return picture;
}

public void setPicture(String picture) {
	this.picture = picture;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


public int getBuynum() {
	return buynum;
}

public void setBuynum(int buynum) {
	this.buynum = buynum;
}

public String getDetails() {
	return details;
}

public void setDetails(String details) {
	this.details = details;
}


public double getTotalprice() {
	return totalprice;
}

public void setTotalprice(double totalprice) {
	this.totalprice = totalprice;
}

public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	if(this==obj)
	{
		return true;
	}
	if(obj instanceof Product)
	{
		Product i = (Product)obj;
		if(this.getId()==i.getId()&&this.getName().equals(i.getName()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	else
	{
		return false;
	}
}

public String toString()
{
	return "The product id "+this.getId()+",The product's name "+this.getName();
}

}