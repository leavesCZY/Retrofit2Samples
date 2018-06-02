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

    //不带任何参数的 Get 请求
    @GET("Get/getString")
    Call<ResponseBody> getNormal();

    //携带请求参数的 Get 请求
    @GET("Get/getString")
    Call<ResponseBody> getWithQuery(@Query("name") String name, @Query("age") int age);

    //携带请求参数的 Get 请求
    @GET("Get/getString")
    Call<ResponseBody> getWithMap(@QueryMap Map<String, String> map);

    //携带请求参数以及固定请求头的 Get 请求
    @GET("Get/getString")
    @Headers({"userName:leavesC"})
    Call<ResponseBody> getWithQueryAndHeaders(@Query("name") String name, @Query("age") int age);

    //携带请求参数以及请求头值不固定的 Get 请求
    @GET("Get/getString")
    Call<ResponseBody> getWithQueryAndHeader(@Header("userName") String userName, @Query("name") String name, @Query("age") int age);

    //将请求值作为链接一部分的 Get 请求
    @GET("Get/getString/{id}")
    Call<ResponseBody> getWithPath(@Path("id") int id);

    //将请求值作为链接一部分的 Get 请求，并使用 Gson Converter
    @GET("Get/getUser/{startId}/{number}")
    Call<ListResponse<User>> getWithGsonConverter(@Path("startId") int startId, @Path("number") int number);

}