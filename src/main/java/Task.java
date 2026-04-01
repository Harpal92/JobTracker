package Jobtracker.demo.src.main.java;

public class Task {
   
    private String title;
    private String  description;
    private String  status;
    private String  date;
    private int userId;
    public Task(String title, String description,String status,String date,int userId){
        this.title=title;
        this.description=description;
        this.status=status;
        this.date=date;
        this.userId=userId;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }
    public String getDate() {
        return date;
    }public int getUserId() {
        return userId;
    }

     
}
