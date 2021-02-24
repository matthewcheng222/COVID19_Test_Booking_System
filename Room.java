public class Room {
    // private instance variables
    private String code;
    private int capacity;
    private int seqID;

    /**
     * constructor for initialising rooms
     * 
     * @param code the code of room to be initialised
     * @param capacity the capacity of room to be initialised 
     */
    public Room(String code, int capacity) {
        // checking if the the passed parameter capacity is larger than 0
        if (capacity > 0) {
            this.code = code;
            this.capacity = capacity;
        }
    }

    // public getters and setters for private instances

    /**
     * @param seqID the sequential ID of rooms to be set
     */
    public void setSeqID(int seqID) {
        this.seqID = seqID;
    }

    /**
     * @return the sequential ID of the room
     */
    public int getSeqID() {
        return seqID;
    }

    /**
     * @return the code of the room
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the capacity of the room
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return the print template of the room
     */
    public String getRooms() {
        return "| " + code + " | capacity: " + capacity + " |";
    }
}
