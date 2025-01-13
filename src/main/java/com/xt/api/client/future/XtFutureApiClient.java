package com.xt.api.client.future;

import java.util.List;
import java.util.Map;

import com.xt.api.dto.FutureCommonResponse;
import com.xt.api.dto.future.ContractResponse;
import com.xt.api.dto.future.FuturePostOrderRequest;
import com.xt.api.dto.future.FutureTriggerPostOrderRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Query;


/**
 * @author zhouzhuang
 * @create 2023/9/20 11:48
 */
public interface XtFutureApiClient {


    FutureCommonResponse postOrder(FuturePostOrderRequest request);
    
    FutureCommonResponse batchOrder(List<FuturePostOrderRequest> futurePostOrderRequestList);

    FutureCommonResponse orderListHistory(Map<String, String> params);

    FutureCommonResponse orderTradeList(Map<String, String> params);

    FutureCommonResponse orderDetail(Long orderId);

    FutureCommonResponse orderList(Map<String, String> params);

    FutureCommonResponse orderCancel(Long orderId);

    FutureCommonResponse allCancel(String symbol);

    FutureCommonResponse postTriggerOrder(@Body FutureTriggerPostOrderRequest futurePostOrderRequest);

    FutureCommonResponse cancelTriggerOrder(Long entrustId);

    FutureCommonResponse cancelAllTriggerOrders(String symbol);

    FutureCommonResponse accountInfo();
    
    FutureCommonResponse positionList(String symbol);

    FutureCommonResponse balanceList();
    
    FutureCommonResponse balanceDetail(String coin);

    FutureCommonResponse listenKey();

    FutureCommonResponse adjustLeverage(String symbol,String positionSide,Integer leverage);

    FutureCommonResponse changePositionType(String symbol, String positionSide, String positionType);
    
    FutureCommonResponse symbols();
    
    FutureCommonResponse symbolMarkPrice(String symbol);
    
    FutureCommonResponse kline(String symbol, String interval, Long startTime, Long endTime, Long limit);
    
    List<ContractResponse> contracts();

}
