package com.example;

import java.util.List;

import java.util.Scanner;

public class Main {
    
   
    public static void main(String[] args) {
         DBconnection.getConnection();
         UserDAO userDAO=new UserDAO();
         JobApplicationDAO jobDao = new JobApplicationDAO();
         TaskDAO taskDao=new TaskDAO();
         DailyLogDAO dailylogDAO=new DailyLogDAO();
        Scanner sc=new Scanner(System.in);
        authMenu( sc, userDAO,jobDao,taskDao,dailylogDAO);
        
       }

         
      


private static void authMenu(Scanner sc, UserDAO userDAO, JobApplicationDAO jobDao,TaskDAO taskDao,DailyLogDAO dailylogDAO) {
        int choice;
        do{
             System.out.println("====================");
        
        System.out.println("     JOB TRACKER   ");
        System.out.println("====================");
        System.out.println( "1 REGISTER");
        System.out.println( "2 LOGIN");
        System.out.println ("0 EXIT");
        System.out.print("ENTER CHOICE ");
        choice=sc.nextInt();
        sc.nextLine();
       
        switch (choice) {
            case 1:
                addUser(sc,userDAO);
                break;
                case 2:
                    Login(sc,userDAO,jobDao,taskDao,dailylogDAO);
                    break;
        
               case 0:
              System.out.println("Exiting...");
                    break;
                     default: 
            System.out.println("invalid choice try again");

        }
        } while (choice !=0);
    }


 private static void Login(Scanner sc, UserDAO userDAO, JobApplicationDAO jobDao, TaskDAO taskDao, DailyLogDAO dailylogDAO) {
     
        System.out.print("Enter Email    : ");
         String Email = sc.nextLine();
        System.out.print("Enter Password : ");
        String Password = sc.nextLine();
        User a=userDAO.login(Email,Password);
        if(a==null) System.out.println("Invalid credentials");
        else mainmenu(sc, jobDao, taskDao, dailylogDAO, a.getId());
}



        
              





private static void mainmenu(Scanner sc, JobApplicationDAO jobDao, TaskDAO taskDao, DailyLogDAO dailylogDAO, int id) {
   int choice;
        do{
             System.out.println("====================");
        
        System.out.println("     JOB TRACKER   ");
        System.out.println("====================");
        System.out.println( "1 JOB APPLICATION");
        System.out.println( "2 TASK");
       System.out.println(" 3 LEARNING Log");
     System.out.println(" 4 STATS");
        
        System.out.println ("0 EXIT");
        System.out.print("ENTER CHOICE ");
        choice=sc.nextInt();
        sc.nextLine();
        switch (choice) {
            
                     case 1:
                    JobApplicationMenu( sc,   jobDao,id);
                     break;
                    case 2:
                    taskMenu( sc,  taskDao,id);
                    break;
                    case 3:
                        dailyLogMenu(sc,dailylogDAO,id);
                        break;
                        case 4:
                         StatsService.showStats(id);
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

         
        



private static void addUser(Scanner sc, UserDAO userDAO) {
  System.out.println("ADD NEW USER ");
        System.out.print("Enter Name    : ");
         String name = sc.nextLine();
        System.out.print("Enter Email : ");
        String email = sc.nextLine();
        System.out.print("Enter Password    : ");
        String Password = sc.nextLine();
        User user=new User(name, email, Password);
        userDAO.addUser(user);
        System.out.println("User ADDED SUCCESSFULLY");
}


private static void dailyLogMenu(Scanner sc, DailyLogDAO dailylogDAO,int id) {
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
                addLog(sc,dailylogDAO,id);
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
     System.out.println("TELL ID TO DELETE ");
        int id=sc.nextInt();
       dailylogDAO.deleteLog(id);
}


private static void viewallLogs(DailyLogDAO dailylogDAO) {
    List<DailyLog> logs = dailylogDAO.getAllLogs();
                 for (DailyLog log : logs) {
     System.out.println(log.getUserId() + " " + log.getLogdate() + " " + log.getTopic() + " " + log.getHourspent() + " " + log.getNotes());
 }
}


private static void addLog(Scanner sc, DailyLogDAO dailylogDAO,int id) {
    System.out.println("ADD NEW TASK");
        
        System.out.print("Enter Logdate : ");
        String logdate = sc.nextLine();
        System.out.print("Enter topic    : ");
        String topic = sc.nextLine();
        System.out.print("Enter hoursspent : ");
        double hoursspent = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter notes : ");
        String notes = sc.nextLine();
       DailyLog dailylog=new DailyLog(id, logdate, topic, hoursspent, notes);
        dailylogDAO.addLog(dailylog);
        System.out.println("LOG ADDED SUCCESSFULLY");
}


private static void taskMenu(Scanner sc, TaskDAO taskDao,int id) {
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
                addTask(sc,taskDao,id);
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
    System.out.println("TELL ID TO DELETE ");
        int id=sc.nextInt();
       taskDao.deleteTask(id);
       
}


      private static void updatetaskstatus(Scanner sc, TaskDAO taskDao) {
           System.out.println("TELL ID ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new status Pending/Completed) ") ;
        String status = sc.nextLine();
       
        
        taskDao.updateTaskStatus(id,status);

}


      private static void viewallTask(TaskDAO taskDao) {
    List<Task> tasks = taskDao.getAllTasks();
                 for (Task task : tasks) {
     System.out.println(task.getTitle() + " " + task.getDescription() + " " + task.getStatus() + " " + task.getDate() + " " + task.getUserId());
 }
}


      private static void addTask(Scanner sc, TaskDAO taskDao,int id) {
        System.out.println("ADD NEW TASK ");
        System.out.print("Enter Title    : ");
        String title = sc.nextLine();
        System.out.print("Enter Desc     : ");
        String description = sc.nextLine();
        System.out.print("Enter Status (Pending/Completed) : ");
        String status = sc.nextLine();
        System.out.print("Enter Date (YYYY-MM-DD) : ");
        String date = sc.nextLine();
        Task task=new Task(title, description, status, date, id);
        
        taskDao.addTask(task);
        System.out.println("TASK ADDED SUCCESSFULLY");
}


      private static void JobApplicationMenu(Scanner sc, JobApplicationDAO  jobDao,int id) {
    

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
        System.out.print("enter choice");
        choice=sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                addjob(sc,jobDao,id);
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
       
        private static void addjob(Scanner sc,JobApplicationDAO jobDao,int id) {
        System.out.print(" TELL COMPANY NAME ");
        String companyname=sc.nextLine();
        System.out.print("TELL ROLE ");
        String role=sc.nextLine();
        System.out.print("Enter apply date (YYYY-MM-DD) ");
        String applydate= sc.nextLine();
         System.out.print("Enter test date (YYYY-MM-DD) ");
        String testdate= sc.nextLine();
        System.out.print("Enter new status (Applied/Interview/Rejected/Offer) ") ;
        String status = sc.nextLine();
       
        JobApplication job=new JobApplication(companyname, role, applydate, testdate, status, id);
        
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

