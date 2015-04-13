package ie.dit.android.dit;


import java.io.Serializable;

public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String newsTitle;
    private String newsDate;
    private String newsImageURL;
    private static String newsDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Donec a diam lectus. Sed sit amet ipsum mauris. Maecenas congue ligula ac quam " +
            "viverra nec consectetur ante hendrerit. Donec et mollis dolor. Praesent et diam " +
            "eget libero egestas mattis sit amet vitae augue. Nam tincidunt congue enim, ut porta " +
            "lorem lacinia consectetur. Donec ut libero sed arcu vehicula ultricies a non tortor. " +
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean ut gravida lorem. Ut " +
            "turpis felis, pulvinar a semper sed, adipiscing id dolor. Pellentesque auctor nisi id " +
            "magna consequat sagittis. Curabitur dapibus enim sit amet elit pharetra tincidunt feugiat " +
            "nisl imperdiet. Ut convallis libero in urna ultrices accumsan. Donec sed odio eros. " +
            "Donec viverra mi quis quam pulvinar at malesuada arcu rhoncus. Cum sociis natoque " +
            "penatibus et magnis dis parturient montes, nascetur ridiculus mus. In rutrum accumsan " +
            "ultricies. Mauris vitae nisi at sem facilisis semper ac in est.";

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public String getNewsImageURL() {
        return newsImageURL;
    }

    public String getNewsDesc() {
        return newsDesc;
    }

    public News(String id, String newsTitle, String newsDate, String newsImageURL/*, String newsDesc*/) {
        this.id = id;
        this.newsTitle = newsTitle;
        this.newsDate = newsDate;
        this.newsImageURL = newsImageURL;
//        this.newsDesc = newsDesc;
    }

    @Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsDate='" + newsDate + '\'' +
                ", newsImageURL='" + newsImageURL + '\'' +
                '}';
    }
}
