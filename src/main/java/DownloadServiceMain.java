import client.DownloadService;
import client.base.HttpConfig;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.Okio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.io.IOException;

/**
 * 作者：chenZY
 * 时间：2018/5/30 13:54
 * 描述：
 */
public class DownloadServiceMain {

    public static void main(String[] args) {
        downloadFile();
    }

    private static void downloadFile() {
        DownloadService downloadService = buildRetrofit().create(DownloadService.class);
        Call<ResponseBody> call = downloadService.downloadFile("downloadFile");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    BufferedSink sink = null;
                    try {
                        File file = new File("C:\\Users\\CZY\\Desktop\\Hi.jpg");
                        sink = Okio.buffer(Okio.sink(file));
                        sink.writeAll(response.body().source());
                        System.out.println("onResponse : success");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (sink != null) {
                                sink.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
