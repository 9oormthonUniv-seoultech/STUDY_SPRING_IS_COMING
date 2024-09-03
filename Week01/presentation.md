# 스터디 발표 자료
발표자 : 신중은
## 0. 실습 버전에 대한 고민

### **스터디 목적**

- **목표**: 스프링을 실무에서 잘 활용할 수 있도록 학습하는 것.
- **접근 방식**: 책의 예제를 그대로 따라 하기보다는 최신 기술 스택을 사용하여 실습.

### **이유: 최신 버전의 필요성**

- **기술 변화의 속도**: 하루가 다르게 변화하는 기술 시장에서 2019년에 나온 책을 그대로 따라하는 것은 비효율적.
- **업데이트된 기능 및 보안**: 최신 버전에서는 새로운 기능과 보안 개선이 포함되어 있어 실제 프로젝트 환경에서 더 나은 선택이 됨.

### **구체적인 선택**

1. **Gradle 버전 사용**: 최신 버전인 Gradle 8.x를 사용하여 최신 Spring Boot와 호환되도록 설정.
2. **Spring Boot 버전 선택**: Spring Boot 3.x 사용을 통해 최신 기능을 활용하고, Java 17 등의 최신 Java 버전과의 호환성을 보장.
3. 책의 내용도 함께 학습 진행과 차이점도 정리하는 방식.

## **1. Spring Boot 버전 차이점**

### **Spring Boot 2.1.9 vs Spring Boot 3.3.3**

- **Spring Boot 2.x**: Gradle 7.x와 호환이 잘 되며, Java 8 이상의 버전을 지원.
- **Spring Boot 3.x**: Gradle 8.x 이상을 사용할 때 적합하며, Java 17 이상을 권장. 최신 기능과 성능 최적화가 포함되어 있음.

### **최신 버전 사용의 이점**

- **최신 기능 및 성능 최적화**: 최신 버전의 프레임워크를 사용할 때 최신 기술과 성능 개선이 포함됨.
- **보안 업데이트**: 최신 버전은 더 나은 보안 패치를 포함하고 있음.
- **기술 진화에 따른 적응**: 최신 기술 스택을 사용하는 것이 더 유연한 개발 환경을 제공.

---

## **2. Gradle 설정 변경**

### **Gradle 설정 파일 (`build.gradle`)**

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.3.3'
    id 'io.spring.dependency-management' version '1.1.6'
}

group = 'com.jojoidu.book'
version = '0.0.1-SNAPSHOT'

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}

tasks.named('test') {
    useJUnitPlatform()
}

```

- `io.spring.dependency-management` : 스프링 부트의 의존성들을 관리해 주는 플러그인 ( 필수 ! )
- `repositories` 각종 의존성(라이브러리)들을 어떤 원격 저장소에서 받을지를 정한다.
- `tasks.named('test')` : Junit5를 사용하기 위해서는 필수로 선언되어야 합니다.
- `dependencies` : 프로젝트 개발에 필요한 의존성들을 선언하는 곳.

### **주요 변경 사항**

- **플러그인 관리**: **`plugins {}`** 블록을 사용하여 최신 방식으로 플러그인 선언.
- **Java 17 사용**: **`java.toolchain`** 설정을 통해 Java 17을 사용하도록 지정.
- **의존성 관리**: **`implementation`**과 **`testImplementation`**으로 의존성을 관리하여 Gradle 6 이후의 변경 사항에 적응.

---

## **3. `apply plugin` vs `plugins` 블록**

- **`apply plugin` (레거시 방법)**: 유연성이 높고 비공식 레포지토리 플러그인도 사용 가능. 그러나 최신 Gradle에서는 권장되지 않음.
- **`plugins {}` (최신 방법)**: 공식 Gradle 플러그인 레포지토리만 사용 가능하지만, 빌드 프로세스 최적화 및 에디터 지원 기능 향상.
- **참고 링크**: [StackOverflow: Gradle Plugin Differences](https://stackoverflow.com/questions/32352816/what-the-difference-in-applying-gradle-plugin)

---

## **4. JCenter 사용 중단**
![image](https://github.com/user-attachments/assets/f37f35e5-d16a-4755-a15f-9637d018ef2c)


- **JCenter 종료**: JCenter는 더 이상 사용할 수 없으며, 모든 의존성을 Maven Central로 이전해야 함.
- 개발자가 직접 만든 라이브러리를 업로드 하는 걸 쉽게 도와주는 도구가 jcenter 라고 소개
- 도구와 플러그인의 발전 덕분에 이 과정이 상당히 간소화되었다. (다만 아직 jcenter에는 있지만, mavenCentral에는 없는게 있긴 하다고 한다.)
- **관련 링크**: [JCenter Shutdown Announcement](https://blog.gradle.org/jcenter-shutdown), https://dev.gmarket.com/114

---

## **5. Gradle 의존성 선언 방식 변화**

- **변경 전**: **`compile`**, **`testCompile`** 사용
- **변경 후**: **`implementation`**, **`testImplementation`** 사용
    - **`compile`**, **`testCompile`**은 Gradle 6부터 Soft Deprecate 됨.

관련 링크 : https://jojoldu.tistory.com/538
