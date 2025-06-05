Project 생성 과정 

1. thymeleaf dependency 
2. thymeleaf-layout dependency
3. thymeleaf fragment 등록 후 header, footer, layout, content분리
4. contoller 생성 후 index page 띄움
5. 각종 lib 추가

6. bootstrap admin template 붙이기
7. Interceptor 추가 후 WebMvcConfig 등록

8. COErrController 컨트롤러 생성 후 400 등 에러페이지 맵핑
9. addResourceHandlers 에 common 경로 설정
10. js 파일 생성 후 초기화

11. 로그인화면 설정
12. db 설정 파일(log4jdbc, mybatis 의존성 추가) 생성 및 activate 구분
 > application-db.yml
> > mybatis-config.xml
> > log4jdbc.log4j2.properties
> > Mybatis.java
> > // DTO // mapper 등 