package com.ssafy.flody.service.posts.like;

import com.ssafy.flody.domain.comments.Comments;
import com.ssafy.flody.domain.comments.CommentsRepository;
import com.ssafy.flody.domain.comments.likes.CLikes;
import com.ssafy.flody.domain.comments.likes.CLikesRepository;
import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.dto.request.comments.CommentLikeRequestDto;
import com.ssafy.flody.dto.request.posts.PostLikeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CLikeServiceImpl implements CLikeService {
    private final CLikesRepository commentLikesRepository;
    private final UsersRepository usersRepository;

    private final CommentsRepository commentsRepository;

    public Long addCommentLike(String email, Long comNo) throws Exception{
        Comments comment = findComment(comNo);
        Users user = findUser(email);
        if (!commentLikesRepository.findByUserAndComment(user, comment).isPresent()){
            return commentLikesRepository.save(new CommentLikeRequestDto().toEntity(comment, user)).getClNo();
        }else {
            return null;
        }

    }

    public Long removeCommentLike(String email, Long clNo){
        Comments comment = findComment(clNo);
        Users user = findUser(email);
        CLikes commentLike = commentLikesRepository.findByUserAndComment(user, comment)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않습니다"));
        commentLikesRepository.delete(commentLike);
        return clNo;

    }



    public Users findUser(String email) {
        return usersRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));
    }

    public Comments findComment(Long comNo) {
        return commentsRepository.findById(comNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다"));
    }
}
