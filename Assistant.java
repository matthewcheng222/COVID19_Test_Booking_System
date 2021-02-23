public class Assistant {
    private String universityEmail;
    private String name;
    private int seqID;

    public Assistant(String name, String universityEmail) {
        if (name != null) {
            this.name = name;
            if (universityEmail.endsWith("@uok.ac.uk")) {
                this.universityEmail = universityEmail;
            }
        }
    }

    public String getUniversityEmail() {
        return universityEmail;
    }

    public String getName() {
        return name;
    }

    public void setSeqID(int seqID) {
        this.seqID = seqID;
    }

    public int getSeqID() {
        return seqID;
    }

    public String getAssistants() {
        return "| " + name + " | " + universityEmail + " |";
    }
}
