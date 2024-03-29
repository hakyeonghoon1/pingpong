package com.douzone.pingpong.controller.api;

import com.douzone.pingpong.controller.api.dto.member.WsInvitationDto;
import com.douzone.pingpong.domain.member.Member;
import com.douzone.pingpong.security.argumentresolver.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiInviteController {

    @Autowired
    private SimpMessagingTemplate webSocket;

    /**
     *
     * @param loginMember
     * @param teamId
     * @param receiver
     *
     * 팀원 초대 초대장 전송
     */
    @RequestMapping(value="/wsInvite/{teamId}/{receiver}")
    public void wsInvite(@Login Member loginMember, @PathVariable("teamId") Long teamId, @PathVariable("receiver") Long receiver){

        webSocket.convertAndSend("/sub/"+receiver,teamId);
    }
}
