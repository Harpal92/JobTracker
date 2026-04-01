package Jobtracker.demo.src.main.java.com.example;

import java.util.List;
//import java.util.Scanner;
import java.util.Scanner;

import Jobtracker.demo.src.main.java.DailyLog;
import Jobtracker.demo.src.main.java.DailyLogDAO;
import Jobtracker.demo.src.main.java.Task;
//import Jobtracker.demo.src.main.java.User;
import Jobtracker.demo.src.main.java.com.JobApplicationDAO;
import Jobtracker.demo.src.main.java.com.TaskDAO;

public class Main {
    
   
    public static void main(String[] args) {
         DBconnection.getConnection();
         JobApplicationDAO jobDao = new JobApplicationDAO();
         TaskDAO taskDao=new TaskDAO();
         DailyLogDAO dailylogDAO=new DailyLogDAO();
        Scanner sc=new Scanner(System.in);
       
        int choice;
        do{
             System.out.println("====================");
        System.out.println("     JOB TRACKER   ");
        System.out.println("====================");
        System.out.println( "1 JOB APPLICATION");
        System.out.println( "2 TASK");
        System.out.println(" 3 LEARNING Log");
        System.out.println ("0 EXIT");
        System.out.print("ENTER CHOICE");
        choice=sc.nextInt();
        switch (choice) {
                     case 1:
                    JobApplicationMenu( sc,   jobDao);
                     break;
                    case 2:
                    taskMenu( sc,  taskDao);
                    break;
                    case 3:
                        dailyLogMenu(sc,dailylogDAO);
                        break;
                       case 0:
                        System.out.println("Exiting...");
                         break;
                          default: 
                  System.out.println("invalid choice try again");
        }

        }
         while (choice !=0);  
         
    }

         
        //  User user = new User("Harpal", "harpal@gmail.com", "1234");

        // UserDAO dao = new UserDAO();
        // int id=dao.addUser(user);
         // JobApplication  jobApplication=new JobApplication( "Amazon", "softwaredeveloper", "2023-02-01", "2023-02-10", "Applied",id);
//          JobApplicationDAO jobDao = new JobApplicationDAO();
//         // jobDao.addJobApplication(jobApplication);
        

//         List<JobApplication> jobs = jobDao.getAllJobs();

//  for (JobApplication job : jobs) {
//      System.out.println(job.getCompanyname() + " " + job.getRole());
//  }
// List<JobApplication> joBs = jobDao.getJobsByStatus("Applied");

private static void dailyLogMenu(Scanner sc, DailyLogDAO dailylogDAO) {
       int choice;
       do {
        System.out.println("====================");
        System.out.println("    DAILY LOG MENU    ");
        System.out.println("====================");
        System.out.println( "1 ADD LOG");
        System.out.println( "2 VIEW ALL LOGS");
        System.out.println( "3 DELETE LOG");
        System.out.println("0 exit");
        System.out.print("enter choice");
        choice=sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                addLog(sc,dailylogDAO);
                break;
                case 2:
                    viewallLogs(dailylogDAO);
                    break;
                case 3:
                  deleteLog(sc,dailylogDAO);
                    break;
        
               case 0:
              System.out.println("Exiting...");
                    break;
                     default: 
            System.out.println("invalid choice try again");

        }
        } while (choice !=0);
       }
    


private static void deleteLog(Scanner sc, DailyLogDAO dailylogDAO) {
     System.out.println("TELL ID TO DELETE");
        int id=sc.nextInt();
       dailylogDAO.deleteLog(id);
}


private static void viewallLogs(DailyLogDAO dailylogDAO) {
    List<DailyLog> logs = dailylogDAO.getAllLogs();
                 for (DailyLog log : logs) {
     System.out.println(log.getUserId() + " " + log.getLogdate() + " " + log.getTopic() + " " + log.getHourspent() + " " + log.getNotes());
 }
}


private static void addLog(Scanner sc, DailyLogDAO dailylogDAO) {
    System.out.println("ADD NEW TASK");
        System.out.print("Enter UserId    : ");
         int userid = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Logdate : ");
        String logdate = sc.nextLine();
        System.out.print("Enter topic    : ");
        String topic = sc.nextLine();
        System.out.print("Enter hoursspent : ");
        double hoursspent = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter notes : ");
        String notes = sc.nextLine();
       DailyLog dailylog=new DailyLog(userid, logdate, topic, hoursspent, notes);
        dailylogDAO.addLog(dailylog);
        System.out.println("LOG ADDED SUCCESSFULLY");
}


private static void taskMenu(Scanner sc, TaskDAO taskDao) {
        int choice;
         do {
        System.out.println("====================");
        System.out.println("     TASK MENU    ");
        System.out.println("====================");
        System.out.println( "1 ADD TASK");
        System.out.println( "2 VIEW ALL TASK");
        System.out.println( "3 UPDATE STATUS");
        System.out.println("4 DELETE TASK");
        System.out.println("0 exit");
        System.out.print("enter choice");
        choice=sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                addTask(sc,taskDao);
                break;
                case 2:
                    viewallTask(taskDao);
                    break;
                    
            case 3:
                   updatetaskstatus(sc,taskDao);
                    break;
          case 4:
                  deleteTask(sc,taskDao);
                    break;
        
         case 0:
            System.out.println("Exiting...");
                    break;
                     default: 
            System.out.println("invalid choice try again");

                
        }
       } while (choice !=0);

    }
    


      private static void deleteTask(Scanner sc, TaskDAO taskDao) {
    System.out.println("TELL ID TO DELETE");
        int id=sc.nextInt();
       taskDao.deleteTask(id);
       
}


      private static void updatetaskstatus(Scanner sc, TaskDAO taskDao) {
           System.out.println("TELL ID ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new status Pending/Completed)") ;
        String status = sc.nextLine();
       
        
        taskDao.updateTaskStatus(id,status);

}


      private static void viewallTask(TaskDAO taskDao) {
    List<Task> tasks = taskDao.getAllTasks();
                 for (Task task : tasks) {
     System.out.println(task.getTitle() + " " + task.getDescription() + " " + task.getStatus() + " " + task.getDate() + " " + task.getUserId());
 }
}


      private static void addTask(Scanner sc, TaskDAO taskDao) {
        System.out.println("ADD NEW TASK");
        System.out.print("Enter Title    : ");
        String title = sc.nextLine();
        System.out.print("Enter Desc     : ");
        String description = sc.nextLine();
        System.out.print("Enter Status (Pending/Completed) : ");
        String status = sc.nextLine();
        System.out.print("Enter Date (YYYY-MM-DD) : ");
        String date = sc.nextLine();
        System.out.print("Enter UserId   : ");
        int userid = sc.nextInt();
        sc.nextLine();
        Task task=new Task(title, description, status, date, userid);
        
        taskDao.addTask(task);
        System.out.println("TASK ADDED SUCCESSFULLY");
}


      //  for (JobApplication job : joBs) {
//     System.out.println(job.getCompanyname());
// }
// //jobDao.updateStatus(2, "Interview");
//          //dao.getAllUsers();
//         // jobDao.deleteJob(1); 
//        jobDao.deleteJob(99);
      private static void JobApplicationMenu(Scanner sc, JobApplicationDAO  jobDao) {
    

      int choice;
         do {
        System.out.println("====================");
        System.out.println("     JOB APPLICATION    ");
        System.out.println("====================");
        System.out.println( "1 ADD JOB");
        System.out.println( "2 VIEW ALL JOB");
        System.out.println ("3 VIEW JOB BY STATUS");
        System.out.println( "4 UPDATE STATUS");
        System.out.println(" 5 DELETE JOB");
        System.out.println(" 0 exit");
        System.out.println("enter choice");
        choice=sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                addjob(sc,jobDao);
                break;
                case 2:
                    viewalljob(jobDao);
                    break;
                    case 3:
                        viewjobbystatus(sc,jobDao);
                        break;
            case 4:
                   updatejobsstatus(sc,jobDao);
                    break;
          case 5:
                  deletejob(sc,jobDao);
                    break;
        
         case 0:
            System.out.println("Exiting...");
                    break;
                    
        
            default: 
            System.out.println("invalid choice try again");

                
        }
       } while (choice !=0);  
    }
       
        private static void addjob(Scanner sc,JobApplicationDAO jobDao) {
        System.out.print(" TELL COMPANY NAME");
        String companyname=sc.nextLine();
        System.out.print("TELL ROLE");
        String role=sc.nextLine();
        System.out.print("Enter apply date (YYYY-MM-DD)");
        String applydate= sc.nextLine();
         System.out.print("Enter test date (YYYY-MM-DD)");
        String testdate= sc.nextLine();
        System.out.print("Enter new status (Applied/Interview/Rejected/Offer)") ;
        String status = sc.nextLine();
        System.out.print("TELL  USERID ");
        int userid=sc.nextInt();
        sc.nextLine();
        JobApplication job=new JobApplication(companyname, role, applydate, testdate, status, userid);
        
        jobDao.addJobApplication(job);

    }


        private static void viewjobbystatus(Scanner sc,JobApplicationDAO jobDao) {
        System.out.println("Enter  status to filter (Applied/Interview/Rejected/Offer)") ;
        String status = sc.next();
        
         List<JobApplication> jobs = jobDao.getJobsByStatus(status);
                 for (JobApplication job : jobs) {
     System.out.println(job.getCompanyname() + " " + job.getRole() + " " + job.getApplydate() + " " + job.getTestdate() + " " + job.getStatus() + " " + job.getUserId());
 }
}
    


        private static void updatejobsstatus(Scanner sc,JobApplicationDAO jobDao) {
        System.out.println("TELL ID ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new status (Applied/Interview/Rejected/Offer)") ;
        String status = sc.nextLine();
       
        
        jobDao.updateStatus(id,status);

    }


        private static void deletejob( Scanner sc, JobApplicationDAO jobDao) {
            
        System.out.println("TELL ID TO DELETE");
        int id=sc.nextInt();
       
        jobDao.deleteJob(id);

    }


        private static void viewalljob(JobApplicationDAO jobDao ) {
        
           List<JobApplication> jobs = jobDao.getAllJobs();
                 for (JobApplication job : jobs) {
     System.out.println(job.getCompanyname() + " " + job.getRole() + " " + job.getApplydate() + " " + job.getTestdate() + " " + job.getStatus() + " " + job.getUserId());
 }

    }


        
    }

