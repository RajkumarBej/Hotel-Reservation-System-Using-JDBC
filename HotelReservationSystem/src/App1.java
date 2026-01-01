import java.util.List;
import java.util.Scanner;
public class App1 {
    public static void main(String[] args) throws Exception {
        int id;
        String name;
        int roomNo;
        String cNo;
        System.out.println("*******************Welcome to Hotel Reservation System********************");
        try (Scanner sc = new Scanner(System.in)) {
            while(true){
                System.out.println("_______________________________________________________________________________________________________________________");
                System.out.println("Coose from the following option:-\n1.New Reservation.\n2.Check Reservations.\n3.Get Room number.\n4.Update Reservation.\n5.Delete Reservation.\n6.Describe Table.\n7.Exit");
                int option=sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Enter Guest name, room number & contact number:");
                        name=sc.next();
                        roomNo=sc.nextInt();
                        cNo=sc.next();
                        HotelSystem.CreateReservation(name,roomNo,cNo);
                        break;
                    case 2:
                        List<HotelData> data=HotelSystem.CheckReservation();
                        for(HotelData it:data)
                        {
                            System.out.println("id: "+it.getId()+"\t name: "+it.getName()+"\t room number: "+it.getRoomNO()+"\t mobile number: "+it.getContactNo()+"\t date: "+it.getDate());
                        }
                        data.clear();
                    break;
                    case 3:
                        System.out.println("Enter id of guest:");
                        id=sc.nextInt();
                        HotelSystem.GetRoomNO(id);
                    break;
                    case 4:
                        System.out.println("Enter Guest id, name, room number & contact number:");
                        id=sc.nextInt();
                        name=sc.next();
                        roomNo=sc.nextInt();
                        cNo=sc.next();
                        HotelSystem.updateReservation(id,name,roomNo,cNo);
                    break;
                    case 5:
                        System.out.println("Enter id of guest:");
                        id=sc.nextInt();
                        HotelSystem.DeleteReservation(id);
                    break;
                    case 6:
                        List<TableDescription> tableDetail=HotelSystem.describeReservationTable();
                        for(TableDescription td:tableDetail)
                        {
                            System.out.println("Field: "+td.getField()+"\t Type: "+td.getType()+"\t Null: "+td.get_null()+"\t Key: "+td.getKey()+"\t Default: "+td.get_default()+"\t Extra: "+td.getExtra());
                        }
                        tableDetail.clear();
                    break;
                    case 7:
                        ExitMethod.exit();
                        System.out.println("Thank you for useing hotel reservation system....!");
                        return;

                    default:
                        System.out.println("Invalid choice ");
                        break;
                }
            }
        }
    }
}
