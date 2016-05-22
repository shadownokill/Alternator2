package com.shadow.alternator.request;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.shadow.alternator.bean.UserModel;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class AlternatorRequest {
//commonthread
    private static OkHttpClient client = new OkHttpClient();


    private static final String HOST = "http://114.55.101.2:8080/";
	public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");
    static {
        client.setConnectTimeout(10, TimeUnit.SECONDS);
    }

    public static void get(String url, AlternatorCallBack callback) {
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback == null ? new Callback() {

            @Override
            public void onResponse(Response arg0) throws IOException {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFailure(Request arg0, IOException arg1) {
                // TODO Auto-generated method stub

            }
        } : callback);
    }

    public static void downloadFile(String url, final String path, final AlternatorCallBack callBack) {
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new AlternatorCallBack() {

            @Override
            public void onResponse(Response response) {
                // TODO Auto-generated method stub
                if (!response.isSuccessful()) {
                    callBack.onError(0, 0, null);
                    return;
                }
                InputStream is = null;
                byte[] buf = new byte[2048];
                int read = 0, already = 0;
                long length = 0;
                try {
                    length = response.body().contentLength();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FileOutputStream fos = null;
                try {
                    is = response.body().byteStream();
                    File file = new File(path);
                    fos = new FileOutputStream(file);
                    while ((read = is.read(buf)) != -1) {
                        if (callBack.onCancel()) {
                            callBack.onError(0, 0, null);
                            break;
                        }
                        fos.write(buf, 0, read);
                        already += read;
                        int progress = (int) (((float) already / length) * 100);
                        callBack.onProgress(progress);
                    }
                    fos.flush();
                    if (!callBack.onCancel()) {
                        callBack.onSuccess(path);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    callBack.onError(0, 0, null);
                } finally {
                    try {
                        if (is != null)
                            is.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        callBack.onError(0, 0, null);
                    }
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        callBack.onError(0, 0, null);
                    }
                }
            }

            @Override
            public void onFailure(Request arg0, IOException arg1) {
                // TODO Auto-generated method stub
                callBack.onError(0, 0, null);

            }
        });
    }

    private static Call post(String host, String action, String body, AlternatorCallBack responseCallback) {
    	Request request = new Request.Builder().url(host+action).post(RequestBody.create(MEDIA_TYPE_MARKDOWN, body)).build();
        Call call = client.newCall(request);
        if (responseCallback != null) {
            responseCallback.setCall(call);
            if (responseCallback.getLoading() != null) {
                responseCallback.getLoading().show();
            }
        }
        call.enqueue(responseCallback == null ? new Callback() {

            @Override
            public void onResponse(Response arg0) throws IOException {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFailure(Request arg0, IOException arg1) {
                // TODO Auto-generated method stub

            }
        } : responseCallback);
        return call;
    }

    private static Call post(String action, String body, AlternatorCallBack responseCallback) {
        return post(HOST, action, body, responseCallback);
    }

    /**
     */
    public static Call login(UserModel body, AlternatorCallBack callback) {
    	String action = "basicinfo/Login";
        return post(action, new Gson().toJson(new Gson().toJson(body)), callback);
    }
    public static Call getCompanyInfo(String body, AlternatorCallBack callback) {
    	String action = "Company/GetCompanyModelByUid";
    	return post(action, body, callback);
    }
    public static Call getDeviceInfo(String body, AlternatorCallBack callback) {
    	String action = "DeviceInfo/GetDeviceDataByDid";
    	return post(action, body, callback);
    }
    public static Call getDeviceList(String body, AlternatorCallBack callback) {
    	String action = "DeviceInfo/GetDeviceModelListByUid";
    	return post(action, body, callback);
    }
    public static Call getAlarms(String body, AlternatorCallBack callback) {
    	String action = "DeviceInfo/GetDeviceAlarmModelByDid";
    	return post(action, body, callback);
    }
    public static Call getDeviceIO(String body, AlternatorCallBack callback) {
    	String action = "DeviceInfo/GetDeviceIOModelByDid";
    	return post(action, body, callback);
    }
    public static Call getDeviceStatus(String body, AlternatorCallBack callback) {
    	String action = "DeviceInfo/GetDeviceStatusModel";
    	return post(action, body, callback);
    }
    public static Call command(String body, AlternatorCallBack callback) {
    	String action = "Command/SendCommand";
    	return post(action, body, callback);
    }

    
}
