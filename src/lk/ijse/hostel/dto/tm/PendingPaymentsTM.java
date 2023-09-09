package lk.ijse.hostel.dto.tm;

public class PendingPaymentsTM {
    private String resId;
    private String studentId;
    private String name;
    private String contact;

    public PendingPaymentsTM() {
    }

    public PendingPaymentsTM(String resId, String studentId, String name, String contact) {
        this.resId = resId;
        this.studentId = studentId;
        this.name = name;
        this.contact = contact;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "PendingPaymentsTM{" +
                "resId='" + resId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
