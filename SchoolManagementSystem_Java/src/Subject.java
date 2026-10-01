public class Subject {
    private int id;
    private String code, name, className, teacherName;
    private int fullMarks;

    public Subject(int id, String code, String name, String className,
                   String teacherName, int fullMarks) {
        this.id=id; this.code=code; this.name=name; this.className=className;
        this.teacherName=teacherName; this.fullMarks=fullMarks;
    }
    public int getId(){return id;} public String getCode(){return code;}
    public String getName(){return name;} public String getClassName(){return className;}
    public String getTeacherName(){return teacherName;} public int getFullMarks(){return fullMarks;}
    public String toString(){
        return id+" | "+code+" | "+name+" | Class "+className+" | Teacher: "+teacherName+" | Marks: "+fullMarks;
    }
}
