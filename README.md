# React Spring 프로젝트

Spring Boot 3.4.2와 WebFlux를 사용한 리액티브 애플리케이션입니다. 이 프로젝트는 Java 23으로 개발되었으며, 파일 업로드 및 리액티브 프로그래밍 패턴을 구현하고 있습니다.

## 기술 스택

- **Java**: Java 23
- **Framework**: Spring Boot 3.4.2
- **리액티브 프로그래밍**: Spring WebFlux
- **웹 API**: Spring WebMVC
- **빌드 도구**: Gradle
- **로깅**: SLF4J
- **코드 간소화**: Lombok
- **테스트**: JUnit, Reactor Test

## 주요 기능

### 리액티브 API

- 비동기 방식으로 데이터를 처리하는 리액티브 엔드포인트
- `Mono`와 `Flux` 기반의 데이터 스트림 처리

### 파일 처리

- 멀티파트 파일 업로드 기능
- Base64 인코딩 파일 처리
- 다중 파일 업로드 지원

## 프로젝트 구조

```
com.ocean.react
├── AComponent.java        - 컴포넌트 A
├── BComponent.java        - 컴포넌트 B
├── Base64Request.java     - Base64 요청 모델
├── FileController.java    - 파일 업로드 컨트롤러
├── ReactApplication.java  - 메인 애플리케이션 클래스
├── ReactController.java   - 리액티브 API 컨트롤러
├── ReactService.java      - 비즈니스 로직 처리 서비스
└── SourceRepository.java  - 데이터 접근 레포지토리
```

## 시작하기

### 요구 사항

- JDK 23 이상
- Gradle 7.x 이상

### 빌드 및 실행

```bash
# 프로젝트 클론
git clone https://github.com/haeseoky/react.git
cd react

# 빌드
./gradlew clean build

# 실행
./gradlew bootRun
```

### API 엔드포인트

- **리액티브 API**: `GET /react/`
- **단일 파일 업로드**: `POST /file/save` (multipart/form-data)
- **다중 파일 업로드**: `POST /file/saves` (multipart/form-data)
- **Base64 인코딩 파일 업로드**: `POST /file/base64EncodingFile` (application/json)

## 개발 가이드

### 리액티브 서비스 구현 예제

```java
@Service
public class ExampleService {
    public Mono<String> reactiveMethod() {
        return Mono.just("Hello, Reactive World!")
            .map(String::toUpperCase);
    }
}
```

### 파일 업로드 사용 예제

**multipart/form-data 업로드**:
```bash
curl -X POST -F "data=@yourfile.jpg" http://localhost:8080/file/save
```

**Base64 인코딩 파일 업로드**:
```bash
curl -X POST -H "Content-Type: application/json" \
  -d '{"base64":"Base64EncodedStringHere"}' \
  http://localhost:8080/file/base64EncodingFile
```

## 기여하기

이 프로젝트에 기여하고 싶으시다면, Pull Request를 제출해 주세요. 모든 기여는 환영합니다.
