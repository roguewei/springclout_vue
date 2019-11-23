package entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PageResult
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/11/23 15:09
 * @Version：
 */
@Data
public class PageResult<T> implements Serializable {

    public static final long serialVersionUID = 1L;

    private long total;
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
