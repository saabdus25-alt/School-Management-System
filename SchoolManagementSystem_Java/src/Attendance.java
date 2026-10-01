public class Attendance {
    private int id, studentId, subjectId;
    private String date;
    private boolean present;
    private String remarks;

    public Attendance(int id, int studentId, int subjectId, String date,
                      boolean present, String remarks) {
        this.id=id; this.studentId=studentId; this.subjectId=subjectId;
        this.date=date; this.present=present; this.remarks=remarks;
    }
    public int getId(){return id;} public int getStudentId(){return studentId;}
    public int getSubjectId(){return subjectId;} public String getDate(){return date;}
    public boolean isPresent(){return present;} public String getRemarks(){return remarks;}
    public String toString(){
        return id+" | Student "+studentId+" | Subject "+subjectId+" | "+date+" | "+
                (present?"PRESENT":"ABSENT")+" | "+remarks;
    }
}
