# naver0829study
네이버 클라우드 과정 3기 수업

>>git-bash 명령어
 1. git init >> git과 연동할 폴더 초기화
 2. git remote add origin https://github.com/ssomal62/naver0829study.git >> git 원격저장소에 새로 연결
 3. 오류가 나서 새로운 깃 저장소가 연결이 안될 경우
    git remote set-url origin https://github.com/ssomal62/naver0829study.git >> 기존 연결된 저장소를 끊고 새로 연결.
 4. git branch >> branch 조회
 5. git add. 또는 git add 파일명 >> 해당 파일들을 로컬 저장소에 추가    //5~7단계는 세트 과정
 6. git commit -m 메세지 >> 해당 메세지와 함께 위의 파일들을 로컬저장소에 커밋
 7. git push origin 브랜치명 >> 원격저장소의 해당 브랜치에 소스 보내기 (반대는 8번)
 8. git pull origin 브랜치명 >> 원격저장소의 수정된 내용을 가져올 경우.
 9. git checkout 브랜치명 >> 지정한 브랜치명으로 이동

>>git-bash 초기세팅 -> 처음 한번만 유저명 확인  
  git config --global user.name "사용자명"  
  git config --global user.email "사용자이메일"  

>>파일 읽기 (ex, README.md)
1. cat README.md

>>git 명령어 정리 사이트  
  https://gorokke.tistory.com/22

