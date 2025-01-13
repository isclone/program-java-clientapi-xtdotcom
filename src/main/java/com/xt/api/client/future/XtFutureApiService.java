package com.xt.api.client.future;

import java.util.List;
import java.util.Map;

import com.xt.api.dto.FutureCommonResponse;
import com.xt.api.dto.future.ContractResponse;
import com.xt.api.dto.future.FutureOrderCancelAllRequest;
import com.xt.api.dto.future.FutureOrderCancelRequest;
import com.xt.api.dto.future.FuturePostOrderRequest;
import com.xt.api.dto.future.FutureTriggerPostOrderRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author zhouzhuang
 * @create 2023/9/20 14:28
 */
public interface XtFutureApiService {

    @POST("/future/trade/v1/order/create")
    Call<FutureCommonResponse> makeOrder(@QueryMap Map<String, String> params);

    @POST("/future/trade/v1/order/create")
    Call<FutureCommonResponse> postOrder(@Body FuturePostOrderRequest futurePostOrderRequest);

    @POST("/future/trade/v1/order/create-batch")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<FutureCommonResponse> batchOrder(@Query("list") String list);
    
    @GET("/future/trade/v1/order/list-history")
    Call<FutureCommonResponse> orderListHistory(@QueryMap Map<String, String> params);

    @GET("/future/trade/v1/order/trade-list")
    Call<FutureCommonResponse> orderTradeList(@QueryMap Map<String, String> params);

    @GET("/future/trade/v1/order/detail")
    Call<FutureCommonResponse> orderDetail(@Query("orderId") Long orderId);

    @GET("/future/trade/v1/order/list")
    Call<FutureCommonResponse> orderList(@QueryMap Map<String, String> params);

    @POST("/future/trade/v1/order/cancel")
    Call<FutureCommonResponse> orderCancel(@Body FutureOrderCancelRequest request);

    @POST("/future/trade/v1/order/cancel-all")
    Call<FutureCommonResponse> allCancel(@Body FutureOrderCancelAllRequest request);

    @POST("/future/trade/v1/entrust/create-plan")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<FutureCommonResponse> postTriggerOrder(@Body FutureTriggerPostOrderRequest futurePostOrderRequest);

    @POST("/future/trade/v1/entrust/cancel-plan")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<FutureCommonResponse> cancelTriggerOrder(@Query("entrustId") Long entrustId);

    @POST("/future/trade/v1/entrust/cancel-all-plan")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<FutureCommonResponse> cancelAllTriggerOrders(@Query("symbol") String symbol);

    @GET("/future/user/v1/account/info")
    Call<FutureCommonResponse> accountInfo();

    @GET("/future/user/v1/balance/list")
    Call<FutureCommonResponse> balanceList();

    @GET("/future/user/v1/balance/detail")
    Call<FutureCommonResponse> balanceDetail(@Query("coin") String coin);

    @GET("/future/user/v1/user/listen-key")
    Call<FutureCommonResponse> listenKey();

    @GET("/future/market/v3/public/symbol/list")
    Call<FutureCommonResponse> symbols();
    
    @GET("/future/market/v1/public/q/symbol-mark-price")
    Call<FutureCommonResponse> symbolMarkPrice(@Query("symbol") String symbol);
    
    @GET("/future/user/v1/position/list")
    Call<FutureCommonResponse> positionList(@Query("symbol") String symbol);

    @GET("/future/market/v1/public/cg/contracts")
    Call<List<ContractResponse>> contracts();

    @GET("/future/market/v1/public/q/kline")
    Call<FutureCommonResponse> kline(@Query("symbol") String symbol, @Query("interval") String interval, @Query("startTime") Long startTime, @Query("endTime") Long endTime, @Query("limit") Long limit);

    @POST("/future/user/v1/position/adjust-leverage")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<FutureCommonResponse> adjustLeverage(@Query("symbol") String symbol,@Query("positionSide") String positionSide,@Query("leverage") Integer leverage);

    @POST("/future/user/v1/position/change-type")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<FutureCommonResponse> changePositionType(@Query("symbol") String symbol, @Query("positionSide") String positionSide, @Query("positionType") String positionType);
    
}
