package com.igordon.shaw.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.igordon.shaw.domain.Comment;
import com.igordon.shaw.util.HiberUtil;

public class CommentDao {
	public void save(Comment comment){
		 Session session = null;
		  Transaction tx = null;
		  try {
		   session = HiberUtil.getSession();
		   tx = session.beginTransaction();
		   session.persist(comment);
		   tx.commit();
		  } catch (HibernateException e) {
		   if (tx != null)
		    tx.rollback();
		    throw e;
		  } finally {
		   session.close();
		  }
	}
	
	public Comment findById(Integer id){
		Session session = null;
		Comment comment = null;
		  try {
		   session = HiberUtil.getSession();
		   comment = (Comment)session.createCriteria(Comment.class).add(Expression.eq("id", id)).list().get(0);
		  } catch (HibernateException e) {
		  } finally {
		   session.close();
		  }
		  return comment;
	}
	
	public List<Comment> findCommentsByVid(Integer vid){
		List<Comment> comments  = null; 
		Session session = null;
		  try {
		   session = HiberUtil.getSession();
		   
		   comments = (ArrayList<Comment>) session
					.createQuery(" from Comment cm where cm.videoId = :mno")
					.setInteger("mno", vid).list();
		  } catch (HibernateException e) {
		  } finally {
		   session.close();
		  }
		  return comments;
	}
	
}
