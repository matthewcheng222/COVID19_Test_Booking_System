public class Booking {
    private BookableRoom bookableRooms;
    private AssistantOnShift assistantOnShifts;
    private String status;
    private String studentEmail;
    private String timeSlot;
    private int seqID;

    public Booking(String timeSlot, String studentEmail, BookableRoom bookableRooms, AssistantOnShift assistantOnShifts) {
        this.timeSlot = timeSlot;
        this.studentEmail = studentEmail;
        this.bookableRooms = bookableRooms;
        this.assistantOnShifts = assistantOnShifts;
        this.status = "SCHEDULED";
    }

    public void setStatusScheduled() {
        this.status = "SCHEDULED";
    }

    public void setStatusCompleted() {
        this.status = "COMPLETED";
    }

    public String getStatus() {
        return status;
    }

    public void setSeqID(int seqID) {
        this.seqID = seqID;
    }

    public int getSeqID() {
        return seqID;
    }

    public BookableRoom getBookableRooms() {
        return bookableRooms;
    }

    public AssistantOnShift getAssistantOnShifts() {
        return assistantOnShifts;
    }

    public String getBookings() {
        return "| " + timeSlot + " | " + status + " | " + assistantOnShifts.getAssistants().getUniversityEmail() + " | " + bookableRooms.getRooms().getCode() + " | " + studentEmail + " |";
    }
}
