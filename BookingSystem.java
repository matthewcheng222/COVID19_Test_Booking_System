import java.util.ArrayList;

public class BookingSystem {
    private ArrayList<BookableRoom> bookableRooms = new ArrayList<>();
    private ArrayList<AssistantOnShift> assistantOnShifts = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private int bookableRoomSeqID;

    public void addBookableRooms(Room rooms, String timeSlot) {
        bookableRooms.add(new BookableRoom(rooms, timeSlot));
    }
    
    public void removeBookableRooms(int selectedID) {
        
    }

    public void listAllBookableRooms(){
        int lb = 11;
        for (int br = 0; br < bookableRooms.size(); br++) {
            String listBookableRooms = "";
            listBookableRooms = bookableRooms.get(br).getBookableRooms();
            bookableRooms.get(br).setSeqID(lb);
            System.out.println(lb + ". " + listBookableRooms);
            lb++;
        }
    }

    public void listEmptyBookableRooms() {
        int lb = 11;
        for (int br = 0; br < bookableRooms.size(); br++) {
            String toShowEmptyBookableRooms = "";
            if (bookableRooms.get(br).getStatus() == "EMPTY") {
                toShowEmptyBookableRooms = bookableRooms.get(br).getBookableRooms();
                bookableRooms.get(br).setSeqID(lb);
                System.out.println(lb + ". " + toShowEmptyBookableRooms);
                lb++;
            }
        }
    }

    public void getSpecificBookableRoom(int selectedID) {
        for (int br = 0; br < bookableRooms.size(); br++) {
            if (bookableRooms.get(br).getRooms().getSeqID() == selectedID) {
                System.out.println(bookableRooms.get(br).getBookableRooms());
            }
        }
    }

    public void addAssistantsOnShift(Assistant assistants, String date) {
        assistantOnShifts.add(new AssistantOnShift(assistants, date + " 07:00"));
        assistantOnShifts.add(new AssistantOnShift(assistants, date + " 08:00"));
        assistantOnShifts.add(new AssistantOnShift(assistants, date + " 09:00"));
    }
    
    //public void removeAssistantsOnShift

    public void listAllAssistantsOnShift() {
        int la = 11;
        String toShowAssistantsOnShift = "";
        for (int aos = 0; aos < assistantOnShifts.size(); aos++) {
            String listBookableRooms = "";
            listBookableRooms = assistantOnShifts.get(aos).getAssistantOnShift();
            assistantOnShifts.get(aos).setSeqID(la);
            System.out.println(la + ". " + listBookableRooms);
            la++;
        }
    }

    /*
    public void addBookings

    public void removeBookings

    public Booking showBookings
    */
}
