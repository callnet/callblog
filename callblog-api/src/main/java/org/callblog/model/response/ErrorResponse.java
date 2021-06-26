package org.callblog.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ErrorResponse extends BasicResponse{
    private String subCode;
    private String subMsg;

    public ErrorResponse(StatusEnum status, String subMsg) {
        super(status);
        this.subCode = "ERROR";
        this.subMsg = subMsg;
    }

    public ErrorResponse(StatusEnum status, String subCode, String subMsg) {
        super(status);
        this.subCode = subCode;
        this.subMsg = subMsg;
    }
}
