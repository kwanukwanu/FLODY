package com.ssafy.flody.service.comments;

import com.ssafy.flody.domain.comments.Comments;
import com.ssafy.flody.domain.comments.CommentsRepository;
import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.posts.PostsRepository;
import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.dto.request.comments.CommentCreateRequestDto;
import com.ssafy.flody.dto.request.comments.CommentUpdateRequestDto;
import com.ssafy.flody.dto.response.comments.CommentKidListResponseDto;
import com.ssafy.flody.dto.response.comments.CommentListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentsRepository commentRepository;
    private final PostsRepository postRepository;
    private final UsersRepository userRepository;

    public List<CommentListResponseDto> findComments(Long posNo) {
        List<Comments> upperEntityList = commentRepository.findAllByPostAndUpper(findPost(posNo), null);
        List<CommentListResponseDto> list = new ArrayList<>();
        for (Comments comment : upperEntityList) {
            List<Comments> kidEntityList = commentRepository.findAllByUpper(comment.getComNo());
            List<CommentKidListResponseDto> kidList = new ArrayList<>();
            for (Comments kidComment : kidEntityList) {
                kidList.add(new CommentKidListResponseDto(kidComment));
            }
            list.add(new CommentListResponseDto(comment, kidList));
        }
        return list;
    }

    public Long addComment(String email, CommentCreateRequestDto requestDto) {
        Long upperNo = requestDto.getUpper();
        if (upperNo != null) {
            Comments upper = findComment(upperNo);
            upper.addKid(upper.getPostDate());
            commentRepository.save(upper);
        }
        return commentRepository.save(
                requestDto.toEntity(
                        findUser(email),
                        findPost(requestDto.getPosNo())
                )
        ).getComNo();
    }

    public Long modifyComment(CommentUpdateRequestDto requestDto) {
        Comments comment = findComment(requestDto.getComNo());
        comment.update(requestDto.getContent(), requestDto.getPostDate());
        return commentRepository.save(comment).getComNo();
    }

    public Long removeComment(Long comNo) {
        Comments comment = findComment(comNo);
        if (comment.getUpper() != null) {
            Comments upper = findComment(comment.getUpper());
            upper.subKid(upper.getPostDate());
            commentRepository.save(upper);
        } else {
            List<Comments> kidList = commentRepository.findAllByUpper(comment.getComNo());
            commentRepository.deleteAll(kidList);
        }
        commentRepository.delete(comment);
        return comNo;
    }

    public Comments findComment(Long comNo) {
        return commentRepository.findById(comNo)
                .orElseThrow(() -> new IllegalArgumentException("Comment Not Found"));
    }

    public Posts findPost(Long posNo) {
        return postRepository.findById(posNo)
                .orElseThrow(() -> new IllegalArgumentException("Post Not Found"));
    }

    public Users findUser(String email) {
        return userRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException("User Not Found"));
    }
}
