package com.douzone.pingpong.domain.chat;

import com.douzone.pingpong.domain.member.Member;
import com.douzone.pingpong.domain.room.Room;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@DynamicInsert
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Chat implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;              // sender

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;                  // 대화방 정보

    private String message;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @Column(name = "not_read_count")
    private Integer notReadCount;

    @Builder
    public Chat (Room room, Member member, String message) {
        this.room = room;
        this.member = member;
        this.message = message;
        this.notReadCount = 1;
        this.date = LocalDateTime.now();
    }

    // == 생성 메서드 ==//
    public static Chat createChat(Room room, Member member, String message) {
        Chat chat = new Chat();
        chat.setRoom(room);
        chat.setMember(member);
        chat.setMessage(message);
        chat.setDate(LocalDateTime.now());
        chat.setNotReadCount(1);
        return chat;
    }

    // == 연관관계 메서드 == //
    public void setMember(Member member) {
        this.member = member;
        member.getChats().add(this);
    }

    public void setRoom(Room room) {
        this.room = room;
        room.getChats().add(this);
    }

    // == 비지니스 로직 == //
    public void deleteChat() {
        this.message = "삭제된 메시지 입니다.";
    }
}
