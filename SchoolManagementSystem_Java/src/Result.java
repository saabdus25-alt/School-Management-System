public class Result {
    private int id, studentId, subjectId;
    private double marks;
    private String examName, date;

    public Result(int id, int studentId, int subjectId, double marks,
                  String examName, String date) {
        this.id=id; this.studentId=studentId; this.subjectId=subjectId;
        this.marks=marks; this.examName=examName; this.date=date;
    }
    public int getId(){return id;} public int getStudentId(){return studentId;}
    public int getSubjectId(){return subjectId;} public double getMarks(){return marks;}
    public String getExamName(){return examName;} public String getDate(){return date;}

    public String grade(int fullMarks) {
        double p = marks * 100.0 / fullMarks;
        if(p>=80) return "A+";
        if(p>=70) return "A";
        if(p>=60) return "B+";
        if(p>=50) return "B";
        if(p>=40) return "C";
        if(p>=32) return "D";
        return "F";
    }
    public String toString(){
        return id+" | Student "+studentId+" | Subject "+subjectId+" | "+
                examName+" | "+marks+" | "+date;
    }
}
