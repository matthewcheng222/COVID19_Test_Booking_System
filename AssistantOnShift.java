public class AssistantOnShift {
    // private instance variables
    private Assistant assistants;
    private String status;
    private int seqID;
    private String timeSlot;

    /**
     * constructor for initialising assistant on shift
     * 
     * @param assistants the assistant to be initialised 
     * @param timeSlot the time slot to be initialised
     */
    public AssistantOnShift(Assistant assistants, String timeSlot) {
        this.assistants = assistants;
        this.timeSlot = timeSlot;
        // setting the status of assistant on shift to be FREE when created
        this.status = "FREE";
    }

    // public getters and setters for private instances 

    /**
     * @param status the status of assistant on shift to be set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @param seqID the sequential ID of assistant on shift to be set
     */
    public void setSeqID(int seqID) {
        this.seqID = seqID;
    }

    /**
     * @return the status of assistant on shift
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the sequential ID of assistant on shift
     */
    public int getSeqID() {
        return seqID;
    }

    /**
     * @return the assistant of assistant on shift
     */
    public Assistant getAssistants() {
        return assistants;
    }

    /**
     * @return the time slot of assistant on shift
     */
    public String getTimeSlot() {
        return timeSlot;
    }

    /**
     * @return the print template of assistant on shift
     */
    public String getAssistantOnShift() {
        return "| " + timeSlot + " | " + status + " | " + assistants.getUniversityEmail() + " |";
    }
}
