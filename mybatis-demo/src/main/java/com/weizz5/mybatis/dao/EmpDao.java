package com.weizz5.mybatis.dao;

import com.weizz5.mybatis.bean.Emp;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/06/02
 */
public interface EmpDao {

    public void save(Emp emp);

    public Integer update(Integer empno);

    public Integer delete(Integer empno);

    public Emp select(Integer empno);
}
