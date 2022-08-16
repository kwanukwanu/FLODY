package com.ssafy.flody.service.posts.like;

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.posts.PostsRepository;
import com.ssafy.flody.domain.posts.likes.PLikes;
import com.ssafy.flody.domain.posts.likes.PLikesRepository;
import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.dto.request.posts.PostLikeRequestDto;
import com.ssafy.flody.dto.response.users.UserFollowResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PLikeServiceImpl implements PLikeService{
    private final PLikesRepository postLikesRepository;
    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;

    public Long addPostLike(String email, Long posNo) throws Exception{
        Posts post = findPost(posNo);
        Users user = findUser(email);
        if (!postLikesRepository.findByUserAndPost(user, post).isPresent()){
            return postLikesRepository.save(new PostLikeRequestDto().toEntity(user, post)).getPlNo();
        }else {
            return null;
        }

    }

    public Long removePostLike(String email, Long posNo){
        Posts post = findPost(posNo);
        Users user = findUser(email);
        PLikes postLike = postLikesRepository.findByUserAndPost(user, post)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않습니다"));
        postLikesRepository.delete(postLike);
        return posNo;

    }



    public Users findUser(String email) {
        return usersRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));
    }

    public Posts findPost(Long posNo) {
        return postsRepository.findById(posNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다"));
    }
}
