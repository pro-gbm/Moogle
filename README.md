# Moogle

## 백엔드

역할분담

| 순번 | 역할 | 담당자 | 비고 |
| --- | --- | --- | --- |
| 1 | 인프라 구성 | 차민석, 이지성 |  |
| 2 | api 호출해서 DB 저장 - batch 각자 JSON 파싱하기 | 차민석<br>이지성<br>류건희<br>류건희<br>이아름<br>백정현<br>백정현 | 1. 영화<br>2. 드라마<br>3. 장르<br>4. 감독<br>5. 배우<br>6. 국가<br>7. ott 정보 |
| 3 | 프론트랑 통신하는 api | 다같이 |  |
| 4 | Redis | 백정현 |  |
| 5 | Logging (ELK, GRAFANA, ETC…) | 류건희 |  |
| 6 | 점수 계산 |  |  |
| 7 | 스프링 Batch, Jenkins | 차민석 |  |
| 8 | swagger 셋팅 | 류건희 |  |
| 9 | AOP - rest api 응답객체 등 | 류건희 |  |

## 문서

- Docs : https://docs.google.com/spreadsheets/d/1frx-HwRDXj-0Em4smTqP-3uuJPsvxX3YmO3axEKOyPA/edit#gid=0
- Notion : https://www.notion.so/Moogle-0203b0a8c77b43b09097aa2715b32153

## 코드 컨벤션
### 프론트엔드 코딩컨벤션

- Prettier
- 한 줄 노노 (if, for 이런 거 쓸 때 멀티라인 부탁 ^^)
- 명명법 camel 고고 ^^

### 백엔드 코딩컨벤션

**자바**

- 코드 컨벤션 : [https://myeonguni.tistory.com/1596](https://myeonguni.tistory.com/1596)
- API : [https://docs.oracle.com/javase/17/docs/api/](https://docs.oracle.com/javase/8/docs/api/)
- 메서드 네이밍 : [https://tecoble.techcourse.co.kr/post/2020-04-26-Method-Naming/](https://tecoble.techcourse.co.kr/post/2020-04-26-Method-Naming/)

### 커밋 컨벤션

![Untitled](https://user-images.githubusercontent.com/51734158/200279522-463b0b79-a967-4022-bc4a-7d00f9150c80.png)

- 대괄호 안에 태그
- 커밋메시지는 정 필요한 경우 아니면 전부 영문 소문자
- 관련 이슈는 # 태그를 달아서 언급, 언급 위치는 대괄호 안
  ```
  [Feat] add createMoive method 
  [Fix #19] fix input box error for typing
  ```

### Branch 전략
- git-flow 사용 ( feature -> develop -> master 계층구조)
- feature branch 네이밍 예시 : feature/GBM01-22
- develop branch 에서 feature 단위 브랜치 생성 후 develop 에 PR 후 merge
- PR merge 할 때에는 commit graph 정리를 위해 `squash & merge` or `rebase & merge` 사용
- 최종적으로 develop -> master 
