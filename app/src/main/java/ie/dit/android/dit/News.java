package ie.dit.android.dit;


import java.io.Serializable;

public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String date;
    private String newsURL;
    private String newsDesc;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getNewsURL() {
        return newsURL;
    }

    public String getDetails() {
        return newsDesc;
    }

    public News(long id, String name, String date, String newsURL, String details) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.newsURL = newsURL;
        this.newsDesc = details;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", newsURL='" + newsURL + '\'' +
                ", details='" + newsDesc + '\'' +
                '}';
    }
}
