package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

// 使用复杂条件查询需要使用JpaSpecificationExecutor
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
}
