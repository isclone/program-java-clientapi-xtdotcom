package com.xt.api.dto.future;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ContractResponse {

	private Integer id;
    private String symbol;
    private String ticker_id;
    private String base_currency;
    private String target_currency;
    private BigDecimal contractSize;
    private Integer underlyingType;
    private BigDecimal last_price;
    private BigDecimal base_volume;
    private BigDecimal target_volume;
    private BigDecimal bid;
    private BigDecimal ask;
    private BigDecimal high;
    private BigDecimal low;
    private String product_type;
    private BigDecimal open_interest;
    private BigDecimal index_price;
    private String index_name;
    private String index_currency;
    
    private Long start_timestamp;
    private Long end_timestamp;
    private BigDecimal funding_rate;
    private BigDecimal next_funding_rate;
    private Long next_funding_rate_timestamp;
    
    
    public LocalDateTime getStartTimestampAsTime() {
    	return LocalDateTime.ofInstant(Instant.ofEpochMilli(start_timestamp), TimeZone.getDefault().toZoneId());
    }
    
    public LocalDateTime getEndTimestampAsTime() {
    	return LocalDateTime.ofInstant(Instant.ofEpochMilli(end_timestamp), TimeZone.getDefault().toZoneId());
    }
}
