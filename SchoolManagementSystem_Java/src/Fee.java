public class Fee {
    private int id, studentId;
    private double amount, paid;
    private String feeType, dueDate, paymentDate, remarks;

    public Fee(int id, int studentId, double amount, double paid,
               String feeType, String dueDate, String paymentDate, String remarks) {
        this.id=id; this.studentId=studentId; this.amount=amount; this.paid=paid;
        this.feeType=feeType; this.dueDate=dueDate; this.paymentDate=paymentDate;
        this.remarks=remarks;
    }
    public int getId(){return id;} public int getStudentId(){return studentId;}
    public double getAmount(){return amount;} public double getPaid(){return paid;}
    public String getFeeType(){return feeType;} public String getDueDate(){return dueDate;}
    public String getPaymentDate(){return paymentDate;} public String getRemarks(){return remarks;}
    public double getBalance(){return Math.max(0, amount-paid);}
    public String toString(){
        return id+" | Student "+studentId+" | "+feeType+" | Amount: "+amount+
                " | Paid: "+paid+" | Balance: "+getBalance()+" | Due: "+dueDate;
    }
}
