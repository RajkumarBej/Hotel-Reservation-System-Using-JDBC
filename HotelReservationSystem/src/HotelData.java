public class HotelData {
    int id;
    String name;
    int roomNO;
    String contactNo;
    String date;
    HotelData(int id,String name, int roomNO, String contactNo, String date){
        this.id=id;
        this.name=name;
        this.roomNO=roomNO;
        this.contactNo=contactNo;
        this.date=date;
    }
    int getId(){return id;}
    String getName(){return name;}
    int getRoomNO(){return roomNO;}
    String getContactNo(){return contactNo;}
    String getDate(){return date;}
    
}
