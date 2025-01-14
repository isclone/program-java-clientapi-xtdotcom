package com.xt.api.client.spot;

import org.apache.log4j.Logger;

import com.xt.api.client.HttpProxyProperties;
import com.xt.api.client.XtOkHttpClientBuilder;
import com.xt.api.client.future.AbstractXtFutureApiClient;
import com.xt.api.dto.CommonResponse;

import com.xt.api.dto.nft.NftDepositRequest;
import com.xt.api.dto.nft.NftWithdrawRequest;
import com.xt.api.dto.spot.NetworthUpdateRequest;
import com.xt.api.dto.spot.SpotPostOrderRequest;
import com.xt.api.dto.spot.SpotUpdateOrderRequest;
import com.xt.api.interceptor.XtSpotOkHttpInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * @author zhouzhuang
 * @create 2023/9/20 12:18
 */
public class XtSpotApiClientImpl implements XtSpotApiClient{

	private static final Logger LOG = Logger.getLogger(XtSpotApiClientImpl.class);
	
    private final static String API_URL = "https://sapi.xt.com";

    private final XtSpotApiService service;

    public XtSpotApiClientImpl(HttpProxyProperties proxyProperties, String appKey, String secretKey){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(XtOkHttpClientBuilder.build(proxyProperties,new XtSpotOkHttpInterceptor(appKey, secretKey)))
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
        service = retrofit.create(XtSpotApiService.class);
    }

    @Override
    public CommonResponse postOrder(SpotPostOrderRequest request) {
        return executeSync(service.postOrder(request));
    }

    @Override
    public CommonResponse getOrder(Long id) {
        return executeSync(service.getOrder(id));
    }

    @Override
    public CommonResponse symbol(String symbol) {
        return executeSync(service.symbol(symbol));
    }

    @Override
    public CommonResponse queryOrder(Long orderId) {
        return executeSync(service.queryOrder(orderId));
    }

    @Override
    public CommonResponse delOrder(Long id) {
        return executeSync(service.delOrder(id));
    }

    @Override
    public CommonResponse updateOrder(Long id, SpotUpdateOrderRequest request) {
        return executeSync(service.updateOrder(id,request));
    }

    @Override
    public CommonResponse netWorth(NetworthUpdateRequest request) {
        return executeSync(service.netWorth(request));
    }

    @Override
    public CommonResponse nftDeposit(NftDepositRequest request){
        return executeSync(service.nftDeposit(request));
    }

    @Override
    public CommonResponse nftWithdraw(NftWithdrawRequest request){
        return executeSync(service.nftWithdraw(request));
    }

    @Override
    public CommonResponse nftHistoryOrder(Integer type, Integer status, String currency, Long startTime, Long endTime, Integer page, Integer size) {
        return executeSync(service.nftHistoryOrder(type, status, currency, startTime, endTime, page, size));
    }

    public CommonResponse executeSync(Call<CommonResponse> call) {
        try {
            Response<CommonResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }else {
                LOG.error(String.format("failed to call interface:%s,%s",response.code(),response.toString()));
                return CommonResponse.failure(response.toString());
            }
        }catch (Exception e){
            LOG.error("call interface exception:"+e);
            throw new RuntimeException(e);
        }
    }
}
