package entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName StatusCode
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/11/23 15:11
 * @Version：
 */
@Data
public class StatusCode implements Serializable {

    public static final long serialVersionUID = 1L;

    // 成功
    public static final int OK = 200;
    // 失败
    public static final int ERROR = 20001;
    // 用户名或密码错误
    public static final int LOGINERROR = 20002;
    // 权限不足
    public static final int ACCESSERROR = 20003;
    // 远程调用失败
    public static final int REMOTEERROR = 20004;
    // 重复操作
    public static final int REPERROR = 20005;

}
