package com.ssafy.flody.domain.dmessages.likes;

import com.ssafy.flody.domain.dmessages.DirectMessages;
import com.ssafy.flody.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DLikesId implements Serializable {
    private DirectMessages directMessage;
    private Users user;
}
