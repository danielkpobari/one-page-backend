package com.danitest.kpobaritest.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T>{
    private String message;
    private int status;
    private LocalDateTime timestamp;
    private T data;

    public static<T> ApiResponse<T> success(T data){
        ApiResponse<T> response = new ApiResponse<>();
        response.setMessage("Success");
        response.setStatus(200);
        response.setTimestamp(LocalDateTime.now());
        response.setData(data);

        return response;
    }

    public static<T> ApiResponse<T> error(T data,int status){
        ApiResponse<T> response = new ApiResponse<>();
        response.setMessage("Failure");
        response.setStatus(status);
        response.setTimestamp(LocalDateTime.now());
        response.setData(data);

        return response;
    }
}
