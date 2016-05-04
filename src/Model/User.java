package Model;

/**
 * Created by dell on 2016/5/4.
 */
public class User {
    private String id;

    private String name;

    private String psd;

    private int type;

    private String profile;
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }



}
