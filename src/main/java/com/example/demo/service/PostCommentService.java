package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PostCommentDto;
import com.example.demo.model.Post;
import com.example.demo.model.PostComment;
import com.example.demo.repository.PostCommentRepository;
import com.example.demo.repository.PostRepository;

@Service
public class PostCommentService {
	@Autowired
	EntityManagerFactory emf;
	@Autowired
	PostCommentRepository postCRepo;
	@Autowired
	PostRepository postRepo;
	public void postComment(Long id,PostCommentDto postComment)
	{
		/*EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
*/
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		/*Session session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();*/		
		PostComment postComt=new PostComment();
		postComt.setPostComment(postComment.getPostComment());
		Post p=postRepo.getOne(id);
		postComt.setPost(p);
		///postCRepo.save(post);
		List<PostComment> list=p.getCommentList();
		list.add(postComt);
		p.setCommentList(list);
		p.setNoOfComments(list.size());
		/*em.persist(p);
		em.getTransaction().commit();*/
		session.persist(p);
		session.getTransaction().commit();
		session.close();
		///postRepo.save(p);		
	}
	
	public void deleteComment(Long id)
	{
		PostComment postCommwnt=postCRepo.getOne(id);
		Post post=postRepo.getOne(postCommwnt.getPost().getId());
		postCRepo.deleteById(id);
		post.setNoOfComments(post.getCommentList().size());
		postRepo.save(post);	
	}
	
	public Optional<PostComment> getParticularComment(Long id)
	{
		return postCRepo.findById(id);
	}
	
	public List<PostComment> getAllComments()
	{
		return postCRepo.findAll();
	}
	
	// Third Commit to check 

}
