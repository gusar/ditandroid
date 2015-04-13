package ie.dit.android.dit;

import java.io.Serializable;

public class Courses implements Serializable{

    private static final long serialVersionUID = 5L;

    private String code;
    private String qual;
    private String duration;
    private String places;
    private String location;
    private String desc;
    private String depart;
    private String fo_name_num;
    private String fo_email;

    public Courses(String code, String qual, String duration, String places, String location, String desc, String depart, String fo_name_num, String fo_email) {
        this.code = code;
        this.qual = qual;
        this.duration = duration;
        this.places = places;
        this.location = location;
        this.desc = desc;
        this.depart = depart;
        this.fo_name_num = fo_name_num;
        this.fo_email = fo_email;
    }

    public Courses(){

    }

    public String getCode() {
        return code;
    }

    public String getQual() {
        return qual;
    }

    public String getDuration() {
        return duration;
    }

    public String getPlaces() {
        return places;
    }

    public String getLocation() {
        return location;
    }

    public String getDesc() {
        return desc;
    }

    public String getDepart() {
        return depart;
    }

    public String getFo_name_num() {
        return fo_name_num;
    }

    public String getFo_email() {
        return fo_email;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "programCode='" + code + '\'' +
                ", qualification='" + qual + '\'' +
                ", duration='" + duration + '\'' +
                ", location='" + location + '\'' +
                ", desc='" + desc + '\'' +
                ", courseDepart='" + depart + '\'' +
                ", furtherInfo_Name_No='" + fo_name_num + '\'' +
                ", furtherInfo_Email='" + fo_email + '\'' +
                '}';
    }

    public void setCode() {
        this.code = code;
    }

    public void setQual() {
        this.qual = qual;
    }

    public void setDuration() {
        this.duration = duration;
    }

    public void setPlaces() { this.places = places; }

    public void setLocation() {
        this.location = location;
    }

    public void setDesc() {
        this.desc = desc;
    }

    public void setDepart() {
        this.depart = depart;
    }

    public void setFo_name_num() {
        this.fo_name_num = fo_name_num;
    }

    public void setFo_email() {
        this.fo_email = fo_email;
    }

}
