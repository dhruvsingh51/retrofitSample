package modle;

import com.google.gson.annotations.SerializedName;

/**
 * Created by techjini on 22/2/16.
 */
public class User {

    @SerializedName("id")
    int mId;

    @SerializedName("name")
    String mName;

    public User(int id, String name ) {
        this.mId = id;
        this.mName = name;
    }
}