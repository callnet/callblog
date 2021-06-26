package org.callblog.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class BasicResponse {
    private StatusEnum status;

    public BasicResponse(StatusEnum status) {
        this.status = status;
    }
}
