package com.ssafy.flody.dto.response.Users;

import com.ssafy.flody.domain.dmessages.DMessages;
import lombok.Getter;

@Getter
public class DMessagesListResponse {
    private Long dmNo;
    private Long sender;
    private Long receiver;

    public DMessagesListResponse(DMessages entity){
        this.dmNo = entity.getDmNo();
        this.sender = entity.getSender();
        this.receiver = entity.getReceiver();
    }
}
