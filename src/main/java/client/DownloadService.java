package client;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 作者：chenZY
 * 时间：2018/5/30 13:54
 * 描述：
 */
public interface DownloadService {

    @Streaming
    @GET
    Call<ResponseBody> downloadFile(@Url String fileUrl);

}
