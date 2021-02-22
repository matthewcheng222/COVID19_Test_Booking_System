import java.util.ArrayList;

public class UniversityResources {
    private ArrayList<Assistant> assistants;
    private ArrayList<Room> rooms;

    public void addAssistants(String assistantName, String assistantUniversityEmail) {
        assistants.add(new Assistant(assistantName, assistantUniversityEmail));
    }

    public void addRooms(String roomCode, int roomCapacity) {
        rooms.add(new Room(roomCode, roomCapacity));
    }

    public ArrayList<Assistant> getAssistants() {
        return assistants;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
