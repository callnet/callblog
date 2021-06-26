package org.callblog.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ResultResponse<T> extends BasicResponse{
    private int count;
    private T data;

    public ResultResponse() {
        super(StatusEnum.NO_CONTENT);
    }

    public ResultResponse(StatusEnum status, T data) {
        super(status);
        this.data = data;
        if(data instanceof List) {
            this.count = ((List<?>) data).size();
        } else {
            this.count = 1;
        }
    }
}
