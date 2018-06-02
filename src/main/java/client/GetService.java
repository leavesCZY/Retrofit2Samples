package client;

import model.User;
import model.base.ListResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * 作者：chenZY
 * 时间：2018/5/29 18:54
 * 描述：
 */
public interface GetService {

    @GET("Get/getString")
    Call<ResponseBody> getNormal();

    @GET("Get/getString")
    Call<ResponseBody> getWithQuery(@Query("name") String name, @Query("age") int age);

    @GET("Get/getString")
    Call<ResponseBody> getWithMap(@QueryMap Map<String, String> map);

    @GET("Get/getString")
    @Headers({"userName:leavesC_2"})
    Call<ResponseBody> getWithQueryAndHeaders(@Query("name") String name, @Query("age") int age);

    @GET("Get/getString/{id}")
    Call<ResponseBody> getWithPath(@Path("id") int id);

    @GET("Get/getUser/{startId}/{number}")
    Call<ListResponse<User>> getWithGsonConverter(@Path("startId") int startId, @Path("number") int number);

}