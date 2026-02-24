package com.goutham.JobApplicationTracking.dto;

import lombok.Data;
import lombok.Getter;

import java.time.Instant;

@Data
@Getter
public class ApiResponseDto<T> {

    private String timestamp;
    private int status;
    private String message;
    private T data;

    public ApiResponseDto(String timestamp, int status, String message, T data) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponseDto<T> success(int status, String message, T data) {
        return new ApiResponseDto<>(
                Instant.now().toString(),
                status,
                message,
                data
        );
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
