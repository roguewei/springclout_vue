package entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/11/23 14:53
 * @Version：
 */
@Data
public class Result implements Serializable {

    //   自定义serialVersionUID
    private static final long serialVersionUID = 8735132092273200831L;

    private boolean flag;
    private Integer code;
    private String message;
    private Object data;

    public Result() {
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
