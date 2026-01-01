public class Query1 {
    static String createNewReservation="INSERT INTO hreservation(guest_name,room_no,contact_no) VALUES(?,?,?);";
    static String check="SELECT * FROM hreservation;";
    static String getRoom="SELECT * FROM hreservation WHERE reservation_id=?;";
    static String update="UPDATE hreservation SET guest_name=?,room_no=?,contact_no=? WHERE reservation_id=?";
    static String delete="DELETE FROM hreservation WHERE reservation_id=?";
    static String desc="DESC hreservation;";
}
