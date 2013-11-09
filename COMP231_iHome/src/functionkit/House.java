package functionkit;

public class House {

	public int Id;
	public String Address;
	public String HouseDesc;
	public String HouseType;
	public int NumOfRoom;
	public float Price;
	public String Area;
	public String OwnerName;
	public String OwnerEmail;
	public String OwnerPhone;
	
	public House(int id, String address, String houseDesc, String houseType,
			int numOfRoom, float price, String area, String ownerName,
			String ownerEmail, String ownerPhone) {
		super();
		this.Id = id;
		this.Address = address;
		this.HouseDesc = houseDesc;
		this.HouseType = houseType;
		this.NumOfRoom = numOfRoom;
		this.Price = price;
		this.Area = area;
		this.OwnerName = ownerName;
		this.OwnerEmail = ownerEmail;
		this.OwnerPhone = ownerPhone;
	}

	
	
}
