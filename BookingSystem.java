import java.util.ArrayList;

public class BookingSystem {
    // private instance variables
    private ArrayList<BookableRoom> bookableRooms = new ArrayList<>();
    private ArrayList<AssistantOnShift> assistantOnShifts = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<String> availableTimeSlots = new ArrayList<>();

    /**
     * function addBookableRooms
     * 
     * adding bookable rooms to arraylist bookableRooms by calling constructor BookableRoom()
     * 
     * @param rooms the room to be added to bookable room
     * @param timeSlot the time slot to be added to bookable room
     */
    public void addBookableRooms(Room rooms, String timeSlot) {
        bookableRooms.add(new BookableRoom(rooms, timeSlot));
    }
    
    /**
     * function removeBookableRooms
     * 
     * removing the bookable room of the user-inputted sequential ID from the arraylist bookableRooms 
     * 
     * @param selectedID the user passed sequential ID of the bookable room to be removed
     */
    public void removeBookableRooms(int selectedID) {
        for (int br = 0; br < bookableRooms.size(); br++) {
            if (bookableRooms.get(br).getSeqID() == selectedID) {
                bookableRooms.remove(br);
            }
        }
    }

    /**
     * function listAllBookableRooms
     * 
     * listing all bookable rooms from the arraylist bookableRooms
     */
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

    /**
     * function listEmptyBookableRooms
     * 
     * listing all bookable rooms with status EMPTY from the arraylist bookableRooms
     */
    public void listEmptyBookableRooms() {
        int lb = 11;
        for (int br = 0; br < bookableRooms.size(); br++) {
            String toShowEmptyBookableRooms = "";
            if (bookableRooms.get(br).getStatus().equals("EMPTY")) {
                toShowEmptyBookableRooms = bookableRooms.get(br).getBookableRooms();
                bookableRooms.get(br).setSeqID(lb);
                System.out.println(lb + ". " + toShowEmptyBookableRooms);
                lb++;
            }
        }
    }

    /**
     * function getSpecificBookableRoomAdd
     * 
     * printing the bookable room of the user-inputted sequential ID (from list of rooms)
     * @param selectedID the user-selected sequential ID of the bookable room to be printed
     */
    public void getSpecificBookableRoomAdd(int selectedID) {
        for (int br = 0; br < bookableRooms.size(); br++) {
            if (bookableRooms.get(br).getRooms().getSeqID() == selectedID) {
                System.out.println(bookableRooms.get(br).getBookableRooms());
            }
        }
    }

    /**
     * function getSpecificBookableRoomRemove
     * 
     * printing the bookable room of the user-inputted sequential ID (from list of bookable rooms)
     * @param selectedID the user-selected sequential ID of the bookable room to be printed
     */
    public void getSpecificBookableRoomRemove(int selectedID) {
        for (int br = 0; br < bookableRooms.size(); br++) {
            if (bookableRooms.get(br).getSeqID() == selectedID) {
                System.out.println(bookableRooms.get(br).getBookableRooms());
            }
        }
    }

    /**
     * function getBookableRoom
     * 
     * @return the arraylist of bookableRooms
     */
    public ArrayList<BookableRoom> getBookableRoom() {
        return bookableRooms;
    }

    /**
     * function getAssistantOnShifts
     * 
     * @return the arraylist of assistantOnShifts
     */
    public ArrayList<AssistantOnShift> getAssistantOnShifts() {
        return assistantOnShifts;
    }

    /**
     * function addAssistantsOnShift
     * 
     * creating 3 assistants on shift when 1 assistant and date is passed (07:00, 08:00, 09:00)
     * 
     * @param assistants the assistant of assistant on shift to be added
     * @param date the date of assistant on shift to be added
     */
    public void addAssistantsOnShift(Assistant assistants, String date) {
        assistantOnShifts.add(new AssistantOnShift(assistants, date + " 07:00"));
        assistantOnShifts.add(new AssistantOnShift(assistants, date + " 08:00"));
        assistantOnShifts.add(new AssistantOnShift(assistants, date + " 09:00"));
    }

    /**
     * function getNewAddedAssistantsOnShift
     * 
     * printing the 3 newest added assistant on shift
     */
    public void getNewAddedAssistantsOnShift() {
        System.out.println(assistantOnShifts.get(assistantOnShifts.size()-3).getAssistantOnShift());
        System.out.println(assistantOnShifts.get(assistantOnShifts.size()-2).getAssistantOnShift());
        System.out.println(assistantOnShifts.get(assistantOnShifts.size()-1).getAssistantOnShift());
    }
    
    /**
     * function listFreeAssistantOnShift
     * 
     * listing the assistants on shift with the status of FREE
     */
    public void listFreeAssistantOnShift() {
        int la = 11;
        for (int as = 0; as < assistantOnShifts.size(); as++) {
            String toShowFreeAssistantOnShift = "";
            if (assistantOnShifts.get(as).getStatus().equals("FREE")) {
                toShowFreeAssistantOnShift = assistantOnShifts.get(as).getAssistantOnShift();
                assistantOnShifts.get(as).setSeqID(la);
                System.out.println(la + ". " + toShowFreeAssistantOnShift);
                la++;
            }
        }
    }
    
    /**
     * function removeAssistantsOnShift
     * 
     * @param selectedID the user-inputted sequential ID of the assistant on shift to be removed
     */
    public void removeAssistantsOnShift(int selectedID) {
        for (int as = 0; as < assistantOnShifts.size(); as++) {
            if (assistantOnShifts.get(as).getSeqID() == selectedID) {
                assistantOnShifts.remove(as);
            }
        }
    }

    /**
     * function listAllAssistantsOnShift
     * 
     * listing all assistants on shift
     */
    public void listAllAssistantsOnShift() {
        int la = 11;
        String toShowAssistantsOnShift = "";
        for (int aos = 0; aos < assistantOnShifts.size(); aos++) {
            toShowAssistantsOnShift = assistantOnShifts.get(aos).getAssistantOnShift();
            assistantOnShifts.get(aos).setSeqID(la);
            System.out.println(la + ". " + toShowAssistantsOnShift);
            la++;
        }
    }

    /**
     * function getSpecificAssistantOnShiftAdd
     * 
     * printing the assistant on shift of the user-inputted sequential ID (from list of assistants)
     * @param selectedID the user-selected sequential ID of the assistant on shift to be printed
     */
    public void getSpecificAssistantOnShiftAdd(int selectedID) {
        for (int br = 0; br < assistantOnShifts.size(); br++) {
            if (assistantOnShifts.get(br).getAssistants().getSeqID() == selectedID) {
                System.out.println(assistantOnShifts.get(br).getAssistants());
            }
        }
    }

    /**
     * function getSpecificAssistantOnShiftAdd
     * 
     * printing the assistant on shift of the user-inputted sequential ID (from list of assistants on shift)
     * @param selectedID the user-selected sequential ID of the assistant on shift to be printed
     */
    public void getSpecificAssistantOnShiftRemove(int selectedID) {
        for (int br = 0; br < assistantOnShifts.size(); br++) {
            if (assistantOnShifts.get(br).getSeqID() == selectedID) {
                System.out.println(assistantOnShifts.get(br).getAssistantOnShift());
            }
        }
    }

    /**
     * function setAvailableTimeSlots
     * 
     * clearing and refreshing the arraylist of availableTimeSlots which contains available time slots
     * (a time slot is available if there is a bookable room not FULL and an assistant on shift which is FREE at a certain time)
     */
    public void setAvailableTimeSlots() {
        int la = 11;
        availableTimeSlots.clear();
        for (int as = 0; as < assistantOnShifts.size(); as++) {
            for (int br = 0; br < bookableRooms.size(); br++) {
                if (bookableRooms.get(br).getTimeSlot().equals(assistantOnShifts.get(as).getTimeSlot()) && (!bookableRooms.get(br).getStatus().equals("FULL") && assistantOnShifts.get(as).getStatus().equals("FREE"))) {
                    availableTimeSlots.add(la + " " + bookableRooms.get(br).getTimeSlot());
                    la++;
                }
            }
        }
    }

    /**
     * function showAvailableTimeSlots
     * 
     * printing the list of available time slots
     */
    public void showAvailableTimeSlots() {
        for (int i = 0; i < availableTimeSlots.size(); i++) {
            String[] splitString = availableTimeSlots.get(i).split(" ");
            int seqID = Integer.parseInt(splitString[0]);
            String timeSlot = splitString[1] + " " + splitString[2];
            System.out.println(seqID + ". " + timeSlot);
        }
    }

    /**
     * function getAvailableTimeSlots
     * 
     * @return the arraylist of availableTimeSlots
     */
    public ArrayList<String> getAvailableTimeSlots() {
        return availableTimeSlots;
    }
    
    /**
     * function addBookings
     * 
     * @param timeSlot the time slot of the booking to be added
     * @param studentEmail the student email of the booking to be added
     * @param bookableRooms the bookable room of the booking to be added
     * @param assistantOnShifts the assistant on shift of the booking to be added
     */
    public void addBookings(String timeSlot, String studentEmail, BookableRoom bookableRooms, AssistantOnShift assistantOnShifts) {
        bookings.add(new Booking(timeSlot, studentEmail, bookableRooms, assistantOnShifts));
        // setting the status of assistant on shift to be busy when a booking is created
        assistantOnShifts.setStatus("BUSY");
    }

    /**
     * function concludeBookings
     * 
     * setting the status of a booking to COMPLETED
     * @param selectedID the user-inputted sequential ID of the booking to be concluded
     */
    public void concludeBookings(int selectedID) {
        for (int b = 0; b < bookings.size(); b++) {
            if (bookings.get(b).getSeqID() == selectedID) {
                bookings.get(b).setStatusCompleted();
            }
        }
    }

    /**
     * function removeBookings
     * 
     * @param selectedID the user-inputted sequential ID of the booking to be removed 
     */
    public void removeBookings(int selectedID) {
        for (int b = 0; b < bookings.size(); b++) {
            if (bookings.get(b).getSeqID() == selectedID) {
                bookings.remove(b);
                // setting the status of assistant on shift to be FREE when a booking is removed
                bookings.get(b).getAssistantOnShifts().setStatus("FREE");
            }
        }
    }

    /**
     * function getSpecificBooking
     * 
     * printing a booking with user-inputted sequential ID
     * @param selectedID the sequential ID of the booking to be printed
     */
    public void getSpecificBooking(int selectedID) {
        for (int b = 0; b < bookings.size(); b++) {
            if (bookings.get(b).getSeqID() == selectedID) {
                System.out.println(bookings.get(b).getBookings());
            }
        }
    }

    /**
     * function getNewestAddedBooking
     * 
     * printing the newest added booking
     */
    public void getNewestAddedBooking() {
        System.out.println(bookings.get(bookings.size()-1).getBookings());
    }

    /**
     * function listAllBookings
     * 
     * listing all bookings with sequential ID
     */
    public void listAllBookings() {
        int lb = 11;
        String toShowAllBookings = "";
        for (int ab = 0; ab < bookings.size(); ab++) {
            toShowAllBookings = bookings.get(ab).getBookings();
            bookings.get(ab).setSeqID(lb);
            System.out.println(lb + ". " + toShowAllBookings);
            lb++;
        }
    }

    /**
     * function listScheduledBookings
     * 
     * listing scheduled bookings with sequential ID
     */
    public void listScheduledBookings() {
        int lb = 11;
        String toShowScheduledBookings = "";
        for (int ab = 0; ab < bookings.size(); ab++) {
            if (bookings.get(ab).getStatus().equals("SCHEDULED")) {
                toShowScheduledBookings = bookings.get(ab).getBookings();
                bookings.get(ab).setSeqID(lb);
                System.out.println(lb + ". " + toShowScheduledBookings);
                lb++;
            }
        }
    }

    /**
     * function listCompletedBookings
     * 
     * listing completed bookings with sequential ID
     */
    public void listCompletedBookings() {
        int lb = 11;
        String toShowCompletedBookings = "";
        for (int ab = 0; ab < bookings.size(); ab++) {
            if (bookings.get(ab).getStatus().equals("COMPLETED")) {
                toShowCompletedBookings = bookings.get(ab).getBookings();
                bookings.get(ab).setSeqID(lb);
                System.out.println(lb + ". " + toShowCompletedBookings);
                lb++;
            }
        }
    }
    
}
