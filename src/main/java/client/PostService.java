package client;

import model.User;
import model.base.EntityResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * 作者：chenZY
 * 时间：2018/5/29 18:54
 * 描述：
 */
public interface PostService {

    @FormUrlEncoded
    @POST("Post/postUser")
    Call<ResponseBody> postWithField(@Field("name") String name, @Field("mobile") String mobile);

    @FormUrlEncoded
    @POST("Post/postUser")
    Call<ResponseBody> postWithFieldMap(@FieldMap Map<String, String> map);

    @POST("Post/postUser")
    Call<ResponseBody> postWithBody(@Body User user);

}