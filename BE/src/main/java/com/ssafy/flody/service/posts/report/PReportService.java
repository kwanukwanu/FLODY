package com.ssafy.flody.service.posts.report;

import com.ssafy.flody.dto.request.posts.PostReportRequestDto;

public interface PReportService {
    public String addPostReport(String email, Long posNo, PostReportRequestDto requestDto) throws Exception;
}
