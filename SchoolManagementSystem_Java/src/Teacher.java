public class Teacher {
    private int id;
    private String name, gender, phone, email, address, subject, qualification, joinDate;
    private boolean active;

    public Teacher(int id, String name, String gender, String phone, String email,
                   String address, String subject, String qualification, String joinDate) {
        this.id=id; this.name=name; this.gender=gender; this.phone=phone;
        this.email=email; this.address=address; this.subject=subject;
        this.qualification=qualification; this.joinDate=joinDate; this.active=true;
    }
    public int getId(){return id;} public String getName(){return name;}
    public String getGender(){return gender;} public String getPhone(){return phone;}
    public String getEmail(){return email;} public String getAddress(){return address;}
    public String getSubject(){return subject;} public String getQualification(){return qualification;}
    public String getJoinDate(){return joinDate;} public boolean isActive(){return active;}
    public void setName(String v){name=v;} public void setPhone(String v){phone=v;}
    public void setEmail(String v){email=v;} public void setAddress(String v){address=v;}
    public void setSubject(String v){subject=v;} public void setQualification(String v){qualification=v;}
    public void setActive(boolean v){active=v;}
    public String toString(){
        return id+" | "+name+" | "+subject+" | "+qualification+" | "+phone+" | "+(active?"ACTIVE":"INACTIVE");
    }
}
