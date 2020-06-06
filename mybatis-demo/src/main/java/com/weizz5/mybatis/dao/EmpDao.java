package com.weizz5.mybatis.dao;

import com.weizz5.mybatis.bean.Emp;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/06/02
 */
public interface EmpDao {

    public Emp query(Integer empno);

    @MapKey("ename")
    public Map<String,Emp> queryByRange();

    public List<Emp> queryAll();

    public Integer save(Emp emp);

    public Integer update(Emp emp);

    public Integer delete(Integer empno);

}
