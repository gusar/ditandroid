package ie.dit.android.dit;


import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("id")
    public long id;
    public String newsName;
    public String newsDate;
    public String newsImage;
    public String newsDesc;

    public News(){
    }
}
