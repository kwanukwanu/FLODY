package com.ssafy.flody.dto.response.dmessages;

import com.ssafy.flody.domain.dmessages.DirectMessages;
import lombok.Getter;

import java.util.Date;

@Getter
public class DMessagesDetailResponseDto {
    private Boolean type;
    private String content;
    private Date time;
    private Boolean like;
    private Boolean check;

    public DMessagesDetailResponseDto(DirectMessages entity){
        this.type = entity.getType();
        this.content = entity.getContent();
        this.time = entity.getTime();
        this.like = entity.getLike();
        this.check = entity.getCheck();
    }
}
