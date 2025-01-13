package com.xt.api.client.future;

import com.xt.api.client.HttpProxyProperties;
import com.xt.api.client.XtOkHttpClientBuilder;
import com.xt.api.interceptor.XtFutureOkHttpInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * B-BASE Future
 * @author zhouzhuang
 * @create 2023/9/20 12:18
 */
public class XtBFutureApiClientImpl extends AbstractXtFutureApiClient{

    private final static String API_URL = "https://dapi.xt.com";

    private final XtFutureApiService service;

    public XtBFutureApiClientImpl(HttpProxyProperties proxyProperties, String appKey, String secretKey){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(XtOkHttpClientBuilder.build(proxyProperties,new XtFutureOkHttpInterceptor(appKey, secretKey)))
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
        service = retrofit.create(XtFutureApiService.class);
    }

    @Override
    XtFutureApiService getService() {
        return service;
    }
}
