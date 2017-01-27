package com.pancake.dao;

import java.util.List;

import com.pancake.entity.Good;


public interface GoodDao {
	public void save(Good transientInstance);
	public void delete(Good persistentInstance);
	public Good findById(java.lang.Integer id);
	public List findAll();
}
