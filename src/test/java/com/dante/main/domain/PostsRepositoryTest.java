package com.dante.main.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dante.main.domain.posts.Posts;
import com.dante.main.domain.posts.PostsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup(){
		/** 
    	���� �׽�Ʈ �ڵ忡 ������ ��ġ�� �ʱ� ���� 
    	�׽�Ʈ �޼ҵ尡 ������ ���� respository ��ü ���� �ڵ�
        **/
		postsRepository.deleteAll();
	}
	
	@Test
	public void getBoardList(){
		//given 
		postsRepository.save(Posts.builder()
				.title("����")
				.content("����")
				.author("dante0806@naver.com")
				.build());
		
		//when
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("����"));
		assertThat(posts.getContent(), is("����"));
	}
	
	@Test
	public void InsertBaseTimeEntity(){
		//given
		LocalDateTime now = LocalDateTime.now();
		postsRepository.save(Posts.builder()
				.title("����")
				.content("����")
				.author("dante0806@naver.com")
				.build());
		//when
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertTrue(posts.getCreatedDate().isAfter(now));
		assertTrue(posts.getModifiedDate().isAfter(now));
	}
}
