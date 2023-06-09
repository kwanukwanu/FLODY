package com.ssafy.flody.service.posts;

import com.ssafy.flody.dto.request.posts.PostCreateRequestDto;
import com.ssafy.flody.dto.request.posts.PostUpdateRequestDto;
import com.ssafy.flody.dto.response.posts.PostDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public class PostServiceImpl implements PostService {
    private final PostsRepository postRepository;
    private final CategoriesRepository categoryRepository;
    private final UsersRepository userRepository;
    private final CoveragesRepository coverageRepository;

    public List<PostDetailResponseDto> findPosts(String category, Pageable pageable) {
        List<Posts> entityList;
        if (category.equals("게시판"))
            entityList = postRepository.findAllByCategoryNotOrderByPosNoDesc(findCategory("뉴스피드"), pageable);
        else
            entityList = postRepository.findAllByCategoryOrderByPosNoDesc(findCategory(category), pageable);
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
