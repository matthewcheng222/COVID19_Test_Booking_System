public class AssistantOnShift {
    private Assistant assistants;
    private String status;
    private int seqID;
    private String timeSlot;

    public AssistantOnShift(Assistant assistants, String timeSlot) {
        this.assistants = assistants;
        this.timeSlot = timeSlot;
        this.status = "FREE";
    }

    public void setStatusFree(String status) {
        this.status = "FREE";
    }

    public void setStatusBusy(String status) {
        this.status = "BUSY";
    }

    public void setSeqID(int seqID) {
        this.seqID = seqID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSeqID() {
        return seqID;
    }

    public String getAssistantOnShift() {
        return "| " + timeSlot + " | " + status + " | " + assistants.getUniversityEmail() + " |";
    }
}
