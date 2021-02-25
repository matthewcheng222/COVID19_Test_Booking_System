/**
 * represents a bookable room
 * 
 * @author Matthew Cheng 
 * @author https://github.com/matthewcheng222
 */

public class BookableRoom {
    // private instance variables
    private Room rooms;
    private String timeSlot;
    private String status;
    private int occupancy = 0;;
    private int seqID;

    /**
     * constructor for initialising bookable rooms
     * 
     * @param rooms the room to be initialised
     * @param timeSlot the time slot to be initialised
     */
    public BookableRoom(Room rooms, String timeSlot) {
        this.rooms = rooms;
        this.timeSlot = timeSlot;
        // setting the status of the bookable room to be EMPTY when created
        this.status = "EMPTY";
    }

    // public setters and getters for private instances 

    /**
     * adding the occupancy of a bookable room by 1
     * setting the status of a bookable room with a given occupancy
     * 
     * @param occupancy the occupancy of the bookable room
     */
    public void incrementOccupancy() {
        // setting status to EMPTY if occupancy is 0
        occupancy++;
        if (occupancy == 0) {
            status = "EMPTY";
        }
        // setting status to AVAILABLE if occupancy is less than the room capacity
        else if (occupancy < rooms.getCapacity() && occupancy > 0) {
            status = "AVAILABLE";
        }
        // setting status to FULL if occupancy is equal to the room capacity
        else if (occupancy == rooms.getCapacity() && occupancy > 0) {
            status = "FULL";
        }
    }

    /**
     * decreasing the occupancy of a bookable room by 1
     * setting the status of a bookable room with a given occupancy
     * 
     * @param occupancy the occupancy of the bookable room
     */
    public void decreaseOccupancy() {
        // setting status to EMPTY if occupancy is 0
        occupancy--;
        if (occupancy == 0) {
            status = "EMPTY";
        }
        // setting status to AVAILABLE if occupancy is less than the room capacity
        else if (occupancy < rooms.getCapacity() && occupancy > 0) {
            status = "AVAILABLE";
        }
        // setting status to FULL if occupancy is equal to the room capacity
        else if (occupancy == rooms.getCapacity() && occupancy > 0) {
            status = "FULL";
        }
    }

    /**
     * @param seqID the sequential ID of a bookable room
     */
    public void setSeqID(int seqID) {
        this.seqID = seqID;
    }

    /**
     * @return the status of a bookable room
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the room of a bookable room
     */
    public Room getRooms() {
        return rooms;
    }

    /**
     * @return the sequential ID of a bookable room
     */
    public int getSeqID() {
        return seqID;
    }

    /**
     * @return the time slot of a bookable room
     */
    public String getTimeSlot() {
        return timeSlot;
    }

    /**
     * @return the print template of a bookable room
     */
    public String getBookableRooms() {
        return "| " + timeSlot + " | " + status + " | " + rooms.getCode() + " | occupancy: " + occupancy + " |";
    }
}
