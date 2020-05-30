package com.weizz5.spring.service;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/30
 */
public interface Calculator {

    public Integer add(Integer i, Integer j) throws Exception;
    public Integer sub(Integer i, Integer j) throws Exception;
    public Integer mul(Integer i, Integer j) throws Exception;
    public Integer div(Integer i, Integer j) throws Exception;
}
