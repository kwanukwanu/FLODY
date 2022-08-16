package com.ssafy.flody.service.posts;

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.posts.PostsRepository;
import com.ssafy.flody.domain.posts.categories.Categories;
import com.ssafy.flody.domain.posts.categories.CategoriesRepository;
import com.ssafy.flody.domain.posts.coverages.Coverages;
import com.ssafy.flody.domain.posts.coverages.CoveragesRepository;
import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.dto.request.posts.PostCreateRequestDto;
import com.ssafy.flody.dto.request.posts.PostUpdateRequestDto;
import com.ssafy.flody.dto.response.posts.PostDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostsRepository postRepository;
    private final CategoriesRepository categoryRepository;
    private final UsersRepository userRepository;
    private final CoveragesRepository coverageRepository;

    public List<PostDetailResponseDto> findPosts(String category) {
        List<Posts> entityList = postRepository.findAllByCategory(findCategory(category));
        List<PostDetailResponseDto> list = new ArrayList<>();
        for (Posts post : entityList) {
            list.add(new PostDetailResponseDto(post));
        }
        return list;
    }

    public PostDetailResponseDto findPostById(Long posNo) {
        return new PostDetailResponseDto(findPost(posNo));
    }

    public Long addPost(String email, PostCreateRequestDto requestDto) {
        Posts post = requestDto.toEntity(
                findUser(email),
                findCategory(requestDto.getCategory()),
                findCoverage(requestDto.getCoverage()));
        return postRepository.save(post).getPosNo();
    }

    public Long modifyPost(PostUpdateRequestDto requestDto) {
        Posts post = findPost(requestDto.getPosNo());
        post.update(
                requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getHashtag()
        );
        return postRepository.save(post).getPosNo();
    }

    public Long removePost(Long posNo) {
        postRepository.delete(findPost(posNo));
        return posNo;
    }

    public Posts findPost(Long posNo) {
        return postRepository.findById(posNo)
                .orElseThrow(() -> new IllegalArgumentException("Post Not Found"));
    }

    public Categories findCategory(String category) {
        return categoryRepository.findByName(category)
                .orElseThrow(() -> new IllegalArgumentException("Category Not Found"));
    }

    public Users findUser(String email) {
        return userRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException("User Not Found"));
    }

    public Coverages findCoverage(String coverage) {
        return coverageRepository.findByName(coverage)
                .orElseThrow(() -> new IllegalArgumentException("Coverage Not Found"));
    }

    public int findPostNum(String email) {
        return postRepository.findAllByUser(findUser(email)).size();
    }
}
