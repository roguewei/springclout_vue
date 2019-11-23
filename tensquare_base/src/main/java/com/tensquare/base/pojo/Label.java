package com.tensquare.base.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName Label
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/11/23 16:55
 * @Version：
 */
@Data
// jpa的注解
@Entity
@Table(name = "tb_label")
public class Label implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    private String id;
    // 标签名
    private String labelname;
    // 状态
    private String state;
    // 使用数量
    private Long count;
    // 关注数
    private Long fans;
    // 是否推荐
    private String recommend;

}
