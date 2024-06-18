package com.util;

/**
 * 接口返回对象
 */
public class ApiResponse<T> {

    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    private ApiResponse(Boolean success, Integer code,String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 请求成功
     *
     */
    public static <T> ApiResponse success(T data) {
        return ApiResponse.success("请求成功", data);
    }

    /**
     * 请求成功
     *
     */
    public static <T> ApiResponse success(String message, T data) {
        return new ApiResponse(Boolean.TRUE,0, message, data);
    }

    /**
     * 请求失败
     *
     */
    public static ApiResponse failed() {
        return ApiResponse.failed("请求失败，请联系管理员");
    }

    /**
     * 请求失败
     */
    public static ApiResponse failed(String message) {
        return new ApiResponse(Boolean.FALSE,500, message, null);
    }

    /**
     * 请求失败
     */
    public static ApiResponse failed(Integer code,String message) {
        return new ApiResponse(Boolean.FALSE,code, message, null);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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

    /**
     * 获取
     *
     * @return code
     */
    public Integer getCode() {
        return this.code;
    }

    /**
     * 设置
     *
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }
}
