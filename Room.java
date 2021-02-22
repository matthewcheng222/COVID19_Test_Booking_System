public class Room {
    private String code;
    private int capacity;
    private int seqID;

    public Room(String code, int capacity) {
        if (capacity > 0) {
            this.code = code;
            this.capacity = capacity;
        }
    }

    public void setSeqID(int seqID) {
        this.seqID = seqID;
    }

    public int getSeqID() {
        return seqID;
    }

    public String getCode() {
        return code;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRooms() {
        return "| " + code + " | capacity: " + capacity + " |";
    }
}
