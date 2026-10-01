import java.util.ArrayList;
import java.util.List;

public class SchoolManager {
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();
    private List<Attendance> attendance = new ArrayList<>();
    private List<Result> results = new ArrayList<>();
    private List<Fee> fees = new ArrayList<>();
    private int studentId = 1001, teacherId = 501, subjectId = 1, attendanceId = 1, resultId = 1, feeId = 1;

    public Student addStudent(String name, String gender, String dob, String phone, String email,
            String address, String cls, String section, String date) {
        Student s = new Student(studentId++, name, gender, dob, phone, email, address, cls, section, date);
        students.add(s);
        return s;
    }

    public Teacher addTeacher(String name, String gender, String phone, String email, String address,
            String subject, String qualification, String date) {
        Teacher t = new Teacher(teacherId++, name, gender, phone, email, address, subject, qualification, date);
        teachers.add(t);
        return t;
    }

    public Subject addSubject(String code, String name, String cls, String teacher, int marks) {
        Subject s = new Subject(subjectId++, code, name, cls, teacher, marks);
        subjects.add(s);
        return s;
    }

    public Attendance addAttendance(int sid, int subid, String date, boolean present, String remarks) {
        Attendance a = new Attendance(attendanceId++, sid, subid, date, present, remarks);
        attendance.add(a);
        return a;
    }

    public Result addResult(int sid, int subid, double marks, String exam, String date) {
        Result r = new Result(resultId++, sid, subid, marks, exam, date);
        results.add(r);
        return r;
    }

    public Fee addFee(int sid, double amount, double paid, String type, String due, String payment, String remarks) {
        Fee f = new Fee(feeId++, sid, amount, paid, type, due, payment, remarks);
        fees.add(f);
        return f;
    }

    public Student findStudent(int id) {
        for (Student s : students)
            if (s.getId() == id)
                return s;
        return null;
    }

    public Teacher findTeacher(int id) {
        for (Teacher t : teachers)
            if (t.getId() == id)
                return t;
        return null;
    }

    public Subject findSubject(int id) {
        for (Subject s : subjects)
            if (s.getId() == id)
                return s;
        return null;
    }

    public List<Student> searchStudents(String key) {
        List<Student> r = new ArrayList<>();
        key = key.toLowerCase();
        for (Student s : students)
            if (s.getName().toLowerCase().contains(key) ||
                    s.getPhone().contains(key) || s.getClassName().toLowerCase().contains(key))
                r.add(s);
        return r;
    }

    public List<Teacher> searchTeachers(String key) {
        List<Teacher> r = new ArrayList<>();
        key = key.toLowerCase();
        for (Teacher t : teachers)
            if (t.getName().toLowerCase().contains(key) ||
                    t.getSubject().toLowerCase().contains(key) || t.getPhone().contains(key))
                r.add(t);
        return r;
    }

    public List<Result> studentResults(int id) {
        List<Result> r = new ArrayList<>();
        for (Result x : results)
            if (x.getStudentId() == id)
                r.add(x);
        return r;
    }

    public List<Attendance> studentAttendance(int id) {
        List<Attendance> r = new ArrayList<>();
        for (Attendance x : attendance)
            if (x.getStudentId() == id)
                r.add(x);
        return r;
    }

    public List<Fee> studentFees(int id) {
        List<Fee> r = new ArrayList<>();
        for (Fee x : fees)
            if (x.getStudentId() == id)
                r.add(x);
        return r;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }

    public List<Subject> getSubjects() {
        return new ArrayList<>(subjects);
    }

    public List<Attendance> getAttendance() {
        return new ArrayList<>(attendance);
    }

    public List<Result> getResults() {
        return new ArrayList<>(results);
    }

    public List<Fee> getFees() {
        return new ArrayList<>(fees);
    }

    public int studentCount() {
        return students.size();
    }

    public int teacherCount() {
        return teachers.size();
    }

    public int subjectCount() {
        return subjects.size();
    }

    public int attendanceCount() {
        return attendance.size();
    }

    public int resultCount() {
        return results.size();
    }

    public int feeCount() {
        return fees.size();
    }

    public double totalFee() {
        double x = 0;
        for (Fee f : fees)
            x += f.getAmount();
        return x;
    }

    public double totalPaid() {
        double x = 0;
        for (Fee f : fees)
            x += f.getPaid();
        return x;
    }

    public double totalDue() {
        return totalFee() - totalPaid();
    }

    public void seed() {
        if (!students.isEmpty())
            return;
        addStudent("Aarav Sharma", "Male", "2008-05-10", "9800000001", "aarav@mail.com", "Kathmandu", "10", "A",
                "2026-04-01");
        addStudent("Sita Thapa", "Female", "2009-02-15", "9800000002", "sita@mail.com", "Lalitpur", "9", "B",
                "2026-04-02");
        addTeacher("Ram Karki", "Male", "9810000001", "ram@school.com", "Kathmandu", "Mathematics", "M.Ed",
                "2025-04-01");
        addTeacher("Mina Gurung", "Female", "9810000002", "mina@school.com", "Lalitpur", "Science", "M.Sc",
                "2025-04-01");
        addSubject("MATH101", "Mathematics", "10", "Ram Karki", 100);
        addSubject("SCI101", "Science", "10", "Mina Gurung", 100);
        addAttendance(1001, 1, "2026-09-01", true, "On time");
        addAttendance(1001, 2, "2026-09-01", true, "On time");
        addResult(1001, 1, 85, "First Terminal", "2026-09-20");
        addResult(1001, 2, 78, "First Terminal", "2026-09-20");
        addFee(1001, 25000, 20000, "Annual Fee", "2026-10-15", "2026-09-10", "Partial payment");
    }
}
