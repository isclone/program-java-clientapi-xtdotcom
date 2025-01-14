package com.xt.api.client.future;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.xt.api.client.copytrade.spot.XtSpotCopyTradeApiClientImpl;
import com.xt.api.dto.FutureCommonListResponse;
import com.xt.api.dto.FutureCommonResponse;
import com.xt.api.dto.future.ContractResponse;
import com.xt.api.dto.future.FutureOrderCancelAllRequest;
import com.xt.api.dto.future.FutureOrderCancelRequest;
import com.xt.api.dto.future.FuturePostOrderRequest;
import com.xt.api.dto.future.FutureTriggerPostOrderRequest;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Query;

/**
 * @author zhouzhuang
 * @create 2023/9/20 18:23
 */
public abstract class AbstractXtFutureApiClient implements XtFutureApiClient{
	
	private static final Logger LOG = Logger.getLogger(AbstractXtFutureApiClient.class);
	
    private final Gson gson = new Gson();
    @Override
    public FutureCommonResponse postOrder(FuturePostOrderRequest request) {
        return executeSync(getService().postOrder(request));
    }
        
    @Override
    public FutureCommonResponse batchOrder(List<FuturePostOrderRequest> futurePostOrderRequestList){
        return executeSync(getService().batchOrder(gson.toJson(futurePostOrderRequestList)));
    }

    @Override
    public FutureCommonResponse orderListHistory(Map<String, String> params) {
        return executeSync(getService().orderListHistory(params));
    }

    @Override
    public FutureCommonResponse orderTradeList(Map<String, String> params) {
        return executeSync(getService().orderTradeList(params));
    }

    @Override
    public FutureCommonResponse orderDetail(Long orderId) {
        return executeSync(getService().orderDetail(orderId));
    }
    @Override
    public FutureCommonResponse orderList(Map<String, String> params){
        return executeSync(getService().orderList(params));
    }
    @Override
    public FutureCommonResponse orderCancel(Long orderId){
        return executeSync(getService().orderCancel(FutureOrderCancelRequest.builder().orderId(orderId).build()));
    }

    @Override
    public FutureCommonResponse allCancel(String symbol){
        symbol = symbol==null?"":symbol;
        return executeSync(getService().allCancel(FutureOrderCancelAllRequest.builder().symbol(symbol).build()));
    }

    @Override
    public FutureCommonResponse postTriggerOrder(FutureTriggerPostOrderRequest futurePostOrderRequest) {
    	return executeSync(getService().postTriggerOrder(futurePostOrderRequest));
    }

    @Override
    public FutureCommonResponse cancelTriggerOrder(Long entrustId){
        return executeSync(getService().cancelTriggerOrder(entrustId));
    }

    @Override
    public FutureCommonResponse cancelAllTriggerOrders(String symbol){
        return executeSync(getService().cancelAllTriggerOrders(symbol));
    }

    @Override
    public FutureCommonResponse accountInfo(){
        return executeSync(getService().accountInfo());
    }

    @Override
    public FutureCommonResponse balanceList(){
        return executeSync(getService().balanceList());
    }

    @Override
    public FutureCommonResponse balanceDetail(String coin){
        return executeSync(getService().balanceDetail(coin));
    }

    @Override
    public FutureCommonResponse listenKey(){
        return executeSync(getService().listenKey());
    }

    @Override
    public FutureCommonResponse adjustLeverage(String symbol,String positionSide,Integer leverage){
        return executeSync(getService().adjustLeverage(symbol,positionSide,leverage));
    }

    @Override
    public FutureCommonResponse changePositionType(String symbol, String positionSide, String positionType) {
        return executeSync(getService().changePositionType(symbol, positionSide, positionType));
    }

    @Override
    public FutureCommonResponse symbols() {
    	return executeSync(getService().symbols());
    }
    
    @Override
    public FutureCommonResponse symbolMarkPrice(String symbol) {
    	return executeSync(getService().symbolMarkPrice(symbol));
    }
    
    @Override
    public FutureCommonResponse positionList(String symbol) {
    	return executeSync(getService().positionList(symbol));
    }
    
    @Override
    public List<ContractResponse> contracts() {
        try {
	    	Call<List<ContractResponse>> call = getService().contracts();

	    	Response<List<ContractResponse>> response = call.execute();
        
	        if (response.isSuccessful()) {
	            return response.body();
	        }else {
	            throw new RuntimeException(String.format("failed to call interface:%s,%s",response.code(),response.toString()));
	        }
	    }catch (Exception e){
	        LOG.error("call interface exception:"+e);
	        throw new RuntimeException(e);
	    }
    }
    
    @Override
    public FutureCommonResponse kline(String symbol, String interval, Long startTime, Long endTime, Long limit) {
    	return executeSync(getService().kline(symbol, interval, startTime, endTime, limit));
    }
        

    public FutureCommonResponse executeSync(Call<FutureCommonResponse> call) {
        try {
            Response<FutureCommonResponse> response = call.execute();

            if (response.isSuccessful()) {
                return response.body();
            }else {
                LOG.error(String.format("failed to call interface:%s,%s",response.code(),response.toString()));
                String err = new String(response.errorBody().bytes());
                return gson.fromJson(err,FutureCommonResponse.class);
            }
        }catch (Exception e){
            LOG.error("call interface exception:"+e);
            throw new RuntimeException(e);
        }
    }
    
    abstract XtFutureApiService getService();
}
