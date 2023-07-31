package team.model.enumFormat;

public enum StudentFormat {
    OFFLINE("OFFLINE"),
    ONLINE("ONLINE");
    private String format;

    StudentFormat(String format) {
        this.format = format;
    }
}