package com.example.wt.intelligentstudying.Tool;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UploadUtil {
    /**
     * @param mediaType MediaType
     * @param uploadUrl put请求地址
     * @param localPath 本地文件路径
     * @return 响应的结果 和 HTTP status code
     * @throws IOException
     */
    public String put(MediaType mediaType, String uploadUrl, String localPath) throws IOException {
        File file = new File(localPath);
        RequestBody body = RequestBody.create(mediaType, file);
        Request request = new Request.Builder()
                .url(uploadUrl)
                .put(body)
                .build();
        //修改各种 Timeout
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(600, TimeUnit.SECONDS)
                .readTimeout(200, TimeUnit.SECONDS)
                .writeTimeout(600, TimeUnit.SECONDS)
                .build();
        //如果不需要可以直接写成 OkHttpClient client = new OkHttpClient.Builder().build();

        Response response = client
                .newCall(request)
                .execute();
        return response.body().string() + ":" + response.code();
    }

    //上传JPG图片
    public String putImg(String uploadUrl, String localPath) throws IOException {
        MediaType imageType = MediaType.parse("image/jpeg; charset=utf-8");
        return put(imageType, uploadUrl, localPath);
    }
}
