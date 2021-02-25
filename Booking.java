/**
 * represents a booking
 * 
 * @author Matthew Cheng 
 * @author https://github.com/matthewcheng222
 */

public class Booking {
    // private instance variables
    private BookableRoom bookableRooms;
    private AssistantOnShift assistantOnShifts;
    private String status;
    private String studentEmail;
    private String timeSlot;
    private int seqID;

    /**
     * constructor for initialising bookings 
     * 
     * @param timeSlot the timeslot of booking to be added
     * @param studentEmail the student email of booking to be added
     * @param bookableRooms the bookable room of booking to be added
     * @param assistantOnShifts the assistant on shift of booking to be added
     */
    public Booking(String timeSlot, String studentEmail, BookableRoom bookableRooms, AssistantOnShift assistantOnShifts) {
        this.timeSlot = timeSlot;
        this.studentEmail = studentEmail;
        this.bookableRooms = bookableRooms;
        this.assistantOnShifts = assistantOnShifts;
        // setting the status of a booking to be SCHEDULED when created
        this.status = "SCHEDULED";
    }

    // public getters and setters for private instances

    /**
     * setting the status of a booking to SCHEDULED
     */
    public void setStatusScheduled() {
        this.status = "SCHEDULED";
    }

    /**
     * setting the status of a booking to COMPLETED
     */
    public void setStatusCompleted() {
        this.status = "COMPLETED";
    }

    /**
     * @return the status of a booking 
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param seqID the sequential ID of a booking to be set
     */
    public void setSeqID(int seqID) {
        this.seqID = seqID;
    }

    /**
     * @return the sequential ID of a booking
     */
    public int getSeqID() {
        return seqID;
    }

    /**
     * @return the bookable room of a booking
     */
    public BookableRoom getBookableRooms() {
        return bookableRooms;
    }

    /**
     * @return the assistant on shift of a booking
     */
    public AssistantOnShift getAssistantOnShifts() {
        return assistantOnShifts;
    }

    /**
     * @return the print template of a booking
     */
    public String getBookings() {
        return "| " + timeSlot + " | " + status + " | " + assistantOnShifts.getAssistants().getUniversityEmail() + " | " + bookableRooms.getRooms().getCode() + " | " + studentEmail + " |";
    }
}
