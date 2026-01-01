import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class HotelSystem {
    static List<HotelData> reservationList=new ArrayList<>();
    static List<TableDescription> tableDetails=new ArrayList<>();
    public static void CreateReservation(String gName,int roomNo,String gContactNumber)throws SQLException{
        Connection con=DB.connect();
        
        String query=Query1.createNewReservation;
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1, gName);
        pst.setInt(2, roomNo);
        pst.setString(3, gContactNumber);
        pst.executeUpdate();

        System.out.println(pst+"\t New reservation created...!");
    }    

    public static List<HotelData> CheckReservation()throws SQLException{
        Connection con=DB.connect();

        String query=Query1.check;
        Statement st=con.createStatement();

        ResultSet rs=st.executeQuery(query);
        while (rs.next()) {
            int id=rs.getInt(1);
            String gName=rs.getString(2);
            int rNumber=rs.getInt(3);
            String contact=rs.getString(4);
            String date=rs.getString(5);
            HotelData data=new HotelData(id, gName, rNumber, contact, date);
            reservationList.add(data);
        }
        return reservationList;
    }

    public static List<TableDescription> describeReservationTable()throws SQLException{
        Connection con=DB.connect();

        String query=Query1.desc;
        Statement st=con.createStatement();

        ResultSet rs=st.executeQuery(query);
        
        while (rs.next()) {
            String field=rs.getString(1);
            String type=rs.getString(2);
            String _null=rs.getString(3);
            String key=rs.getString(4);
            String _default=rs.getString(5);
            String extra=rs.getString(6);
            TableDescription tb=new TableDescription(field, type, _null, key, _default, extra);
            tableDetails.add(tb);
        }
        return tableDetails;
    }

    public static void GetRoomNO(int id)throws SQLException{
        Connection con=DB.connect();

        String query=Query1.getRoom;

        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1, id);
        
        ResultSet rs=pst.executeQuery();
        while(rs.next()){

            int temp=rs.getInt(3);
            System.out.println("The room number of id:"+id+" is:"+temp);
        }
    }

    public static void updateReservation(int id,String name,int roomNo,String contactNo)throws SQLException{
        Connection con=DB.connect();

        String query=Query1.update;

        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(4, id);
        pst.setString(1, name);
        pst.setInt(2,roomNo);
        pst.setString(3, contactNo);
        pst.executeUpdate();

        System.out.println(pst+"Table Updated....!");
    }

    public static void DeleteReservation(int id)throws SQLException{
        Connection con=DB.connect();

        String query=Query1.delete;

        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1, id);
        pst.executeUpdate();

        System.out.println(pst+"One raw deleted successfuly...!");
    }

}
