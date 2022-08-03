# :pushpin: pingpong
>사내 협업 채팅 웹 애플리케이션  
>목표 : Websocket, React.js, Spring의 숙련도 향상
</br>

## 1. 제작 기간 & 참여 인원
- 2021년 11월 27일 ~ 12월 26일
- 팀 프로젝트
- 참여인원 3명

</br>

## 2. 사용 기술
#### `Back-end`
  - Java 8
  - Spring Boot
  - Gradle
  - Spring Data JPA
  - mybatis
  - Redis
  - MySQL
  
#### `Front-end`
  - React.js
  - Bootstrap

</br>

## 3. ERD 설계

 ![](https://github.com/hakyeonghoon1/pingpong/blob/main/docs/ERD.png)


## 4. 핵심 기능
이 서비스의 핵심 기능은 채팅 & 게시판 기능입니다.  
팀 단위 워크스페이스를 옮겨 다니며 채팅 및 게시판을 사용할 수 있습니다.  
팀원을 추가할 때는 초대 기능을 사용하여 팀원을 초대합니다.


<details>
<summary><b>핵심 기능 설명 펼치기</b></summary>
<div markdown="1">
 
### 4.1 채팅방 websocket 연결
 
 ![](https://github.com/hakyeonghoon1/pingpong/blob/main/docs/핵심기술채팅.png)
 [주요코드확인](https://github.com/hakyeonghoon1/pingpong-frontend/blob/main/frontend/src/component/Chat/Chat.js#L78)
 - 채팅방 클릭시 웹소켓을 연결합니다.
 - 다른 채팅방 클릭시 기존의 웹소켓의 연결을 끊고, 새로운 연결을 요청합니다.
 - 위의 방법을 선택한 이유 : 웹소켓을 하나만 연결해두고 채팅을 구현하려하니 채팅방을 들어가지 않아도 데이터 전송량이 많아져 이 문제를 해결하기 위함
 - sockJS 사용 이유 : SockJS를 적용해 WebSocket을 지원하지 않는 브라우저에서 서버와 클라이언트 간 통신 연결을 

 ### 4.2 초대장 전송(팀원 초대)
 
 ![](https://github.com/hakyeonghoon1/pingpong/blob/main/docs/%EC%B4%88%EB%8C%80%EC%9E%A5%20%EC%A0%84%EC%86%A1.png)
[주요코드확인1](https://github.com/hakyeonghoon1/pingpong/blob/main/src/main/java/com/douzone/pingpong/controller/api/ApiInviteController.java#L20)
[주요코드확인2](https://github.com/hakyeonghoon1/pingpong-frontend/blob/main/frontend/src/component/Main/InvitationList.js#L47)
 - 팀원 초대시 해당 팀의 아이디로 해당 멤버를 초대합니다.
 - 클라이언트 자신의 아이디로된 topic을 subscribe하고 있습니다.
 
### 4.3 채팅
![](https://github.com/hakyeonghoon1/pingpong/blob/main/docs/%EC%B1%84%ED%8C%85.png)
[주요코드확인](https://github.com/hakyeonghoon1/pingpong-frontend/blob/main/frontend/src/component/Chat/Chat.js#L157)
 - 채팅 입력시 publish하여 채팅을 전송
 
### 4.4 게시판 및 댓글을 활용한 의견공유 
![](https://github.com/hakyeonghoon1/pingpong/blob/main/docs/%EA%B2%8C%EC%8B%9C%ED%8C%90.png)
- 해당 게시물 클릭시 우측에 각 게시물의 댓글 리스트가 나타남
- 글의 작성자만 글을 삭제,수정할 수 있는 분기 처리
 
</div>
</details>

</br>

## 5. 트러블 슈팅

### 5.1. 웹소켓 연결 방법 정하기
- 웹소켓을 하나만 열어놓고 여러개의 대화방을 통신하려하다보니 웹소켓이 열린 상태에서 너무 많은 데이터가 전송됨
- 해결방법 : 채팅방을 이동할 때마다 웹소켓을 열고 닫는 방법을 채택하였습니다.

### 5.2. 1:1 대화방 이름 생성문제
- 1:1 대화방 생성시 상대방에게는 내 이름이, 나에게는 상대방의 이름이 나타나게 하기가 어려웠습니다.
- 해결방법 : 대화방 생성시 DB에 (본인이름)/(상대방이름)을 저장해 두고, 프론트 엔드 영역에서 로그인한 이름과 다른 이름을 표시하도록하여 해결하였습니다.


</br>


</br>

## 6. 회고 / 느낀점
>
- WebScocket 사용시 sockJS를 사용하는 이유, stomp의 장점 등에 대해 공부할 수 있는 좋은 기회였습니다.
- git을 활용한 팀원들간의 협업 능력을 수련시킨 좋은 기회였습니다.
- react.js 활용하여 설계부터 제작까지하며 react.js의 숙련도를 향상시킨 좋은 기회였습니다.

