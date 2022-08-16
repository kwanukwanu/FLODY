package com.ssafy.flody.service.posts.scrap;

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.posts.PostsRepository;
import com.ssafy.flody.domain.posts.likes.PLikes;
import com.ssafy.flody.domain.posts.likes.PLikesRepository;
import com.ssafy.flody.domain.posts.scraps.Scraps;
import com.ssafy.flody.domain.posts.scraps.ScrapsRepository;
import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.dto.request.posts.PostLikeRequestDto;
import com.ssafy.flody.dto.request.posts.PostScrapRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PScrapServiceImpl implements PScrapService {
    private final ScrapsRepository scrapsRepository;
    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;

    public Long addPostScrap(String email, Long posNo) throws Exception{
        Posts post = findPost(posNo);
        Users user = findUser(email);
        if (!scrapsRepository.findByUserAndPost(user, post).isPresent()){
            return scrapsRepository.save(new PostScrapRequestDto().toEntity(user, post)).getScrNo();
        }else {
            return null;
        }

    }

    public Long removePostScrap(String email, Long posNo){
        Posts post = findPost(posNo);
        Users user = findUser(email);
        Scraps scraps = scrapsRepository.findByUserAndPost(user, post)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않습니다"));
        scrapsRepository.delete(scraps);
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
