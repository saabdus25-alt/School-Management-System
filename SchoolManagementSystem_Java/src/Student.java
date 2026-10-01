public class Student {
    private int id;
    private String name, gender, dob, phone, email, address, className, section, admissionDate;
    private boolean active;

    public Student(int id, String name, String gender, String dob, String phone,
                   String email, String address, String className,
                   String section, String admissionDate) {
        this.id = id; this.name = name; this.gender = gender; this.dob = dob;
        this.phone = phone; this.email = email; this.address = address;
        this.className = className; this.section = section;
        this.admissionDate = admissionDate; this.active = true;
    }
    public int getId(){return id;} public String getName(){return name;}
    public String getGender(){return gender;} public String getDob(){return dob;}
    public String getPhone(){return phone;} public String getEmail(){return email;}
    public String getAddress(){return address;} public String getClassName(){return className;}
    public String getSection(){return section;} public String getAdmissionDate(){return admissionDate;}
    public boolean isActive(){return active;}
    public void setName(String v){name=v;} public void setPhone(String v){phone=v;}
    public void setEmail(String v){email=v;} public void setAddress(String v){address=v;}
    public void setClassName(String v){className=v;} public void setSection(String v){section=v;}
    public void setActive(boolean v){active=v;}
    public String toString(){
        return id+" | "+name+" | Class "+className+"-"+section+" | "+phone+" | "+(active?"ACTIVE":"INACTIVE");
    }
}
