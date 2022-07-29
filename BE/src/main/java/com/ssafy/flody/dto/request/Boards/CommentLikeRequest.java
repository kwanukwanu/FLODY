package com.ssafy.flody.dto.request.Boards;

import com.ssafy.flody.domain.comments.likes.CLikes;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentLikeRequest {
    private Long comNo;
    private Long useNo;

    @Builder
    public CommentLikeRequest( Long comNo, Long useNo){
        this.comNo = comNo;
        this.useNo = useNo;
    }

    public CLikes toEntity(){
        return CLikes.builder()
                .comNo(comNo)
                .useNo(useNo)
                .build();
    }
}
