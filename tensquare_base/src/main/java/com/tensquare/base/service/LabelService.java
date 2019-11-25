package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LabelService
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/11/23 17:22
 * @Version：
 */
@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll(){
        return labelDao.findAll();
    }

    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    public void save(Label label){
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    public void update(Label label){
        labelDao.save(label);
    }

    public void delete(String id){
        labelDao.deleteById(id);
    }

    /**
     * @auther: Winston
     * @Description: 复杂条件查询
     * @param: root 根对象，把条件封装到哪个对象中，where 类名=label.getId
     * @param: query 封装查询关键字，比如group by order by等，基本不用，直接写在sql语句中
     * @param: cb 封装条件对象
     * @return:
     * @date: 2019/11/24 13:47
     */
    public List<Label> findSearch(Label label) {
        return labelDao.findAll(getSpecification(label));
    }

    public Page<Label> pageQuery(Label label, int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Label> labelDaoAll = labelDao.findAll(getSpecification(label), pageable);
        return labelDaoAll;
    }

    private Specification<Label> getSpecification(Label label) {
        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                // 封装参数
                List<Predicate> list = new ArrayList<>();
                if (StringUtils.isNotBlank(label.getLabelname())) {
                    // where labelname like %林
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), label.getLabelname() + "%");
                    list.add(predicate);
                }
                if (StringUtils.isNotBlank(label.getState())) {
                    // where state = "1
                    Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }

                // new一个数组作为最终返回值的条件
                Predicate[] parr = new Predicate[list.size()];
                // 把list直接转成数组
                parr = list.toArray(parr);
                // 直接返回null表示不需要任何条件
                return cb.and(parr); // where labelname like "%林" and state = "1"
            }
        };
    }
}
