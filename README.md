# JOBII
## 개발환경
Spring Boot는 JAVA기반의 서버 구축을 위한 프레임워크이다. 기존의 스프링 프레임워크를 이용한 개발 환경 구축은 많은 XML 설정 파일 등의 작성을 요구하는 단점이 있다. 하지만 Spring Boot는 스프링을 기반으로 하는, 바로 출시 가능한 수준의 ‘실행 가능한’ 단독 실행형 어플리케이션을 쉽게 만들 수 있게 해준다. Spring Boot는 매우 빠르게 모든 스프링 개발에 관한 경험에 광범위한 접근을 제공하고, 시큐리티, 내장형 서버 등 프로젝트 환경구축에 큰 영역을 차지하는 비기능적인 기능들을 기본적으로 제공해준다. 본 프로젝트에서는 Spring Boot를 통하여 Back End를 구성하고 DB 및 Storage와 데이터를 주고받으며 결과물을 Front End로 전달한다. Front End는 UI를 효율적으로 표현하기 위해 Bootstrap를 사용한다. Bootstrap은 css 라이브러리로써 대부분의 html tag에 class명칭을 정의해 주는 것으로 시각적으로 깔끔한 표현이 가능하게 된다. 동적인 기능은 JSP를 사용하여 구현하며 비동기 통신을 위한 Ajax 및 Jquery 라이브러리를 사용한다. DB는 비교적 최근 개발된 PostreSql을 사용하고 eXERD를 사용하여 설계를 시작한다. Storage는 AWS(Amazon Web Service)의 S3(Simple Storage Service)를 사용하여 저장한다.

해당 프로젝트는 Front End에서 JS기반의 Boot Strap, Angular JS를 활용 한다 특히 BootStrap은 웹페이지를 만들기 위한 거의 모든 요소에 대해서 정의를 해놓았기 때문에 손쉽게 웹사이트를 만들 수 있다는 장점이 있고 디자인 작업을 쉽게 할 수 있도록 선언해 놓은 속성과 값을 재활용하기 쉽게 만들어놓아 버튼뿐만 아니라 form에 사용되는 각종 태그, 아이콘, 드랍다운 메뉴 등 웹페이지에 사용 되는 모든 요소에 대해서 스타일시트를 미리 만들어 놓고 HTML 페이지의 태그에 적용하면 부트스트랩에 지정된 디자인으로 웹페이지가 자동으로 만들어지게 된다. 이를 활용했을 때 아무래도 고퀄리티의 디자인과 일련의 데이터를 활용해 view를 구성하다보니 속도 측면에서의 퍼포먼스가 떨어지게 된다. 웹앱에서 속도는 절대 무시 할 수 없는 문제점이다. 이를 해결하기 위해 AJAX와 JSON을 사용한다.
AJAX(Asynchronos Javascript And XML)란 비동기 JavaScript와 XML을 말한다 간단히 말하면, 서버측 Scripts와 통신하기 위한 XMLHttpRequest객체를 사용하는 것을 의미하며 서버측으로 다양한 형식(JSON, XML, HTML 및 일반 텍스트 형식 등)의 정보를 주고 받을 수 있다.
JSON (JavaScript Object Notation)은 경량의 DATA-교환 형식이다. 이 형식은 사람이 읽고 쓰기에 용이하며, 기계가 분석하고 생성함에도 용이하다. JavaScript Programming Language, Standard ECMA-262 3rd Edition - December 1999의 일부에 토대를 두고 있다. JSON은 완벽하게 언어로 부터 독립적이지만 C-family 언어 - C, C++, C#, Java, JavaScript, Perl, Python 그외 다수 - 의 프로그래머들에게 친숙한 관습을 사용하는 텍스트 형식이다. 이러한 속성들이 JSON을 이상적인 DATA-교환 언어로 만들고 있다.
아래와 같이 일련의 키와 값의 매핑 데이터들을 각각 보내주는 것이 아니라 하나의 오브젝트화를 하여 오직 하나의 데이터로 전송 한다.
json과 ajax를 view에서 뿐만 아니라 모든 통신에서 활용하였다 비동기이기 때문에 화면의 전환(새로고침 등) 없이도 출력 데이터, 형식 등을 바꿔줌으로써 불필요한 화면전환을 막았고 기본적으로 데이터 통신의 성능을 올림으로써 속도의 퍼포먼스 상승을 얻는다.

##database

![alt tag](https://lh6.googleusercontent.com/LO-G-fBXLuRgNTUNpqKDCqd7thgPl9gtJO-4OCjT8E60mp7j_3j4FJ6FpFGuOm5cbsKR9V_oWro9OTwewi-v=w1918-h982)

