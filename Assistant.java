public class Assistant {
    private String universityEmail;
    private String name;

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

    public String getAssistants() {
        return "| " + name + " | " + universityEmail + " |";
    }
}
