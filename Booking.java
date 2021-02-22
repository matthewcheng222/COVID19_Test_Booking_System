import java.util.ArrayList;

public class Booking {
    private ArrayList<BookableRoom> bookableRooms;
    private ArrayList<AssistantOnShift> assistantOnShift;

    public String getBooking() {
        return "| " + "<dd/mm/yyyy HH:MM>" + " | " + bookableRooms.getStatus() + " | " + AssistantOnShift.getAssistants.getUniversityEmail() + " | " + bookableRooms.getRoom().getCode() + " | " + "<student_email>" + " |";
    }
}
