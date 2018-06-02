import client.PostService;
import client.base.HttpConfig;
import model.User;
import model.base.EntityResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者：chenZY
 * 时间：2018/5/30 11:40
 * 描述：Post 模式
 */
public class PostServiceMain {

    public static void main(String[] args) {
//        postWithField();
//        postWithFieldMap();
        postWithBody();
    }

    private static void postWithField() {
        PostService postService = buildRetrofit().create(PostService.class);
        postService.postWithField("czy", "123456").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        //返回的数据：{"code":1,"msg":"success","data":{"name":"leavesC","mobile":123456}}
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

    private static void postWithFieldMap() {
        PostService postService = buildRetrofit().create(PostService.class);
        Map<String, String> map = new HashMap<>();
        map.put("name", "czy");
        map.put("mobile", "123456");
        postService.postWithFieldMap(map).enqueue(new Callback<ResponseBody>() {
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

    private static void postWithBody() {
        PostService postService = buildRetrofit().create(PostService.class);
        postService.postWithBody(new User("czy", "1234")).enqueue(new Callback<ResponseBody>() {
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
        return new Retrofit.Builder().baseUrl(HttpConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

}