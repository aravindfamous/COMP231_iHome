package functionkit;


public class HomeData {
    
    @com.google.gson.annotations.SerializedName("id")
    public Integer mId;
    @com.google.gson.annotations.SerializedName("address")    
    public String mAddress;
    @com.google.gson.annotations.SerializedName("housedesc")    
    public String mHouseDesc;
    @com.google.gson.annotations.SerializedName("housetype") 
    public String mHouseType;
    @com.google.gson.annotations.SerializedName("numofroom")   
    public Integer mNumOfRoom;
    @com.google.gson.annotations.SerializedName("price")  
    public float mPrice;
    @com.google.gson.annotations.SerializedName("area")  
    public String mArea;
    @com.google.gson.annotations.SerializedName("ownername")    
    public String mOwnerName;
    @com.google.gson.annotations.SerializedName("owneremail")    
    public String mOwnerEmail;
    @com.google.gson.annotations.SerializedName("ownerphone")    
    public Integer mOwnerPhone;
     
    public Integer getId() { return mId; }
    public final void setId(Integer id) { mId = id; }
    
    public String getAddress() { return mAddress; }
    public final void setAddress(String address) { mAddress = address; }
    
    public String getHouseDesc() { return mHouseDesc; }
    public final void setHouseDesc(String housedesc) { mHouseDesc = housedesc; }
    
    public String getHouseType() { return mHouseType; }
    public final void setHouseType(String housetype) { mHouseType = housetype; }
    
    public Integer getNumOfRoom() { return mNumOfRoom; }
    public final void setNumOfRoom(Integer numofroom) { mNumOfRoom = numofroom; }
    
    public Float getPrice() { return mPrice; }
    public final void setPrice(Float price) { mPrice = price; }
    
    public String getArea() { return mArea; }
    public final void setArea(String area) { mArea = area; }
    
    public String getOwnerName() { return mOwnerName; }
    public final void setOwnerName(String ownername) { mOwnerName = ownername; }
    
    public String getOwnerEmail() { return mOwnerEmail; }
    public final void setOwnerEmail(String owneremail) { mOwnerEmail = owneremail; }
    
    public Integer getOwnerPhone() { return mOwnerPhone; }
    public final void setOwnerPhone(Integer ownerphone) { mOwnerPhone = ownerphone; }
    
   
 
}
