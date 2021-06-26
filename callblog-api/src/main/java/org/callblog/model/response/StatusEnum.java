package org.callblog.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT) //Serialize(Enum -> Json)
public enum StatusEnum {
    OK(200,"OK"),
    NO_CONTENT(204,  "NO_CONTENT"),
    BAD_REQUEST(400, "BAD_REQUEST"),
    NOT_FOUND(404, "NOT_FOUND"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR");

    int code;
    String message;

    StatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @JsonCreator //Deserialize(Json -> Enum)
    public static StatusEnum fromJson(@JsonProperty("key") String name) {
        return valueOf(name);
    }
}
