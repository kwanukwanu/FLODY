package com.ssafy.flody.dto.request.Boards;


//request로 유저 넘버/ 카테고리 넘버를 받을 수 있을지 : 포스팅 시에 카테고리 넘버만 받고 service에서 처리한다고 했던 기억 O
public class BoardCreateRequest {
    private long useNo;
    private long catNo;
    private long covNo;
    private String title;
    private String content;
    private String hashtag;

}
