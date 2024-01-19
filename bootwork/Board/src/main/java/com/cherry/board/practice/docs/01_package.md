

### 패키지 구조의 이해


#### controller

* 요청과 응답을 처리

#### service 

* 비지니스 로직을 처리

#### domain

* 비지니스 로직을 표현하는 객체
* ex) `BlogPost.java` : 비즈니스 규칙과 게시물의 비즈니스 로직

#### dto (Data Transfer Object)

* 데이터를 전송하거나 전달하는데 사용하는 객체 모음
* 보통 엔터티 객체나 도메인 객체의 일부 데이터를 추출하여 전달하거나, 여러 객체의 데이터를 조합하여 필요한 형태로 변환


#### entity

* 데이터베이스의 특정 테이블과 매핑되는 객체


#### repository/mapper

* JPA 또는 스프링 데이터를 사용하는 데이터 접근 계층의 인터페이스를 포함

#### exception

* 사용자 정의 예외 클래스들을 포함

#### util

* 애플리케이션 전반에 걸쳐 재사용 가능하고 범용적인 기능을 제공하는 클래스들을 포함.
* 정적(static) 메서드나 상수들을 주로 포함
* ex) 암호화 및 보안 유틸리티, 파일 처리 유틸리티, 날짜 및 시간 유틸리티 등.
