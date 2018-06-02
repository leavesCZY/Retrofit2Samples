package client;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * 作者：chenZY
 * 时间：2018/5/29 18:55
 * 描述：
 */
public interface UploadService {

    @Multipart
    @POST("uploadPhoto")
    Call<ResponseBody> uploadPhoto(@Part MultipartBody.Part photo, @Part("userName") RequestBody username, @Part("password") RequestBody password);

}