import java.util.ArrayList;

public class BookingSystem {
    private ArrayList<BookableRoom> bookableRooms = new ArrayList<>();
    private ArrayList<AssistantOnShift> assistantOnShifts = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

    public void addBookableRooms(Room rooms, String timeSlot, int occupancy) {
        bookableRooms.add(new BookableRoom(rooms, timeSlot, occupancy));
    }

    
    //public void removeBookableRooms

    public String showBookableRooms(){
        int lb = 11;
        String toShowBookableRooms = "";
        for (int br = 0; br < bookableRooms.size(); br++) {
            String listBookableRooms = "";
            listBookableRooms = bookableRooms.get(br).getBookableRooms();
            toShowBookableRooms += lb + ". " + listBookableRooms + "\n";
            lb++;
        }
        return toShowBookableRooms;
    }

    /*
    public void addAssistantsOnShift
    
    public void removeAssistantsOnShift

    public AssistantOnShift showaddAssistantsOnShift

    public void addBookings

    public void removeBookings

    public Booking showBookings
    */
}
