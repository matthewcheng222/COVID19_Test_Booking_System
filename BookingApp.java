import java.util.ArrayList;
import java.util.Scanner;

/**
 * An application for the Booking System of COVID tests for the University of Knowledge
 * 
 * @author Matthew Cheng 
 * @version 1.1
 */
public class BookingApp {
    // private instance variables
    private ArrayList<Assistant> assistants;
    private ArrayList<Room> rooms;
    private BookingSystem bookingSystems = new BookingSystem();

    /**
     * constructor for initialising bookingapp
     * 
     * @param assistants the assistants in the system
     * @param rooms the rooms in the system
     */
    public BookingApp(ArrayList<Assistant> assistants, ArrayList<Room> rooms) {
        this.assistants = assistants;
        this.rooms = rooms;
    }

    /**
     * main menu for the bookingapp
     * 
     * allowing users to access a menu of options:
     *     - listing, adding and removing bookable rooms
     *     - listing, adding and removing assistants on shift
     *     - listing, adding, removing and concluding bookings
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void mainMenu() {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console 
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("Manage Bookings");
        System.out.println("");
        System.out.println("Please, enter the number to select your option:");
        System.out.println("");
        System.out.println("To manage Bookable Rooms:");
        System.out.println("    1. List");
        System.out.println("    2. Add");
        System.out.println("    3. Remove");
        System.out.println("To manage Assistants on Shift:");
        System.out.println("    4. List");
        System.out.println("    5. Add");
        System.out.println("    6. Remove");
        System.out.println("To manage Bookings:");
        System.out.println("    7. List");
        System.out.println("    8. Add");
        System.out.println("    9. Remove");
        System.out.println("    10. Conclude");
        System.out.println("After selecting one the options above, you will be presented other screens.");
        System.out.println("If you press 0, you will be able to return to this main menu.");
        System.out.println("Press -1 (or ctrl+c) to quit this application.");
        System.out.println("");

        selection = input.nextInt();

        // switch cases for user-selected options
        switch (selection) {
            case 0:
                mainMenu();
                break;
            case 1:
                listBookableRooms();
                break;
            case 2:
                addBookableRooms();
                break;
            case 3:
                removeBookableRooms();
                break;
            case 4:
                listAssistantOnShift();
                break;
            case 5:
                addAssistantOnShift();
                break;
            case 6:
                removeAssistantOnShift();
                break;
            case 7:
                listBookings();
                break;
            case 8:
                addBooking();
                break;
            case 9:
                removeBooking();
                break;
            case 10:
                concludeBooking();
                break;
            case -1:
                System.exit(1);
                break;
            default:
                // default case: error message shown when user entered an invalid option
                System.out.println("Invalid selection - please select a valid option from the menu.");
        }
        input.close();
    }

    /**
     * function listBookableRooms (option 1 of main menu)
     * 
     * printing the list of all bookable rooms to the console with the given print template
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void listBookableRooms() {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("List of Bookable Rooms");
        // calling function listAllBookableRooms from bookingSystems
        bookingSystems.listAllBookableRooms();
        System.out.println("");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        input.close();
    }

    /**
     * function addBookableRooms (option 2 of main menu)
     * 
     * print the list of rooms to the console and allow user to choose an entry from the list in order to add a bookable room
     * a bookable room is added by entering the sequential ID, a date and a time seperated by a white space
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void addBookableRooms() {
        String selection;
        int lr = 11; // the sequential ID of the list starts from 11
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("Adding bookable room");
        System.out.println("");
        System.out.println("List of Rooms:");
        // for loop to list out the rooms with sequential ID
        for (int rm = 0; rm < rooms.size(); rm++) {
            String listRooms = "";
            listRooms = rooms.get(rm).getRooms();
            rooms.get(rm).setSeqID(lr);
            System.out.println(lr + ". " + listRooms);
            lr++;
        }
        System.out.println("");
        System.out.println("Please, enter one of the following");
        System.out.println("");
        System.out.println("The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),");
        System.out.println("separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextLine();

        if (selection.equals("0")) {
            mainMenu();
        }
        else if (selection.equals("-1")) {
            System.exit(1);
        }
        else {
            // splitting the user-entered string with empty spaces
            String[] splitString = selection.split(" ");
            // checking if the length of the array splitString is 3 
            // (there should be 3 elements: sequential ID, date and time)
            if (splitString.length == 3) {
                int selectedID = Integer.parseInt(splitString[0]);
                String date = splitString[1];
                String time = splitString[2];
                // concatenating the string date and time to string timeSlot
                String timeSlot = date + " " + time;
                // for loop to check which room does the user-entered sequential ID refer to
                for (int sr = 0; sr < rooms.size(); sr++) {
                    if (rooms.get(sr).getSeqID() == selectedID) {
                        // adding a bookable room by calling the function addBookableRooms from bookingSystems
                        bookingSystems.addBookableRooms(rooms.get(sr), timeSlot);
                        // promoting the user to menu addBookableRoomsValidInput 
                        addBookableRoomsValidInput(selectedID);
                    }
                }
            }
            // checking if the length of the splitted string is not equal to 3
            else if (splitString.length != 3){
                // prompting the user to menu addBookableRoomsInvalidInput
                addBookableRoomsInvalidInput("Please follow the correct format listed below.");
            }
        }

        input.close(); 
    }

    /**
     * menu addBookableRoomsValidInput (if the user input in the menu addBookableRooms is valid)
     * 
     * listing out the bookable room that the user have added
     * @param selectedID the user-selected ID for the bookable room to be added 
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void addBookableRoomsValidInput(int selectedID) {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Bookable Room added successfully:");
        // calling function getSpecificBookableRoomAdd with parameter selectedID from bookingSystems to list the bookableRoom called
        bookingSystems.getSpecificBookableRoomAdd(selectedID);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),");
        System.out.println("separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close(); 
    }

    /**
     * menu addBookableRoomInvalidInput (if the user input in menu addBookableRooms is invalid)
     * 
     * showing the error message 
     * @param errorMessage the error message for the user
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void addBookableRoomsInvalidInput(String errorMessage) {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Error!");
        // printing the error message (parameter passed to the function)
        System.out.println(errorMessage);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),");
        System.out.println("separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close(); 
    }

    /**
     * menu removeBookableRooms (option 3 of main menu)
     * 
     * printing the list of empty bookable rooms and allow user to remove a bookable room from the list
     * a bookable room can be removed by entering the sequential ID (the bookable room must be EMPTY)
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void removeBookableRooms() {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("List of EMPTY Bookable Rooms");
        // calling function listEmptyBookableRooms from bookingSystems to print a list of EMPTY bookable rooms
        bookingSystems.listEmptyBookableRooms();
        System.out.println("");
        System.out.println("Removing bookable room");
        System.out.println("");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the bookable room to be removed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            removeBookableRoomsValidInput(selection);
        }

        input.close();
    }

    public void removeBookableRoomsValidInput(int selectedID) {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Bookable Room removed successfully:");
        bookingSystems.getSpecificBookableRoomRemove(selectedID);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the bookable room to be removed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");
        bookingSystems.removeBookableRooms(selectedID);

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void removeBookableRoomsInvalidInput() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Error!");
        System.out.println("<message explaining the error>");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the bookable room to be removed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void listAssistantOnShift() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("List of Assistants On Shift");
        bookingSystems.listAllAssistantsOnShift();
        System.out.println("");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");
        
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void addAssistantOnShift() {
        String selection;
        int la = 11;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("Adding assistant on shift");
        System.out.println("");
        System.out.println("List of Assistants:");
        for (int at = 0; at < assistants.size(); at++) {
            String listAssistants = "";
            listAssistants = assistants.get(at).getAssistants();
            assistants.get(at).setSeqID(la);
            System.out.println(la + ". " + listAssistants);
            la++;
        }
        System.out.println("");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextLine();

        if (selection.equals("0")) {
            mainMenu();
        }
        else if (selection.equals("-1")) {
            System.exit(1);
        }
        else {
            String[] splitString = selection.split(" ");
            if (splitString.length == 2) {
                int selectedID = Integer.parseInt(splitString[0]);
                String date = splitString[1];
                for (int sa = 0; sa < assistants.size(); sa++) {
                    if (assistants.get(sa).getSeqID() == selectedID) {
                        bookingSystems.addAssistantsOnShift(assistants.get(sa), date);
                    }
                }
                addAssistantOnShiftValidInput();
            }
            else {
                String errorMessage = "This is an error message";
                addAssistantOnShiftInvalidInput(errorMessage);
            }
        }

        input.close();
    }

    public void addAssistantOnShiftValidInput() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Assistant on Shift added successfully:");
        bookingSystems.getNewAddedAssistantsOnShift();
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void addAssistantOnShiftInvalidInput(String errorMessage) {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Error!");
        System.out.println(errorMessage);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void removeAssistantOnShift() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("List of Free Assistants On Shift");
        bookingSystems.listFreeAssistantOnShift();
        System.out.println("");
        System.out.println("Removing assistant on shift");
        System.out.println("");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the assistant on shift to be removed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            removeAssistantOnShiftValidInput(selection);
        }

        input.close();
    }

    public void removeAssistantOnShiftValidInput(int selectedID) {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Assistant on Shift removed successfully:");
        bookingSystems.getSpecificAssistantOnShiftRemove(selectedID);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the assistant on shift to be removed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");
        bookingSystems.removeAssistantsOnShift(selectedID);

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void removeAssistantOnShiftInvalidInput(String errorMessage) {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Error!");
        System.out.println(errorMessage);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the assistant on shift to be removed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void listBookings() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("Select which booking to list:");
        System.out.println("1. All");
        System.out.println("2. Only bookings status:SCHEDULED");
        System.out.println("3. Only bookings status:COMPLETED");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        switch (selection) {
            case 1:
                listBookingsAll();
                break;
            case 2:
                listBookingsScheduled();
                break;
            case 3:
                listBookingsCompleted();
                break;
            case 0:
                mainMenu();
                break;
            case -1:
                System.exit(1);
                break;
            default:
                listBookingsDefault();
                break;
        }

        input.close();
    }

    public void listBookingsAll() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("List of All Bookings:");
        bookingSystems.listAllBookings();
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void listBookingsScheduled() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("List of Scheduled Bookings:");
        bookingSystems.listScheduledBookings();
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void listBookingsCompleted() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("List of Completed Bookings:");
        bookingSystems.listCompletedBookings();
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void listBookingsDefault() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("List of Bookings:");
        bookingSystems.listAllBookings();
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void addBooking() {
        String selection;
        Scanner input = new Scanner(System.in);
        bookingSystems.setAvailableTimeSlots();

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("Adding booking (appointment for a COVID test) to the system");
        System.out.println("");
        System.out.println("List of available time-slots:");
        bookingSystems.showAvailableTimeSlots();
        System.out.println("");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID of an available time-slot and the student email, separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        System.out.println("");

        selection = input.nextLine();

        if (selection.equals("0")) {
            mainMenu();
        }
        else if (selection.equals("-1")) {
            System.exit(1);
        }
        else {
            String[] splitString = selection.split(" ");
            if (splitString.length == 2) {
                int selectedID = Integer.parseInt(splitString[0]);
                String studentEmail = splitString[1];
                for (int i = 0; i < bookingSystems.getAvailableTimeSlots().size(); i++) {
                    String[] availableTimeSlots = bookingSystems.getAvailableTimeSlots().get(i).split(" ");
                    if (Integer.parseInt(availableTimeSlots[0]) == selectedID) {
                        String timeSlot = availableTimeSlots[1] + " " + availableTimeSlots[2];
                        for (int a = 0; a < bookingSystems.getAssistantOnShifts().size(); a++) {
                            if (timeSlot.equals(bookingSystems.getAssistantOnShifts().get(a).getTimeSlot())) {
                                for (int b = 0; b < bookingSystems.getBookableRoom().size(); b++) {
                                    if (timeSlot.equals(bookingSystems.getBookableRoom().get(b).getTimeSlot())) {
                                        bookingSystems.addBookings(timeSlot, studentEmail, bookingSystems.getBookableRoom().get(b), bookingSystems.getAssistantOnShifts().get(a));
                                        addBookingValidInput();
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else {
                String errorMessage = "Please follow the correct format of entry";
                addBookingInvalidInput(errorMessage);
            }
        }

        input.close();
    }

    public void addBookingValidInput() {
        String selection;
        Scanner input = new Scanner(System.in);
        bookingSystems.setAvailableTimeSlots();

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Booking added successfully:");
        bookingSystems.getNewestAddedBooking();
        System.out.println("");
        System.out.println("List of available time-slots:");
        bookingSystems.showAvailableTimeSlots();
        System.out.println("");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID of an available time-slot and the student email, separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        System.out.println("");

        selection = input.nextLine();

        if (selection.equals("0")) {
            mainMenu();
        }
        else if (selection.equals("-1")) {
            System.exit(1);
        }
        else {
            String[] splitString = selection.split(" ");
            if (splitString.length == 2) {
                int selectedID = Integer.parseInt(splitString[0]);
                String studentEmail = splitString[1];
                for (int i = 0; i < bookingSystems.getAvailableTimeSlots().size(); i++) {
                    String[] availableTimeSlots = bookingSystems.getAvailableTimeSlots().get(i).split(" ");
                    if (Integer.parseInt(availableTimeSlots[0]) == selectedID) {
                        String timeSlot = availableTimeSlots[1] + " " + availableTimeSlots[2];
                        for (int a = 0; a < bookingSystems.getAssistantOnShifts().size(); a++) {
                            if (timeSlot.equals(bookingSystems.getAssistantOnShifts().get(a).getTimeSlot())) {
                                for (int b = 0; b < bookingSystems.getBookableRoom().size(); b++) {
                                    if (timeSlot.equals(bookingSystems.getBookableRoom().get(b).getTimeSlot())) {
                                        bookingSystems.addBookings(timeSlot, studentEmail, bookingSystems.getBookableRoom().get(b), bookingSystems.getAssistantOnShifts().get(a));
                                        addBookingValidInput();
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else {
                String errorMessage = "Please follow the correct format of entry";
                addBookingInvalidInput(errorMessage);
            }
        }

        input.close();
    }

    public void addBookingInvalidInput(String errorMessage) {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Error!");
        System.out.println(errorMessage);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID of an available time-slot and the student email, separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void removeBooking() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("List of Scheduled Bookings");
        bookingSystems.listScheduledBookings();
        System.out.println("");
        System.out.println("Removing booking from the system");
        System.out.println("");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the booking to be removed from the listed bookings above.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            removeBookingValidInput(selection);
        }

        input.close();
    }

    public void removeBookingValidInput(int selectedID) {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Booking removed successfully:");
        bookingSystems.getSpecificBooking(selectedID);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the booking to be removed from the listed bookings above.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");
        bookingSystems.removeBookings(selectedID);

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void removeBookingInvalidInput(String errorMessage) {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Error!");
        System.out.println(errorMessage);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the booking to be removed from the listed bookings above.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void concludeBooking() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("List of Scheduled Bookings:");
        bookingSystems.listScheduledBookings();
        System.out.println("");
        System.out.println("Conclude booking");
        System.out.println("");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the booking to be completed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            concludeBookingValidInput(selection);
        }

        input.close();
    }

    public void concludeBookingValidInput(int selectedID) {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Booking completed successfully:");
        bookingSystems.concludeBookings(selectedID);
        bookingSystems.getSpecificBooking(selectedID);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the booking to be completed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    public void concludeBookingInvalidInput() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Error!");
        System.out.println("<message explaining the error>");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the booking to be completed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }

        input.close();
    }

    /**
     * The main method
     */
    public static void main(String[] args) {
        ArrayList<Assistant> assistants = new ArrayList<>();
        String[] assistantName;
        String[] assistantUniversityEmail;
        assistantName = new String[]{"Alex", "Boris", "Charlie"};
        assistantUniversityEmail = new String[]{"al123@uok.ac.uk", "bo456@uok.ac.uk", "ch789@uok.ac.uk"};
        for (int a = 0; a < assistantName.length; a++) {
            assistants.add(new Assistant(assistantName[a], assistantUniversityEmail[a]));
        }

        ArrayList<Room> rooms = new ArrayList<>();
        String[] roomCode;
        int[] roomCapacity;
        roomCode = new String[]{"AB123", "CD456", "EF789"};
        roomCapacity = new int[]{3, 4, 5};
        for (int r = 0; r < roomCode.length; r++) {
            rooms.add(new Room(roomCode[r], roomCapacity[r]));
        }

        BookingApp bookingApp = new BookingApp(assistants, rooms);

        bookingApp.mainMenu();
    }
}
