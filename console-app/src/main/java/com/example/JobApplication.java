package com.example;

public class JobApplication {
     /**
     *
     */
    private int userId;
    private String Companyname;
    private String  role;
    private String  applydate;
     private String  testdate;
     private  String status;
     public JobApplication(String Companyname, String role, String applydate,String testdate, String status,int userId) {
        this.Companyname = Companyname;
        this.role = role;
        this.applydate = applydate;
        this.testdate=testdate;
        this.status=status;
        this.userId=userId;
    }
   
 
  public String getCompanyname() {
      return Companyname;
  }
  public String getRole() {
      return role;
  }
   public String getApplydate() {
      return applydate;
  }
  public String getStatus() {
      return status;
  }
  public String getTestdate() {
      return testdate;
  }
  public int getUserId() {
    return userId;
}

}
