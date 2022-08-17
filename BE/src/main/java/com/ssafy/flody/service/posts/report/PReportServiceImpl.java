package com.ssafy.flody.service.posts.report;

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.posts.PostsRepository;
import com.ssafy.flody.domain.posts.reports.PReportsRepository;
import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.dto.request.posts.PostReportRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PReportServiceImpl implements PReportService{
    private final PReportsRepository postReportRepository;
    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;

    public String addPostReport(String email, Long posNo, PostReportRequestDto requestDto) throws Exception{
        Posts post = findPost(posNo);
        Users user = findUser(email);
        if (!postReportRepository.findByUserAndPost(user, post).isPresent()){
            postReportRepository.save(new PostReportRequestDto().toEntity(user, post, requestDto.getContent()));
            return "신고가 성공적으로 접수되었습니다.";
        }else {
            return "이미 신고한 게시글 입니다.";
        }
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
