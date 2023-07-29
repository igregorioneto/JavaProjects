package com.backend.backend.util;

import com.backend.backend.dto.SuccessResponseDTO;
import com.backend.backend.entity.Account;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ResponseMessage<T> {
   public SuccessResponseDTO<T> MessageReturn(String type, int httpStatus, T data ) {
       SuccessResponseDTO<T> message = new SuccessResponseDTO<>();

       message.setMessage(type);
       message.setHttpStatus(httpStatus);
       message.setData(data);

       return message;
   }
}
