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
    	이후 테스트 코드에 영향을 끼치지 않기 위해 
    	테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
        **/
		postsRepository.deleteAll();
	}
	
	@Test
	public void getBoardList(){
		//given 
		postsRepository.save(Posts.builder()
				.title("제목")
				.content("테스트 내용")
				.author("dante0806@naver.com")
				.build());
		
		//when
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("제목"));
		assertThat(posts.getContent(), is("테스트 내용"));
	}
	
	@Test
	public void InsertBaseTimeEntity(){
		//given
		LocalDateTime now = LocalDateTime.now();
		postsRepository.save(Posts.builder()
				.title("제목")
				.content("테스트 내용")
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
