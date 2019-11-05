package tk.juanbody.util;

public class ResultDto {

    public static final String STATUS_OK = "OK";
    public static final String STATUS_ERROR = "ERROR";

    public String code;
    public Object result;

    public ResultDto() {

    }

    public ResultDto(String code, Object result) {
        this.code = code;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
