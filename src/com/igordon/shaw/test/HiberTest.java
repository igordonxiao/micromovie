package com.igordon.shaw.test;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.igordon.shaw.dao.CommentDao;
import com.igordon.shaw.dao.VideoDao;
import com.igordon.shaw.domain.Comment;
import com.igordon.shaw.domain.Video;

public class HiberTest {
	@Test
	public void testSaveVideo() {
		Video video = new Video();
		video.setName("致程序员");
		video.setVdesc("新电程序员");
		video.setImg("img/1.jpg");
		video.setHot(25);
		video.setPath("./videos/programer.mp4");
		video.setVdesc("几个程序员的工作和生活");
		VideoDao vdao = new VideoDao();
		vdao.save(video);
		
		Comment c = new Comment();

		c.setUserName("gordon");
		c.setPublishDate(new Date());
		c.setContent("好");
		c.setVideoId(1);

		CommentDao cdao = new CommentDao();
		cdao.save(c);
	}

	@Test
	public void testFindVideoById() {
		Integer videoId = 1;
		VideoDao dao = new VideoDao();
		Video v = dao.findById(videoId);

		System.out.println("name: " + v.getName());
		System.out.println("path: " + v.getPath());
		System.out.println("hot: " + v.getHot());
	}

	@Test
	public void testFindAllVideo() {
		VideoDao dao = new VideoDao();
		List<Video> vs = dao.findAll();

		for (Video v : vs) {
			System.out.println("name: " + v.getName());
			System.out.println("path: " + v.getPath());
			System.out.println("hot: " + v.getHot());
			List<Comment> cms = v.getComments();
			for (Comment c : cms) {
				System.out.println("comment user name: " + c.getUserName());
			}
		}
	}

	@Test
	public void testSaveComment() {
		Comment c = new Comment();

		c.setUserName("gordon");
		c.setPublishDate(new Date());
		try {
			c.setContent(new String("好".getBytes(), "GBK"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		c.setVideoId(1);

		CommentDao cdao = new CommentDao();
		cdao.save(c);

	}

	@Test
	public void testFindCommentById() {
		Integer id = 1;
		CommentDao cdao = new CommentDao();
		Comment c = cdao.findById(id);
		System.out.println("user name: " + c.getUserName());
		System.out.println("publish date: " + c.getPublishDate());

	}

	@Test
	public void testJsonObjectByVideos() {
		List<Video> vs = new VideoDao().findAll();
		for (Video v : vs) {
			v.setComments(null);
			JSONObject jo = new JSONObject().fromObject(v);
			v.getComments();
			System.out.println(jo.toString());
		}
	}

	@Test
	public void testFindCommentsByVid() {
		List<Comment> comments = new CommentDao().findCommentsByVid(1);
		for (Comment c : comments) {
			System.out.println(c.getContent());
		}
	}
}
