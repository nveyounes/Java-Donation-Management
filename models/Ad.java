package models;

public class Ad {
    private int id;
    private String title;
    private String description;
    private String targetAudience;

    public Ad(int id, String title, String description, String targetAudience) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.targetAudience = targetAudience;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getTargetAudience() { return targetAudience; }
    public void setTargetAudience(String targetAudience) { this.targetAudience = targetAudience; }
}
