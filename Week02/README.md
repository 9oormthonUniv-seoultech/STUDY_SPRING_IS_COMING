# 2주차 스터디
| 주차  | Chapter | 발제자 | 서기 | 일시 |
|-------|---------|--------|------|------|
| 2주차 | Chapter 2 | 박진홍 | 차서윤     | 2024.09.14 10시 |

### 블로그

| 팀원 이름 | 게시물 링크 |
|-----------|-------------|
| 신중은    | [스프링에서 swagger 세팅하기 1편](https://haward.tistory.com/248) |
| 박진홍    | [스프링 부트에서 테스트 코드 작성](https://jiinhong.github.io/posts/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%97%90%EC%84%9C-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%BD%94%EB%93%9C-%EC%9E%91%EC%84%B1/) |
| 차서윤    | [스프링 로그 분석하기](https://velog.io/@sunyou10/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%A1%9C%EA%B7%B8-%EB%B6%84%EC%84%9D%ED%95%98%EA%B8%B0) |
| 임채영    | [Column의 기본값을 설정하는 방법들](https://velog.io/@chaeyounge/Column%EC%9D%98-%EA%B8%B0%EB%B3%B8%EA%B0%92%EC%9D%84-%EC%84%A4%EC%A0%95%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95%EB%93%A4) |
| 이지원    | [Thymeleaf 엔진이란](https://easy1nhard2.tistory.com/13)) |

---

## 스터디 기록
### 테스트 코드가 필요한 이유

- **빠른 피드백** : 프로그램을 재시작할 때의 비효율성 개선
- **수동검증 → 자동검증** : 성공 / 실패 여부만 자동으로 검증할 수 있어 편리
- **기능을 안전하게 보호** : 통합적으로 나머지도 잘됨을 보장

### HelloController 테스트 코드 작성

#### @SpringBootApplication 과 @RestController

- @ExtendWith 와 @WebMvcTest
    - @WebMvcTest 가 @ExtendWith 를 포함하고 있음
- @SpringbootTest 와 @WebMvcTest
    - @WebMvcTest : 컨트롤러 레이어에서만 테스트 (단위 테스트)
        - 전체 빈을 로드하진 않음
        - 지정한 컨트롤러 레어어만 신속하게 테스트
    - @SpringbootTest : 전체 컨텍스트 로딩! (통합 테스트)
    - 컨트롤러에 대해서만 빠르게 ⇒ @WebMvcTest
    - 전체적으로 ⇒ @SpringbootTest

#### Test 코드 작성

- @DisplayName : 테스트하고 싶은 내용을 이름으로 써서 가독성을 높일 수 있음
    - 메시지 출력 가능

### HelloController 코드를 롬복으로 전환

- 롬복 소개 및 설치
    - 롬복: 코드를 깔끔하게 보이기 위해 사용되는 라이브러리
    - 설치
        - build.gradle 수정
        - 설정에서 Enable Annotation 체크
- @Getter : 기본 메소드 없이도, 어노테이션만으로 깔끔하게 표현 가능
- @RequiredArgsConstructor : final 붙은 모든 변수 초기화



### AssertThat

- 값을 검증하는 다양한 방법이 있음
- 다양한 검증이 있으니 찾아보는 걸 추천!



### TDD

- 단위 테스트랑은 다름!
- **테스트가 주도하는 개발**
    - 과정
        1. 실패하는 테스트 코드짜기 (먼저!)
        2. 그 다음 코드를 짬 → ***테스트 코드를 어떻게든 성공시키게끔 구현***
        3. ‘성공’ 상태를 유지한 채로 코드를 개선시킴
    - TDD는 불가능 ? 하다.
        - 보통 단위 테스트로 많이 짬
        - 실무에서는 TDD할 시간이 없음,,,
        - ***테스트를 짰으면 왜 짰는지 이유를 아는게 중요 !***

### BDD

- GWT 패턴 : given → when → then
- ‘단위테스트’ 라는 책 추천 !



### Spring REST Docs

- 테스트를 성공해야 문서화 !
    - Swagger 보다 보수적

**⇒ 테스트 코드 작성하면 Spring REST Docs 사용 가능 !**
