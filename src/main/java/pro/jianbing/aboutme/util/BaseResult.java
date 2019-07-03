package pro.jianbing.aboutme.util;

import lombok.Data;
import org.openjdk.jmh.results.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DefaultAccount
 */
@Data
public class BaseResult<T> {
    private static final String SUCCESS_CODE = "0";
    private static final String FAIL_CODE = "1";
    private String code;
    private String msg;
    private T data;
    /*private Result() {
        this.code = UnifyStrErrorCode.SUCCESS.getCode();
        this.msg = UnifyStrErrorCode.SUCCESS.getMsg();
    }

    private Result(T data) {
        this.code = UnifyStrErrorCode.SUCCESS.getCode();
        this.msg = UnifyStrErrorCode.SUCCESS.getMsg();
        this.setData(data);
    }

    private Result(String code, String msg) {
        this.code = UnifyStrErrorCode.SUCCESS.getCode();
        this.msg = UnifyStrErrorCode.SUCCESS.getMsg();
        this.setCode(code);
        this.setMsg(msg);
    }

    private Result(String code, String msg, T data) {
        this.code = UnifyStrErrorCode.SUCCESS.getCode();
        this.msg = UnifyStrErrorCode.SUCCESS.getMsg();
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    public Result<T> setError(String code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

    public Result<T> setError(UnifyStrErrorCode errorCode) {
        this.setCode(errorCode.getCode());
        this.setMsg(errorCode.getMsg());
        return this;
    }

    public boolean isSuccess() {
        return StringUtils.equals(this.getCode(), UnifyStrErrorCode.SUCCESS.getCode());
    }

    public static  Result instance() {
        return new Result();
    }

    public static <T> Result instance(T data) {
        return new Result(data);
    }

    public static <T> Result instance(String code, String msg) {
        return new Result(code, msg);
    }

    public static <T> Result instance(String code, String msg, T data) {
        return new Result(code, msg, data);
    }

    public Map<String,Object> toJsonMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",this.data);
        map.put("msg",this.msg);
        map.put("code",this.code);
        return  map;
    }*/
}
