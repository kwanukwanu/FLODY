package com.ssafy.flody.service.boards;

import com.ssafy.flody.dto.request.Boards.BoardCreateRequest;

public interface BoardsService {
    boolean addBoard(BoardCreateRequest bcr);
}
