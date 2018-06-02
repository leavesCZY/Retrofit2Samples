import client.UploadService;
import client.base.HttpConfig;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者：chenZY
 * 时间：2018/5/30 11:41
 * 描述：上传文件
 */
public class UploadServiceMain {

    public static void main(String[] args) {
//        uploadPhoto();
        uploadFileDouble();
    }

    private static void uploadPhoto() {
        UploadService uploadService = buildRetrofit().create(UploadService.class);
        File file = new File("..\\JavaRetrofit\\src\\main\\resources\\images\\lufei.jpg");
        RequestBody photoRequestBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        //设置Content-Disposition:form-data; name="photo"; filename="lufei.jpg"
        MultipartBody.Part photo = MultipartBody.Part.createFormData("photo", file.getName(), photoRequestBody);
        RequestBody userName = RequestBody.create(MediaType.parse("text/plain"), "leavesC");
        RequestBody password = RequestBody.create(MediaType.parse("text/plain"), "123456");
        uploadService.uploadPhoto(photo, userName, password).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        System.out.println("onResponse body: " + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("onResponse code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("onFailure: " + t.getMessage());
            }
        });
    }

    private static void uploadFileDouble() {
        UploadService uploadService = buildRetrofit().create(UploadService.class);
        Map<String, RequestBody> photoMap = new HashMap<>();

        File file = new File("..\\JavaRetrofit\\src\\main\\resources\\images\\lufei.jpg");
        RequestBody photoRequestBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        photoMap.put("photos\"; filename=\"" + file.getName(), photoRequestBody);

        file = new File("..\\JavaRetrofit\\src\\main\\resources\\images\\mingren.jpg");
        photoRequestBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        photoMap.put("photos\"; filename=\"" + file.getName(), photoRequestBody);

        uploadService.uploadFileDouble(photoMap).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        System.out.println("onResponse body: " + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("onResponse code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("onFailure: " + t.getMessage());
            }
        });
    }

    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder().baseUrl(HttpConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

}