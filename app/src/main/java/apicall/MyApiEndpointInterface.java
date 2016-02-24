package apicall;

import java.util.List;

import modle.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by techjini on 21/2/16.
 */
public interface MyApiEndpointInterface {


    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter
    /*
    *    Annotation Description
    *
    *    @Path	variable substitution for the API endpoint (i.e. username will be swapped for {username} in the URL endpoint).
    *    @Query	specifies the query key name with the value of the annotated parameter.
    *    @Body	payload for the POST call (serialized from a Java object to a JSON string)
    *    @Header	specifies the header with the value of the annotated parameter
    * */

    /*  With Retrofit 2, endpoints are defined inside of an interface using special retrofit annotations to encode
     *  details about the parameters and request method.
     *  In addition, the return value is always a parameterized Call<T> object such as Call<User>
     */

    @GET("{id}.json")
    Call<User> getUser(@Path("id") String username,@Query("app_key") String app_key,@Query("api_key") String api_key);

    @GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);

    @POST("users/new")
    Call<User> createUser(@Body User user);

    /*
    * If you do not need any type-specific response, you can specify return value as simply Call<ResponseBody>
    */

    /*@GET("users/{username}")
    Call<ResponseBody> getUser(...);

    @GET("group/{id}/users")
    Call<List<ResponseBody>> groupList(...);

    @POST("users/new")
    Call<ResponseBody> createUser(@Body ResponseBody user);*/
}