import java.util.ArrayList;
import java.util.Scanner;

/**
 * An application for the Booking System of COVID tests for the University of Knowledge
 * 
 * @author Matthew Cheng 
 * @author https://github.com/matthewcheng222
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

        // setting variable selection to be the next inputted integer
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

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else{
            // if user enters an invalid option -> prompted back to listBookableRooms
            System.out.println("Please enter an valid option");
            listBookableRooms();
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

        // setting variable selection to be the next inputted line
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
                    // checking if user-inputted date matches format <dd/mm/yyyy> and time matches format <HH:MM>
                    if (rooms.get(sr).getSeqID() == selectedID && date.matches("\\d{2}/\\d{2}/\\d{4}") && time.matches("\\d{2}:\\d{2}")) {
                        // adding a bookable room by calling the function addBookableRooms from bookingSystems
                        bookingSystems.addBookableRooms(rooms.get(sr), timeSlot);
                        // promoting the user to menu addBookableRoomsValidInput 
                        addBookableRoomsValidInput(selectedID);
                    }
                    else {
                        // prompt user to addBookableRoomsInvalidInput if user entered date and time does not match the format
                        addBookableRoomsInvalidInput("Please enter a valid date and time (<dd/mm/yyyy HH:MM>)");
                    }
                }
            }
            // checking if the length of the splitted string is not equal to 3
            else if (splitString.length != 3){
                // prompting the user to menu addBookableRoomsInvalidInput since user input does not follow the required format
                addBookableRoomsInvalidInput("Please follow the correct format listed below.");
            }
            else {
                // prompting the user to menu addBookableRoomsInvalidInput
                addBookableRoomsInvalidInput("Please enter a valid option.");
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

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu addBookableRooms if user-entered option is invalid
            System.out.println("Please enter a valid option");
            addBookableRooms();
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

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu addBookableRooms if user-entered option is invalid
            System.out.println("Please enter a valid option");
            addBookableRooms();
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

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // checking if the user input is of type integer
            if (input.hasNextInt()) {
                removeBookableRoomsValidInput(selection);
            }
            else {
                String errorMessage = "Please enter a valid option";
                removeBookableRoomsInvalidInput(errorMessage);
            }
        }
        input.close();
    }

    /**
     * menu removeBookableRoomsValidInput (if the user input in menu removeBookableRooms is valid)
     * 
     * printing the bookable room to be removed and removing it
     * only EMPTY bookable rooms can be removed (menu removeBookableRooms on shows EMPTY bookable rooms as options)
     * @param selectedID the user-selected sequential ID of bookable room to be removed
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void removeBookableRoomsValidInput(int selectedID) {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Bookable Room removed successfully:");
        // printing the bookable room to be removed
        bookingSystems.getSpecificBookableRoomRemove(selectedID);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the bookable room to be removed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");
        // removing the user-selected bookable room by calling function removeBookableRooms from bookingSystems
        bookingSystems.removeBookableRooms(selectedID);

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu removeBookableRooms if user-entered option is invalid
            System.out.println("Please enter a valid option");
            removeBookableRooms();
        }
        input.close();
    }

    /**
     * menu removeBookableRoomsInvalidInput (if the user input in menu removeBookableRooms is invalid)
     * 
     * printing the error message if user input for removing bookable room is invalid
     * @param errorMessage the error message to be printed to user 
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void removeBookableRoomsInvalidInput(String errorMessage) {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Error!");
        // printing the passed parameter errorMessage
        System.out.println(errorMessage);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the bookable room to be removed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu removeBookableRooms if user-entered option is invalid
            System.out.println("Please enter a valid option");
            removeBookableRooms();
        }
        input.close();
    }

    /**
     * menu listAssistantOnShift (option 4 of main menu)
     * 
     * listing all assistants on shift with their sequential ID
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void listAssistantOnShift() {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("List of Assistants On Shift");
        // listing out all assistants on shift by calling function listAllAssistantsOnShift from bookingSystems
        bookingSystems.listAllAssistantsOnShift();
        System.out.println("");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");
        
        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu listAssistantOnShift if user-entered option is invalid
            System.out.println("Please enter a valid option");
            listAssistantOnShift();
        }
        input.close();
    }

    /**
     * menu addAssistantOnShift (option 5 of main manu)
     * 
     * printing the list of assistants with sequential ID
     * adding assistant on shift by inputting their sequential ID and date
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void addAssistantOnShift() {
        String selection;
        int la = 11;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("Adding assistant on shift");
        System.out.println("");
        System.out.println("List of Assistants:");
        // printing the list of assistants with their sequential ID
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

        // setting variable selection to be the next inputted line
        selection = input.nextLine();

        if (selection.equals("0")) {
            mainMenu();
        }
        else if (selection.equals("-1")) {
            System.exit(1);
        }
        else {
            // splitting the user inputted line by empty spaces
            String[] splitString = selection.split(" ");
            // checking if array of splitted string is of length 2
            if (splitString.length == 2) {
                // setting variable selectedID to be the first element of the user inputted line
                int selectedID = Integer.parseInt(splitString[0]);
                // setting variable date to be the second element of the user inputted line
                String date = splitString[1];
                for (int sa = 0; sa < assistants.size(); sa++) {
                    // check if user-inputted date matches format of <dd/mm/yyyy>
                    if (assistants.get(sa).getSeqID() == selectedID && date.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        // adding assistant on shift by calling function addAssistantsOnShift from bookingSystems
                        bookingSystems.addAssistantsOnShift(assistants.get(sa), date);
                        // prompting user to menu addAssistantOnShiftValidInput if their input is valid
                        addAssistantOnShiftValidInput();
                    }
                    else {
                        // prompting user to menu addAssistantOnShiftInvalidInput since the inputted date format is invalid
                        String errorMessage = "Please enter a valid date of format <dd/mm/yyyy>";
                        addAssistantOnShiftInvalidInput(errorMessage);
                    }
                }
            }
            else if (splitString.length != 2) {
                // prompting user to menu addAssistantOnShiftInvalidInput since the inputted format is invalid
                String errorMessage = "Please enter a valid option using the format below";
                addAssistantOnShiftInvalidInput(errorMessage);
            }
            else {
                // prompting user to menu addAssistantOnShiftInvalidInput since the inputted option is invalid
                String errorMessage = "Please enter a valid option";
                addAssistantOnShiftInvalidInput(errorMessage);
            }
        }
        input.close();
    }

    /**
     * menu addAssistantOnShiftValidInput (if the user input in menu addAssistantOnShift is valid)
     * 
     * printing the assistant on shift to be added (newest element of array assistantOnShifts)
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void addAssistantOnShiftValidInput() {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Assistant on Shift added successfully:");
        // printing the newest added assistant on shift by calling functin getNewAddedAssistantsOnShift from bookingSystems
        bookingSystems.getNewAddedAssistantsOnShift();
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu addAssistantOnShift if user-entered option is invalid
            System.out.println("Please enter a valid option");
            addAssistantOnShift();
        }
        input.close();
    }

    /**
     * menu addAssistantOnShiftInvalidInput (if the user input in menu addAssistantOnShift is invalid)
     * 
     * @param errorMessage the error messsage to be printed to the user
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void addAssistantOnShiftInvalidInput(String errorMessage) {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Error!");
        // printing the error message
        System.out.println(errorMessage);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu addAssistantOnShift if user-entered option is invalid
            System.out.println("Please enter a valid option");
            addAssistantOnShift();
        }
        input.close();
    }

    /**
     * menu removeAssistantOnShift (option 6 of main menu)
     * 
     * listing free assistants on shift and allowing user to remove assistant on shift
     * assistant on shift can be removed by entering the sequential ID of the entry
     * only FREE assistants can be removed from the system (only FREE assistants are listed as options)
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void removeAssistantOnShift() {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("List of Free Assistants On Shift");
        // printing the list of free assistants on shift by calling function listFreeAssistantOnShift from bookingSystems
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

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // checking if user input is of type integer
            if (input.hasNextInt()) {
                // prompting user to menu removeAssistantOnShiftValidInput if input is valid
                removeAssistantOnShiftValidInput(selection);
            }
            else {
                // prompting user to menu removeAssistantOnShiftInvalidInput since user-input is invalid
                String errorMessage = "Please enter a valid option";
                removeAssistantOnShiftInvalidInput(errorMessage);
            }
        }
        input.close();
    }

    /**
     * menu removeAssistantOnShiftValidInput (if the user input in menu addAssistantOnShift is valid)
     * 
     * printing the assistant on shift to be removed and removing it
     * @param selectedID the sequential ID of assistant on shift to be removed
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void removeAssistantOnShiftValidInput(int selectedID) {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Assistant on Shift removed successfully:");
        // printing the assistant on shift to be removed by calling function getSpecificAssistantOnShiftRemove from bookingSystems
        bookingSystems.getSpecificAssistantOnShiftRemove(selectedID);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the assistant on shift to be removed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");
        // removing the assistant on shift by calling function removeAssistantsOnShift from bookingSystems with sequential ID
        bookingSystems.removeAssistantsOnShift(selectedID);

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu removeAssistantOnShift if user-entered option is invalid
            System.out.println("Please enter a valid option");
            removeAssistantOnShift();
        }
        input.close();
    }

    /**
     * menu removeAssistantOnShiftInvalidInput (if the user input in menu addAssistantOnShift is invalid)
     * 
     * @param errorMessage the error message to be printed to the console
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void removeAssistantOnShiftInvalidInput(String errorMessage) {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Error!");
        // printing the errorMessage
        System.out.println(errorMessage);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the assistant on shift to be removed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu removeAssistantOnShift if user-entered option is invalid
            System.out.println("Please enter a valid option");
            removeAssistantOnShift();
        }
        input.close();
    }

    /**
     * menu listBookings (option 7 of main menu)
     * 
     * allowing users to access a menu of options for listing bookings:
     *     listing all / scheduled or completed bookings
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void listBookings() {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
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

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        // switch cases for user-selected options
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

    /**
    * menu listBookingsAll (option 1 of menu listBookings)
    * 
    * listing ALL bookings with sequential ID
    * 
    * (option 0 returns to main menu, option -1 quits the application)
    */
    public void listBookingsAll() {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("List of All Bookings:");
        // printing out all bookings with sequential ID by calling function listAllBookings from bookingSystems
        bookingSystems.listAllBookings();
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu listBookings if user-entered option is invalid
            System.out.println("Please enter a valid option");
            listBookings();
        }
        input.close();
    }

    /**
    * menu listBookingsScheduled (option 2 of menu listBookings)
    * 
    * listing SCHEDULED bookings with sequential ID
    * 
    * (option 0 returns to main menu, option -1 quits the application)
    */
    public void listBookingsScheduled() {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("List of Scheduled Bookings:");
        // printing out scheduled bookings with sequential ID by calling function listScheduledBookings from bookingSystems
        bookingSystems.listScheduledBookings();
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu listBookings if user-entered option is invalid
            System.out.println("Please enter a valid option");
            listBookings();
        }
        input.close();
    }

    /**
    * menu listBookingsCompleted (option 3 of menu listBookings)
    * 
    * listing COMPLETED bookings with sequential ID
    * 
    * (option 0 returns to main menu, option -1 quits the application)
    */
    public void listBookingsCompleted() {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("List of Completed Bookings:");
        // printing out completed bookings with sequential ID by calling function listCompletedBookings from bookingSystems
        bookingSystems.listCompletedBookings();
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu listBookings if user-entered option is invalid
            System.out.println("Please enter a valid option");
            listBookings();
        }
        input.close();
    }

    /**
    * menu listBookingsDefault (default case of menu listBookings)
    * 
    * listing ALL bookings with sequential ID (default case)
    * 
    * (option 0 returns to main menu, option -1 quits the application)
    */
    public void listBookingsDefault() {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console 
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("List of Bookings:");
        // printing out all bookings with sequential ID by calling function listAllBookings from bookingSystems
        bookingSystems.listAllBookings();
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu listBookings if user-entered option is invalid
            System.out.println("Please enter a valid option");
            listBookings();
        }
        input.close();
    }

    /**
     * menu addBooking (option 8 of main menu)
     * 
     * allow the user to add bookings by selecting the sequential ID of the list of available time slots
     * a booking can be added if there is a bookable room not FULL and an assistant on shift not FREE at a given time
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void addBooking() {
        String selection;
        Scanner input = new Scanner(System.in);
        // setting / refreshing the arraylist availableTimeSlots by calling function setAvailableTimeSlots from bookingSystems
        bookingSystems.setAvailableTimeSlots();

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("Adding booking (appointment for a COVID test) to the system");
        System.out.println("");
        System.out.println("List of available time-slots:");
        // printing out the list of available time slots by calling function showAvailableTimeSlots from bookingSystems
        bookingSystems.showAvailableTimeSlots();
        System.out.println("");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID of an available time-slot and the student email, separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        System.out.println("");

        // setting variable selection to be the next inputted line
        selection = input.nextLine();

        if (selection.equals("0")) {
            mainMenu();
        }
        else if (selection.equals("-1")) {
            System.exit(1);
        }
        else {
            String[] splitString = selection.split(" ");
            // checking if the length of array splitString is 2 and the second element (student email) follows the pattern *@uok.ac.uk
            if (splitString.length == 2 && splitString[1].endsWith("@uok.ac.uk")) {
                // setting the variable selectedID to be the first element of array splitString
                int selectedID = Integer.parseInt(splitString[0]);
                // setting the variable selectedID to be the second element of array splitString
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
            // case if the length of splitString is not 2 (wrong entry format)
            else if (splitString.length != 2) {
                // prompting user to menu addBookingInvalidInput since the format of entry is invalid
                String errorMessage = "Please follow the correct format of entry";
                addBookingInvalidInput(errorMessage);
            }
            else {
                // prompting user to menu addBookingInvalidInput since the student email format is invalid
                String errorMessage = "Please enter a valid student email";
                addBookingInvalidInput(errorMessage);
            }
        }
        input.close();
    }

    /**
     * menu addBookingValidInput (if the user input in menu addBooking is valid)
     * 
     * printing the newest added booking and allowing user to further book bookings
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void addBookingValidInput() {
        String selection;
        Scanner input = new Scanner(System.in);
        // setting / refreshing the arraylist availableTimeSlots by calling function setAvailableTimeSlots from bookingSystems
        bookingSystems.setAvailableTimeSlots();

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Booking added successfully:");
        // printing the newest added booking
        bookingSystems.getNewestAddedBooking();
        System.out.println("");
        System.out.println("List of available time-slots:");
        // printing out the list of available time slots by calling function showAvailableTimeSlots from bookingSystems
        bookingSystems.showAvailableTimeSlots();
        System.out.println("");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID of an available time-slot and the student email, separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        System.out.println("");

        // setting variable selection to be the next inputted line
        selection = input.nextLine();

        if (selection.equals("0")) {
            mainMenu();
        }
        else if (selection.equals("-1")) {
            System.exit(1);
        }
        else {
            String[] splitString = selection.split(" ");
            // checking if the length of array splitString is 2 and the second element (student email) follows the pattern *@uok.ac.uk
            if (splitString.length == 2 && splitString[1].endsWith("@uok.ac.uk")) {
                // setting the variable selectedID to be the first element of array splitString
                int selectedID = Integer.parseInt(splitString[0]);
                // setting the variable selectedID to be the second element of array splitString
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
            // case if the length of splitString is not 2 (wrong entry format)
            else if (splitString.length != 2) {
                // prompting user to menu addBookingInvalidInput since the format of entry is invalid
                String errorMessage = "Please follow the correct format of entry";
                addBookingInvalidInput(errorMessage);
            }
            else {
                // prompting user to menu addBookingInvalidInput since the student email format is invalid
                String errorMessage = "Please enter a valid student email";
                addBookingInvalidInput(errorMessage);
            }
        }
        input.close();
    }

    /**
     * menu addBookingInvalidInput (if the user input in menu addBooking is invalid)
     * 
     * @param errorMessage the error message to be printed to the user
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void addBookingInvalidInput(String errorMessage) {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Error!");
        // printing the error message
        System.out.println(errorMessage);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID of an available time-slot and the student email, separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        System.out.println("");

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu addBooking if user-entered option is invalid
            System.out.println("Please enter a valid option");
            addBooking();
        }
        input.close();
    }

    /**
     * menu removeBooking (option 9 of the main menu)
     * 
     * printing the list of scheduled bookings and allow user to remove a booking by inputting the sequential ID
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void removeBooking() {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("List of Scheduled Bookings");
        // printing the list of scheduled bookings
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

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // checking if user input is of type int
            if (input.hasNextInt()) {
                // prompting user to menu removeBookingValidInput
                removeBookingValidInput(selection);
            }
            else {
                // prompting user to menu removeBookingInvalidInput with errorMessage
                String errorMessage = "Please enter a valid input";
                removeBookingInvalidInput(errorMessage);
            }
        }
        input.close();
    }

    /**
     * menu removeBookingValidInput (if the user input in menu removeBooking is valid)
     * 
     * printing the booking to be removed and removing the booking
     * only a SCHEDULED booking can be removed (since only SCHEDULED bookings are listed)
     * @param selectedID the sequential ID of the booking to be removed
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void removeBookingValidInput(int selectedID) {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Booking removed successfully:");
        // printing the booking to be removed
        bookingSystems.getSpecificBooking(selectedID);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the booking to be removed from the listed bookings above.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");
        // removing the booking by calling function removeBookings from bookingSystems with selectedID
        bookingSystems.removeBookings(selectedID);

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu removeBooking if user-entered option is invalid
            System.out.println("Please enter a valid option");
            removeBooking();
        }
        input.close();
    }

    /**
     * menu removeBookingInvalidInput (if the user input in menu removeBooking is invalid)
     * 
     * @param errorMessage the error message to be printed to the user
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void removeBookingInvalidInput(String errorMessage) {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Error!");
        // printing the error message
        System.out.println(errorMessage);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the booking to be removed from the listed bookings above.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu removeBooking if user-entered option is invalid
            System.out.println("Please enter a valid option");
            removeBooking();
        }
        input.close();
    }

    /**
     * menu concludeBooking (option 10 of the main menu)
     * 
     * printing the list of scheduled bookings with sequential ID and allowing user to conclude a booking
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void concludeBooking() {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("List of Scheduled Bookings:");
        // printing the list of scheduled bookings
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

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // checking if user input is of type integer
            if (input.hasNextInt()) {
                // prompting user to menu concludeBookingValidInput
                concludeBookingValidInput(selection);
            }
            else {
                // prompting user to menu concludeBookingInvalidInput with errorMessage
                String errorMessage = "Please enter a valid option";
                concludeBookingInvalidInput(errorMessage);
            }
        }
        input.close();
    }

    /**
     * menu concludeBookingValidInput (if the user input in menu concludeBooking is valid)
     * 
     * @param selectedID the sequential ID of booking to be concluded
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void concludeBookingValidInput(int selectedID) {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Booking completed successfully:");
        // concluding the booking by calling function concludeBookings from bookingSystems with selectedID
        bookingSystems.concludeBookings(selectedID);
        // printing the booking concluded
        bookingSystems.getSpecificBooking(selectedID);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the booking to be completed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu concludeBooking if user-entered option is invalid
            System.out.println("Please enter a valid option");
            concludeBooking();
        }
        input.close();
    }

    /**
     * menu concludeBookingInvalidInput (if the user input in menu concludeBooking is invalid)
     * 
     * @param errorMessage the error message to be printed to the user
     * 
     * (option 0 returns to main menu, option -1 quits the application)
     */
    public void concludeBookingInvalidInput(String errorMessage) {
        int selection;
        Scanner input = new Scanner(System.in);

        // clearing the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Error!");
        // printing the error message to the user
        System.out.println(errorMessage);
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the booking to be completed.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application");
        System.out.println("");

        // setting variable selection to be the next inputted integer
        selection = input.nextInt();

        if (selection == 0) {
            mainMenu();
        }
        else if (selection == -1) {
            System.exit(1);
        }
        else {
            // prompting the user back to menu concludeBooking if user-entered option is invalid
            System.out.println("Please enter a valid option");
            concludeBooking();
        }
        input.close();
    }

    /**
     * loads the main menu with initial data, including creating
     *     - 9 bookable rooms
     *     - 6 assistants on shift
     *     - 2 bookings
     */
    public void initializeData() {
        // adding 9 bookable rooms
        bookingSystems.addBookableRooms(rooms.get(0), "21/02/2021 07:00");
        bookingSystems.addBookableRooms(rooms.get(0), "21/02/2021 08:00");
        bookingSystems.addBookableRooms(rooms.get(0), "21/02/2021 09:00");
        bookingSystems.addBookableRooms(rooms.get(1), "21/02/2021 07:00");
        bookingSystems.addBookableRooms(rooms.get(1), "21/02/2021 08:00");
        bookingSystems.addBookableRooms(rooms.get(1), "21/02/2021 09:00");
        bookingSystems.addBookableRooms(rooms.get(2), "21/02/2021 07:00");
        bookingSystems.addBookableRooms(rooms.get(2), "21/02/2021 08:00");
        bookingSystems.addBookableRooms(rooms.get(2), "21/02/2021 09:00");

        // adding 6 assistants on shift (3 assistants on shift is created when passed at once)
        bookingSystems.addAssistantsOnShift(assistants.get(0), "21/02/2021");
        bookingSystems.addAssistantsOnShift(assistants.get(1), "21/02/2021");

        // adding 2 bookings
        bookingSystems.addBookings("21/02/2021 07:00", "ab123@uok.ac.uk", bookingSystems.getBookableRoom().get(0), bookingSystems.getAssistantOnShifts().get(0));
        bookingSystems.addBookings("21/02/2021 08:00", "cd456@uok.ac.uk", bookingSystems.getBookableRoom().get(4), bookingSystems.getAssistantOnShifts().get(4));

        // concluding 1 booking
        bookingSystems.getBookings().get(1).setStatusCompleted();
    }

    /**
     * The main method
     */
    public static void main(String[] args) {
        // initialising the arraylist of assistants with initial datas
        ArrayList<Assistant> assistants = new ArrayList<>();
        String[] assistantName;
        String[] assistantUniversityEmail;
        assistantName = new String[]{"Alex", "Boris", "Charlie"};
        assistantUniversityEmail = new String[]{"al123@uok.ac.uk", "bo456@uok.ac.uk", "ch789@uok.ac.uk"};
        for (int a = 0; a < assistantName.length; a++) {
            assistants.add(new Assistant(assistantName[a], assistantUniversityEmail[a]));
        }

        // initialising the arraylist of rooms with initial datas
        ArrayList<Room> rooms = new ArrayList<>();
        String[] roomCode;
        int[] roomCapacity;
        roomCode = new String[]{"AB123", "CD456", "EF789"};
        roomCapacity = new int[]{1, 4, 5};
        for (int r = 0; r < roomCode.length; r++) {
            rooms.add(new Room(roomCode[r], roomCapacity[r]));
        }

        // creating a bookingApp object with objects created above
        BookingApp bookingApp = new BookingApp(assistants, rooms);

        // calling function initializeData to initialize data (for section 1.3)
        bookingApp.initializeData();

        // calling function mainMenu to print out the main menu to the console
        bookingApp.mainMenu();
    }
}
