package com.ssafy.flody.dto.request.Users;

import com.ssafy.flody.domain.dmessages.DMessages;
import com.ssafy.flody.domain.dmessages.likes.DLikes;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DMessagesLikeRequest {
    private Long useNo;
    private Long dmNo;

    @Builder
    public DMessagesLikeRequest(
            Long useNo, Long dmNo
    ){
        this.useNo = useNo;
        this.dmNo = dmNo;
    }

    public DLikes toEntity(){
        return DLikes.builder()
                .useNo(useNo)
                .dmNo(dmNo)
                .build();
    }

}
