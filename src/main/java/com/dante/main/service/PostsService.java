package com.dante.main.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dante.main.domain.posts.PostsRepository;
import com.dante.main.domain.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	
	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto){
		return postsRepository.save(dto.toEntity()).getId();
	}
}
