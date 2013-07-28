package com.igordon.shaw.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.igordon.shaw.dao.CommentDao;
import com.igordon.shaw.domain.Comment;

/**
 * Servlet implementation class CommentsServelet
 */
@WebServlet("/CommentsServelet")
public class CommentsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String action = request.getParameter("action");
		if("save".equals(action)){
			this.addComment(request, response);
		}else if("list".equals(action)){
			this.listComments(request, response);
		}else{
			response.getWriter().write(" not correct action ");
		}
	}
	
	private void listComments(HttpServletRequest request, HttpServletResponse response){
		String videoid = request.getParameter("videoid");
		List<Comment> comments = new CommentDao().findCommentsByVid(Integer.parseInt(videoid));
		try {
			response.getWriter().write(new JSONArray().fromObject(comments).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addComment(HttpServletRequest request, HttpServletResponse response){
		String videoid = request.getParameter("videoid");
		String uname = request.getParameter("uname");
		String content = request.getParameter("content");
		System.out.println("content: " + content);
		Comment c = new Comment();
		c.setContent(content);
		c.setUserName(uname);
		c.setVideoId(Integer.parseInt(videoid));
		c.setPublishDate(new Date());
		new CommentDao().save(c);
	}

}
