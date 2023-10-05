package domain;

public class SearchDoctors {
    private int id;
    private String doctorName;
    private String  doctorRegistrationNumber;
     private String qualification;
     private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorRegistrationNumber() {
        return doctorRegistrationNumber;
    }

    public void setDoctorRegistrationNumber(String doctorRegistrationNumber) {
        this.doctorRegistrationNumber = doctorRegistrationNumber;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public SearchDoctors getDoctorByName(String doctorName) {
        return  null;
    }



    public SearchDoctors getDoctorByRegistrationNumber(String doctorName) {
        return null;
    }
}
