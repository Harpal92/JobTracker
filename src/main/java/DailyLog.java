package Jobtracker.demo.src.main.java;




public class DailyLog {
    private int userId;
    private String  logdate;
    private String  topic;
   private double  hourspent;
   private String notes;
   
    public DailyLog(int userId, String logdate,String topic , double hourspent,String notes){
        this.userId=userId;
        this.logdate=logdate;
        this.topic=topic;
        this.hourspent=hourspent;
        this.notes=notes;

    }
    public int getUserId() {
        return userId;
    }
    public String getLogdate() {
        return logdate;
    }
    public String getTopic() {
        return topic;
    }
    public double getHourspent() {
        return hourspent;
    }
    public String getNotes() {
        return notes;
    }
}
