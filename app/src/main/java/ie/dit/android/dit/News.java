package ie.dit.android.dit;


import java.io.Serializable;

public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String newsName;
    private String newsDate;
    private String newsImage;
    private String newsDesc;

    public News(long id, String newsName, String newsDate, String newsImage, String newsDesc) {
        this.id = id;
        this.newsName = newsName;
        this.newsDate = newsDate;
        this.newsImage = newsImage;
        this.newsDesc = newsDesc;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public long getId() {
        return id;
    }
    public String getNewsName() {
        return newsName;
    }
    public String getNewsDate() {
        return newsDate;
    }
    public String getNewsImage() {
        return newsImage;
    }
    public String getNewsDesc() {
        return newsDesc;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", newsName='" + newsName + '\'' +
                ", newsDate='" + newsDate + '\'' +
                ", newsImage='" + newsImage + '\'' +
                ", newsDesc='" + newsDesc + '\'' +
                '}';
    }
}
