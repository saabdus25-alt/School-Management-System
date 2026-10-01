import java.util.List;

public class ReportManager {
    private void line(){System.out.println("==============================================================");}
    public void students(List<Student> list){
        line(); System.out.println("STUDENT LIST"); line();
        for(Student s:list)System.out.println(s);
        if(list.isEmpty())System.out.println("No students found.");
    }
    public void teachers(List<Teacher> list){
        line(); System.out.println("TEACHER LIST"); line();
        for(Teacher t:list)System.out.println(t);
        if(list.isEmpty())System.out.println("No teachers found.");
    }
    public void subjects(List<Subject> list){
        line(); System.out.println("SUBJECT LIST"); line();
        for(Subject s:list)System.out.println(s);
        if(list.isEmpty())System.out.println("No subjects found.");
    }
    public void dashboard(SchoolManager m){
        line(); System.out.println("SCHOOL MANAGEMENT DASHBOARD"); line();
        System.out.println("Students       : "+m.studentCount());
        System.out.println("Teachers       : "+m.teacherCount());
        System.out.println("Subjects       : "+m.subjectCount());
        System.out.println("Attendance     : "+m.attendanceCount());
        System.out.println("Result Records : "+m.resultCount());
        System.out.println("Fee Records    : "+m.feeCount());
        System.out.printf("Total Fee      : Rs. %.2f%n",m.totalFee());
        System.out.printf("Total Paid     : Rs. %.2f%n",m.totalPaid());
        System.out.printf("Total Due      : Rs. %.2f%n",m.totalDue());
        line();
    }
    public void studentReport(int id,SchoolManager m){
        Student s=m.findStudent(id);
        if(s==null){System.out.println("Student not found.");return;}
        line();System.out.println("STUDENT REPORT");line();
        System.out.println("Student: "+s);
        System.out.println("\nAttendance:");
        for(Attendance a:m.studentAttendance(id))System.out.println(a);
        System.out.println("\nResults:");
        for(Result r:m.studentResults(id)){
            Subject sub=m.findSubject(r.getSubjectId());
            int full=sub==null?100:sub.getFullMarks();
            System.out.println(r+" | Grade: "+r.grade(full));
        }
        System.out.println("\nFees:");
        for(Fee f:m.studentFees(id))System.out.println(f);
        line();
    }
    public void fees(List<Fee> list){
        line();System.out.println("FEE REPORT");line();
        for(Fee f:list)System.out.println(f);
        if(list.isEmpty())System.out.println("No fee records.");
    }
    public void attendance(List<Attendance> list){
        line();System.out.println("ATTENDANCE REPORT");line();
        for(Attendance a:list)System.out.println(a);
        if(list.isEmpty())System.out.println("No attendance records.");
    }
    public void results(List<Result> list){
        line();System.out.println("RESULT REPORT");line();
        for(Result r:list)System.out.println(r);
        if(list.isEmpty())System.out.println("No result records.");
    }
}
