public class Assistant {
    // private instance variables
    private String universityEmail;
    private String name;
    private int seqID;

    /**
     * constructor for initialising assistants
     * 
     * @param name the name of assistant to be registered
     * @param universityEmail the university email of assistant to be registered 
     */
    public Assistant(String name, String universityEmail) {
        // checking if parameter name is null
        if (name != null) {
            this.name = name;
            // checking if the passed parameter universityEmail follows the pattern "*@uok.ac.uk"
            if (universityEmail.endsWith("@uok.ac.uk")) {
                this.universityEmail = universityEmail;
            }
        }
    }

    // public getters and setters for private instances
    /**
     * @param seqID the sequential ID of assistants to be set (starting from 11)
     */
    public void setSeqID(int seqID) {
        this.seqID = seqID;
    }

    /**
     * @return the university email of the assistant
     */
    public String getUniversityEmail() {
        return universityEmail;
    }

    /**
     * @return the name of the assistant
     */
    public String getName() {
        return name;
    }

    /**
     * @return the sequential ID of the assistant
     */
    public int getSeqID() {
        return seqID;
    }

    /**
     * @return the print template for the assistant
     */
    public String getAssistants() {
        return "| " + name + " | " + universityEmail + " |";
    }
}
