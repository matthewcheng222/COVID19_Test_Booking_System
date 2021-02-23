public class BookableRoom {
    private Room rooms;
    private String timeSlot;
    private String status;
    private int occupancy;
    private int seqID;

    public BookableRoom(Room rooms, String timeSlot) {
        this.rooms = rooms;
        this.timeSlot = timeSlot;
        this.status = "EMPTY";
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
        if (occupancy == 0) {
            status = "EMPTY";
        }
        else if (occupancy < rooms.getCapacity() && occupancy > 0) {
            status = "AVAILABLE";
        }
        else if (occupancy == rooms.getCapacity() && occupancy > 0) {
            status = "FULL";
        }
    }

    public void setSeqID(int seqID) {
        this.seqID = seqID;
    }

    public String getStatus() {
        return status;
    }

    public Room getRooms() {
        return rooms;
    }

    public int getSeqID() {
        return seqID;
    }

    public String getBookableRooms() {
        return "| " + timeSlot + " | " + status + " | " + rooms.getCode() + " | occupancy: " + occupancy + " |";
    }
}
