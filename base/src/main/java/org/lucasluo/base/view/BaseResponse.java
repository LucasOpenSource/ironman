package org.lucasluo.base.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class BaseResponse<T> {
    private String message;
    private T data;

    public BaseResponse(String message) {
        this.message = message;
    }
}
