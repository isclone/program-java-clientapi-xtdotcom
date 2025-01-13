package com.xt.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author zhouzhuang
 * @create 2023/9/20 17:30
 */
@Data
@NoArgsConstructor
public class FutureCommonListResponse<T> {
    private final static Integer RC_FAILURE = 1;
    private Integer returnCode;
    private List<T> results;
    private String msgInfo;
    private Object error;


    private FutureCommonListResponse(Integer returnCode, List<T> results, String msgInfo, Object error) {
        this.returnCode = returnCode;
        this.results = results;
        this.msgInfo = msgInfo;
        this.error = error;
    }

    private static FutureCommonListResponse<Object> FAILURE = new FutureCommonListResponse<>(RC_FAILURE,null, "FAILURE", null);



    public static FutureCommonListResponse<Object> failure() {
        return FAILURE;
    }

    public static FutureCommonListResponse<Object> failure(String msg) {
        return new FutureCommonListResponse<>(RC_FAILURE,null, msg, null);
    }
}
