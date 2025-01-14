package com.xt.api.client.copytrade.futures;

import com.xt.api.client.HttpProxyProperties;
import com.xt.api.client.XtOkHttpClientBuilder;
import com.xt.api.client.XtWebSocketClient;
import com.xt.api.dto.FutureCommonResponse;
import com.xt.api.dto.copytrade.futures.AdjustLeverageReqDTO;
import com.xt.api.interceptor.XtFutureOkHttpInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author fonda
 */
public class XtFuturesCopyTradeApiClientImpl implements XtFuturesCopyTradeApiClient {

	private static final Logger LOG = Logger.getLogger(XtFuturesCopyTradeApiClientImpl.class);
	
    private final static String API_URL = "https://sapi.xt.com";

    private final XtFuturesCopyTradeApiService service;

    public XtFuturesCopyTradeApiClientImpl(HttpProxyProperties proxyProperties, String appKey, String secretKey){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(XtOkHttpClientBuilder.build(proxyProperties,new XtFutureOkHttpInterceptor(appKey, secretKey)))
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
        service = retrofit.create(XtFuturesCopyTradeApiService.class);
    }

    @Override
    public FutureCommonResponse applyLeader(Map<String, String> params) {
        return executeSync(service.applyLeader(params));
    }

    @Override
    public FutureCommonResponse cancelLeader(Map<String, String> params) {
        return executeSync(service.cancelLeader(params));
    }

    @Override
    public FutureCommonResponse chooseLeader(Map<String, String> params) {
        return executeSync(service.chooseLeader(params));
    }

    @Override
    public FutureCommonResponse cancelChooseLeader(Map<String, String> params) {
        return executeSync(service.cancelChooseLeader(params));
    }

    @Override
    public FutureCommonResponse closeAllOrders(Map<String, String> params) {
        return executeSync(service.closeAllOrders(params));
    }

    @Override
    public FutureCommonResponse closeOrder(Map<String, String> params) {
        return executeSync(service.closeOrder(params));
    }

    @Override
    public FutureCommonResponse stopProfitLoss(Map<String, String> params){
        return executeSync(service.stopProfitLoss(params));
    }

    @Override
    public FutureCommonResponse getPublicAvailableSymbols(Map<String, String> params) {
        return executeSync(service.getPublicAvailableSymbols());
    }

    @Override
    public FutureCommonResponse getFollowInfo(Map<String, String> params) {
        return executeSync(service.getFollowInfo(params));
    }

    @Override
    public FutureCommonResponse getLeaderInfo(Map<String, String> params) {
        return executeSync(service.getLeaderInfo(params));
    }

    @Override
    public FutureCommonResponse getPublicLeaderInfo(Map<String, String> params) {
        return executeSync(service.getPublicLeaderInfo(params));
    }

    @Override
    public FutureCommonResponse getCurrFollowerOrderList(Map<String, String> params) {
        return executeSync(service.getCurrFollowerOrderList(params));
    }

    @Override
    public FutureCommonResponse getCurrFollowerOrderPage(Map<String, String> params) {
        return executeSync(service.getCurrFollowerOrderPage(params));
    }

    @Override
    public FutureCommonResponse getHisFollowerOrderPage(Map<String, String> params) {
        return executeSync(service.getHisFollowerOrderPage(params));
    }

    @Override
    public FutureCommonResponse getCurrLeaderOrderList(Map<String, String> params) {
        return executeSync(service.getCurrLeaderOrderList(params));
    }

    @Override
    public FutureCommonResponse getCurrLeaderOrderPage(Map<String, String> params) {
        return executeSync(service.getCurrLeaderOrderPage(params));
    }

    @Override
    public FutureCommonResponse getHisLeaderOrderPage(Map<String, String> params) {
        return executeSync(service.getHisLeaderOrderPage(params));
    }

    @Override
    public FutureCommonResponse getLeaderFutureProfitDetail(Map<String, String> params) {
        return executeSync(service.getLeaderFutureProfitDetail(params));
    }

    @Override
    public FutureCommonResponse getLeaderFutureProfitTotal(Map<String, String> params) {
        return executeSync(service.getLeaderFutureProfitTotal(params));
    }

    @Override
    public FutureCommonResponse getLeaderHistoryProfitDetail(Map<String, String> params) {
        return executeSync(service.getLeaderHistoryProfitDetail(params));
    }

    @Override
    public FutureCommonResponse getLeaderHistoryProfitTotal(Map<String, String> params) {
        return executeSync(service.getLeaderHistoryProfitTotal(params));
    }

    @Override
    public FutureCommonResponse getPublicCurrLeaderOrderPage(Map<String, String> params) {
        return executeSync(service.getPublicCurrLeaderOrderPage(params));
    }

    @Override
    public FutureCommonResponse getPublicHisLeaderOrderPage(Map<String, String> params) {
        return executeSync(service.getPublicHisLeaderOrderPage(params));
    }

    @Override
    public FutureCommonResponse getPublicLeaderDayIncome(Map<String, String> params) {
        return executeSync(service.getPublicLeaderDayIncome(params));
    }

    @Override
    public FutureCommonResponse getPublicLeaderDayIncomeRate(Map<String, String> params) {
        return executeSync(service.getPublicLeaderDayIncomeRate(params));
    }

    @Override
    public FutureCommonResponse getPublicLeaderFollowers(Map<String, String> params) {
        return executeSync(service.getPublicLeaderFollowers(params));
    }

    @Override
    public FutureCommonResponse getPublicLeaderStats(Map<String, String> params) {
        return executeSync(service.getPublicLeaderStats(params));
    }

    @Override
    public FutureCommonResponse getPublicLeaderSymbolPrefer(Map<String, String> params) {
        return executeSync(service.getPublicLeaderSymbolPrefer(params));
    }

    @Override
    public FutureCommonResponse getMyFollowLeaderHistory(Map<String, String> params) {
        return executeSync(service.getMyFollowLeaderHistory(params));
    }

    @Override
    public FutureCommonResponse getMyFollowLeaderList(Map<String, String> params) {
        return executeSync(service.getMyFollowLeaderList(params));
    }

    @Override
    public FutureCommonResponse getUserSettings(Map<String, String> params) {
        return executeSync(service.getUserSettings(params));
    }

    @Override
    public FutureCommonResponse getLeverageList(Map<String, String> params) {
        return executeSync(service.getLeverageList(params));
    }

    @Override
    public FutureCommonResponse adjustLeverage(AdjustLeverageReqDTO request) {
        return executeSync(service.adjustLeverage(request));
    }

    public FutureCommonResponse executeSync(Call<FutureCommonResponse> call) {
        try {
            Response<FutureCommonResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }else {
                LOG.error(String.format("failed to call interface:%s, %s", response.code(), response.toString()));
                return FutureCommonResponse.failure(response.toString());
            }
        }catch (Exception e){
            LOG.error("call interface exception:" + e);
            throw new RuntimeException(e);
        }
    }
}
