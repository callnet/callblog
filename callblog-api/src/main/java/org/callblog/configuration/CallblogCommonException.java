package org.callblog.configuration;

import lombok.Getter;
import lombok.Setter;
import org.callblog.model.response.BasicResponse;

@Getter @Setter
public class CallblogCommonException extends RuntimeException{

    private BasicResponse basicResponse;

    public CallblogCommonException(String message) {
        super(message);
    }

    public CallblogCommonException(BasicResponse basicResponse) {
        this.basicResponse = basicResponse;
    }

    public CallblogCommonException(String message, BasicResponse basicResponse) {
        super(message);
        this.basicResponse = basicResponse;
    }
}
