package com.igordon.shaw.dao;


import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.igordon.shaw.domain.Comment;
import com.igordon.shaw.domain.Video;
import com.igordon.shaw.util.HiberUtil;

public class VideoDao {
	public void save(Video video){
		 Session session = null;
		  Transaction tx = null;
		  try {
		   session = HiberUtil.getSession();
		   tx = session.beginTransaction();
		   session.persist(video);
		   tx.commit();
		  } catch (HibernateException e) {
		   if (tx != null)
		    tx.rollback();
		    throw e;
		  } finally {
		   session.close();
		  }
	}
	
	public Video findById(Integer id){
		Session session = null;
		Video video = null;
		  try {
		   session = HiberUtil.getSession();
		   video = (Video)session.createCriteria(Video.class).add(Expression.eq("id", id)).list().get(0);
		   video.setComments(video.getComments());
		   //Hibernate.initialize(video.getComments());
		  } catch (HibernateException e) {
		  } finally {
		   session.close();
		  }
		  return video;
	}
	public List<Video> findAll(){
		Session session = null;
		List<Video> videos = null;
		  try {
		   session = HiberUtil.getSession();
		   videos = (List<Video>)session.createCriteria(Video.class).list();
		  } catch (HibernateException e) {
		  } finally {
		   session.close();
		  }
		  return videos;
	}
}
