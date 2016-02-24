package apicall;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modle.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by techjini on 21/2/16.
 */
public class APIBuilder {
    // Trailing slash is needed
//    public static final String BASE_URL = "http://api.myservice.com/";
    public static final String BASE_URL = "https://api.pipelinedeals.com/api/v3/people/";
    private static Retrofit retrofit;

    // TODO: 22/2/16 Rupak :: Can i make it static or not
    public static Retrofit retrofitBuilder() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

    /*  Retrofit 2 allows you to override the base URL specified by changing it in the annotation
        (i.e. if you need to keep one specific endpoint using an older API endpoint)
    */

    /*Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();*/

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }


}
