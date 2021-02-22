import java.util.ArrayList;
import java.util.Scanner;

public class BookingApp {
    private ArrayList<Assistant> assistants;
    private ArrayList<Room> rooms;
    private ArrayList<BookingSystem> bookingSystems;


    public BookingApp(ArrayList<Assistant> assistants, ArrayList<Room> rooms) {
        this.assistants = assistants;
        this.rooms = rooms;
    }

    public void mainMenu() {
        int selection;
        Scanner input = new Scanner(System.in);

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
                System.out.println("Invalid selection - please select a valid option from the menu.");
        }
        input.close();
    }

    public void listBookableRooms() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("<list bookable rooms>");
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

    public void addBookableRooms() {
        String selection;
        int lr = 11;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("Adding bookable room");
        System.out.println("");
        System.out.println("List of Rooms:");
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

        selection = input.next();

        if (selection.equals("0")) {
            mainMenu();
        }
        else if (selection.equals("-1")) {
            System.exit(1);
        }
        else {
            int selectedID;
            String date;
            String time;
            String[] splitString = selection.split(" ");
            selectedID = Integer.parseInt(splitString[0]);
            date = splitString[1];
            time = splitString[2];
        }

        input.close(); 
    }

    public void addBookableRoomsValidInput() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Bookable Room added successfully:");
        System.out.println("<print bookable room>");
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

    public void addBookableRoomsInvalidInput() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Error!");
        System.out.println("<message explaining the error>");
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

    public void removeBookableRooms() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("<list bookable rooms status:EMPTY>");
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

        input.close();
    }

    public void listAssistantOnShift() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("<list assistant on shifts>");
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
        int selection;
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
        System.out.println("<list assistant on shifts status:FREE>");
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
                System.out.println();
                break;
            case 2:
                System.out.println();
                break;
            case 3:
                System.out.println();
                break;
            case 0:
                mainMenu();
                break;
            case -1:
                System.exit(1);
                break;
            default:
                break;
        }

        input.close();
    }

    public void addBooking() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
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
        System.out.println("<list booking status:SCHEDULED>");
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

        input.close();
    }

    public void concludeBooking() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("<list booking status:SCHEDULED>");
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

        input.close();
    }
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
