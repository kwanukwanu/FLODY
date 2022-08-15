package com.ssafy.flody.service.comments;

import com.ssafy.flody.dto.request.comments.CommentCreateRequestDto;
import com.ssafy.flody.dto.request.comments.CommentUpdateRequestDto;
import com.ssafy.flody.dto.response.comments.CommentListResponseDto;

import java.util.List;

public interface CommentService {
    public List<CommentListResponseDto> findComments(Long posNo);
    public Long addComment(String email, CommentCreateRequestDto requestDto);
    public Long modifyComment(CommentUpdateRequestDto requestDto);
    public Long removeComment(Long comNo);
}
