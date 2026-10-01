import java.util.Scanner;

public class SchoolUI {
    private Scanner sc; private SchoolManager m; private ReportManager report=new ReportManager();
    public SchoolUI(Scanner sc,SchoolManager m){this.sc=sc;this.m=m;}
    public void start(){
        m.seed(); boolean run=true;
        while(run){
            menu(); int c=intValue("Choice: ");
            switch(c){
                case 1:addStudent();break; case 2:report.students(m.getStudents());break;
                case 3:searchStudent();break; case 4:addTeacher();break;
                case 5:report.teachers(m.getTeachers());break; case 6:searchTeacher();break;
                case 7:addSubject();break; case 8:report.subjects(m.getSubjects());break;
                case 9:addAttendance();break; case 10:report.attendance(m.getAttendance());break;
                case 11:addResult();break; case 12:report.results(m.getResults());break;
                case 13:addFee();break; case 14:report.fees(m.getFees());break;
                case 15:studentReport();break; case 16:report.dashboard(m);break;
                case 0:run=false;System.out.println("Goodbye!");break;
                default:System.out.println("Invalid choice.");
            }
            if(run)pause();
        }
    }
    private void menu(){
        System.out.println("\n==============================================================");
        System.out.println("              SCHOOL MANAGEMENT SYSTEM");
        System.out.println("==============================================================");
        System.out.println("1. Add Student          2. View Students");
        System.out.println("3. Search Student       4. Add Teacher");
        System.out.println("5. View Teachers        6. Search Teacher");
        System.out.println("7. Add Subject          8. View Subjects");
        System.out.println("9. Record Attendance   10. Attendance Report");
        System.out.println("11. Add Result         12. Result Report");
        System.out.println("13. Add Fee            14. Fee Report");
        System.out.println("15. Student Full Report");
        System.out.println("16. School Dashboard");
        System.out.println("0. Exit");
        System.out.println("--------------------------------------------------------------");
    }
    private void addStudent(){
        System.out.println("\n--- ADD STUDENT ---");
        Student s=m.addStudent(req("Name: "),req("Gender: "),req("DOB: "),req("Phone: "),
            req("Email: "),req("Address: "),req("Class: "),req("Section: "),req("Admission Date: "));
        System.out.println("Student added. ID = "+s.getId());
    }
    private void searchStudent(){report.students(m.searchStudents(req("Search name/phone/class: "))); }
    private void addTeacher(){
        System.out.println("\n--- ADD TEACHER ---");
        Teacher t=m.addTeacher(req("Name: "),req("Gender: "),req("Phone: "),req("Email: "),
            req("Address: "),req("Subject: "),req("Qualification: "),req("Join Date: "));
        System.out.println("Teacher added. ID = "+t.getId());
    }
    private void searchTeacher(){report.teachers(m.searchTeachers(req("Search name/subject/phone: "))); }
    private void addSubject(){
        Subject s=m.addSubject(req("Code: "),req("Subject name: "),req("Class: "),
            req("Teacher name: "),intValue("Full marks: "));
        System.out.println("Subject added. ID = "+s.getId());
    }
    private void addAttendance(){
        int sid=intValue("Student ID: "), sub=intValue("Subject ID: ");
        String date=req("Date: "); boolean present=req("Present? (Y/N): ").equalsIgnoreCase("Y");
        m.addAttendance(sid,sub,date,present,req("Remarks: "));
        System.out.println("Attendance recorded.");
    }
    private void addResult(){
        int sid=intValue("Student ID: "), sub=intValue("Subject ID: ");
        double marks=doubleValue("Marks: "); String exam=req("Exam name: "),date=req("Date: ");
        Subject subject=m.findSubject(sub);
        if(subject==null){System.out.println("Subject not found.");return;}
        if(marks<0||marks>subject.getFullMarks()){System.out.println("Marks out of range.");return;}
        Result r=m.addResult(sid,sub,marks,exam,date);
        System.out.println("Result added. Grade = "+r.grade(subject.getFullMarks()));
    }
    private void addFee(){
        int sid=intValue("Student ID: "); double amount=doubleValue("Amount: ");
        double paid=doubleValue("Paid: ");
        if(paid<0||paid>amount){System.out.println("Invalid paid amount.");return;}
        m.addFee(sid,amount,paid,req("Fee type: "),req("Due date: "),
            req("Payment date: "),req("Remarks: "));
        System.out.println("Fee record added.");
    }
    private void studentReport(){report.studentReport(intValue("Student ID: "),m);}
    private String req(String msg){while(true){System.out.print(msg);String s=sc.nextLine().trim();if(!s.isEmpty())return s;System.out.println("Required.");}}
    private int intValue(String msg){while(true){System.out.print(msg);try{return Integer.parseInt(sc.nextLine().trim());}catch(Exception e){System.out.println("Enter a valid number.");}}}
    private double doubleValue(String msg){while(true){System.out.print(msg);try{return Double.parseDouble(sc.nextLine().trim());}catch(Exception e){System.out.println("Enter a valid number.");}}}
    private void pause(){System.out.println("\nPress ENTER to continue...");sc.nextLine();}
}
