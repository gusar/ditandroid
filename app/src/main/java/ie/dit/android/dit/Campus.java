package ie.dit.android.dit;

public class Campus {

    private String campusName;
    private int  campusImage;
    private double campusLatitude;
    private double campusLongitude;

    public Campus(String campusName, int campusImage, double campusLatitude, double campusLongitude){
        this.campusName = campusName;
        this.campusImage = campusImage;
        this.campusLatitude = campusLatitude;
        this.campusLongitude = campusLongitude;
    }

    public double getCampusLatitude() {
        return campusLatitude;
    }

    public String getCampusName() {
        return campusName;
    }

    public int getCampusImage() {
        return campusImage;
    }

    public double getCamspusLongitude() {
        return campusLongitude;
    }

}
