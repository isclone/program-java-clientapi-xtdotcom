package com.xt.api.dto.future;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FutureTriggerPostOrderRequest {

	private String clientOrderId;
    private String symbol;
    private String orderSide;
    private String entrustType;
    private String origQty;
    private String price;
    private String stopPrice;
    private String timeInForce;
    private String triggerPriceType;
    private String positionSide;
}
