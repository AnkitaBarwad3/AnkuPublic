package com.app.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.model.News;

public interface NewsDao extends CrudRepository<News, Integer>
{

	@Query("select n from News n " +"where DATE(n.date) = ?1")
	public List<News> findByDate(Date date);
}
