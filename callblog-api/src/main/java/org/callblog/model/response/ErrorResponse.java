package org.callblog.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ErrorResponse<T> extends BasicResponse{
    private String subCode;
    private String subMsg;
    private T data;

    public ErrorResponse(StatusEnum status, String subMsg) {
        this(status, "ERROR", subMsg, null);
    }

    public ErrorResponse(StatusEnum status, String subCode, String subMsg) {
        this(status, subCode, subMsg, null);
    }


    public ErrorResponse(StatusEnum status, String subCode, String subMsg, T data) {
        super(status);
        this.subCode = subCode;
        this.subMsg = subMsg;
        this.data = data;
    }
}
