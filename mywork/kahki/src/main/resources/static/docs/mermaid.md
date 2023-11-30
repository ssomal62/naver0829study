
```mermaid
erDiagram

   "MEMBER" ||..o{ "EVENT" : "이벤트를 등록한다"
   "MEMBER" |o..o{ "COMMENT" : "코멘트를 작성한다"
   "EVENT" |o..o| "COMMENT" : "코멘트 기능을 생성한다"
 
    "MEMBER" {
        int member_id  PK
        String user_id
        String user_pw
        String profile_image_url
    }

    "EVENT" {
        int event_id PK
        int user_id FK
        DATETIME e_sta_date
        DATETIME e_end_date
        String title
        String content
    }

    "COMMENT" {
        int comment_id PK
        int event_id FK
        int user_id FK
        DATETIME comment_date
        String content
    }
    

```

```
    "EVENT_CONTENT" {
        INT content_id PK
        String content
    }

```


|           사용자           |           개발자           |
|:-----------------------:|:-----------------------:|
| 현재 날짜로 달력이 보임<br>일정은 없음 | 현재 날짜로 달력을 출력<br> 일정은 없음 |
|          로그인한다          |                         |
|        내 일정이 보임         |                         |


* 유저가 로그인한다.
* 현재 날짜로 달력이 나오되 유저가 작성한 일정이 나온다.
* 등록할 날짜를 선택한다.

* 유저가 입력한 날짜를 찾는다.
* 해당 날짜의 일정을 모두 찾는다. 
* 타임순으로 정렬한다.


DATE 현재 연+월 에 에서 

