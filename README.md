# JOBII
## 목표
이슈 추적 시스템(Issue tracking system, ITS)은 단체의 필요에 의해 이슈 목록을 관리하고 유지 보수하는 컴퓨터 소프트웨어이다. 프로젝트를 진행할 때 이슈트래커를 사용하여 업무를 분담, 업무 및 문제점을 기록한다. 하지만 기존에 사용하던 이슈트래커는 이슈 검색을 위한 필터 선택이 너무 복잡하거나, 대시보드 기능이 필요이상으로 많은 선택이 가능하여 사용에 어려움을 준다. 반대로 이슈에 댓글을 달 수 없거나, 복수의 파일이 업로드 되지 않고, 대시보드가 존재하지 않아 진행 상황을 쉽게 알아보기 힘든 등 필요한 기능이 제공되지 않는 문제가 존재한다.

## 개발환경
Spring Boot는 JAVA기반의 서버 구축을 위한 프레임워크이다. 기존의 스프링 프레임워크를 이용한 개발 환경 구축은 많은 XML 설정 파일 등의 작성을 요구하는 단점이 있다. 하지만 Spring Boot는 스프링을 기반으로 하는, 바로 출시 가능한 수준의 ‘실행 가능한’ 단독 실행형 어플리케이션을 쉽게 만들 수 있게 해준다. Spring Boot는 매우 빠르게 모든 스프링 개발에 관한 경험에 광범위한 접근을 제공하고, 시큐리티, 내장형 서버 등 프로젝트 환경구축에 큰 영역을 차지하는 비기능적인 기능들을 기본적으로 제공해준다. 본 프로젝트에서는 Spring Boot를 통하여 Back End를 구성하고 DB 및 Storage와 데이터를 주고받으며 결과물을 Front End로 전달한다. Front End는 UI를 효율적으로 표현하기 위해 Bootstrap를 사용한다. Bootstrap은 css 라이브러리로써 대부분의 html tag에 class명칭을 정의해 주는 것으로 시각적으로 깔끔한 표현이 가능하게 된다. 동적인 기능은 JSP를 사용하여 구현하며 비동기 통신을 위한 Ajax 및 Jquery 라이브러리를 사용한다. DB는 비교적 최근 개발된 PostreSql을 사용하고 eXERD를 사용하여 설계를 시작한다. Storage는 AWS(Amazon Web Service)의 S3(Simple Storage Service)를 사용하여 저장한다.

해당 프로젝트는 Front End에서 JS기반의 Boot Strap, Angular JS를 활용 한다 특히 BootStrap은 웹페이지를 만들기 위한 거의 모든 요소에 대해서 정의를 해놓았기 때문에 손쉽게 웹사이트를 만들 수 있다는 장점이 있고 디자인 작업을 쉽게 할 수 있도록 선언해 놓은 속성과 값을 재활용하기 쉽게 만들어놓아 버튼뿐만 아니라 form에 사용되는 각종 태그, 아이콘, 드랍다운 메뉴 등 웹페이지에 사용 되는 모든 요소에 대해서 스타일시트를 미리 만들어 놓고 HTML 페이지의 태그에 적용하면 부트스트랩에 지정된 디자인으로 웹페이지가 자동으로 만들어지게 된다. 이를 활용했을 때 아무래도 고퀄리티의 디자인과 일련의 데이터를 활용해 view를 구성하다보니 속도 측면에서의 퍼포먼스가 떨어지게 된다. 웹앱에서 속도는 절대 무시 할 수 없는 문제점이다. 이를 해결하기 위해 AJAX와 JSON을 사용한다.
AJAX(Asynchronos Javascript And XML)란 비동기 JavaScript와 XML을 말한다 간단히 말하면, 서버측 Scripts와 통신하기 위한 XMLHttpRequest객체를 사용하는 것을 의미하며 서버측으로 다양한 형식(JSON, XML, HTML 및 일반 텍스트 형식 등)의 정보를 주고 받을 수 있다.
JSON (JavaScript Object Notation)은 경량의 DATA-교환 형식이다. 이 형식은 사람이 읽고 쓰기에 용이하며, 기계가 분석하고 생성함에도 용이하다. JavaScript Programming Language, Standard ECMA-262 3rd Edition - December 1999의 일부에 토대를 두고 있다. JSON은 완벽하게 언어로 부터 독립적이지만 C-family 언어 - C, C++, C#, Java, JavaScript, Perl, Python 그외 다수 - 의 프로그래머들에게 친숙한 관습을 사용하는 텍스트 형식이다. 이러한 속성들이 JSON을 이상적인 DATA-교환 언어로 만들고 있다.
아래와 같이 일련의 키와 값의 매핑 데이터들을 각각 보내주는 것이 아니라 하나의 오브젝트화를 하여 오직 하나의 데이터로 전송 한다.
json과 ajax를 view에서 뿐만 아니라 모든 통신에서 활용하였다 비동기이기 때문에 화면의 전환(새로고침 등) 없이도 출력 데이터, 형식 등을 바꿔줌으로써 불필요한 화면전환을 막았고 기본적으로 데이터 통신의 성능을 올림으로써 속도의 퍼포먼스 상승을 얻는다.

## 상용 솔루션 비교

![alt tag](https://lh4.googleusercontent.com/qVD9GCV3EJf2x2crCF40xTOWO_9QBrttlfnMxFH3MnBpRZJuyTUzxwtAhHuax7xJE5XqEDPtGR0QeGJ8pehq=w1918-h982)

상용 솔루션들을 비교해 보면 JIRA와 TRAC을 제외한 상용 솔루션들에는 히스토리 기능이 부재하여, 해당 이슈가 생성된 뒤로 어떠한 과정을 거쳐 현재 상태에 이르렀는지 대한 정보를 얻기가 쉽지 않다. 또한 TRAC은 다중 파일 업로드가 되지 않아 불편함이 존재한다. 대시보드의 경우에는 버그질라, 레드마인에서제공하지 않고, 대시보드에 그래프 등을 사용한 요약기능은 JIRA와 Mantis만이 존재한다. 그 외에도 버그질라는 한글화가 되지 않았다거나, TRAC은 설치가 복잡한 등의 문제가 존재한다.

## database

![alt tag](https://lh6.googleusercontent.com/LO-G-fBXLuRgNTUNpqKDCqd7thgPl9gtJO-4OCjT8E60mp7j_3j4FJ6FpFGuOm5cbsKR9V_oWro9OTwewi-v=w1918-h982)

반응형 웹 기반의 서비스 데스크는  그림과 같은 데이터베이스를 지닌다. 사용자 정보 테이블을 통해 사용자들의 정보를 갖고, 사용자권한 리스트와 사용자 권한 정보를 통하여 사용자의 권한을 설정하여 준다. 프로젝트 담당리스트 테이블은 사용자가 담당 중이 프로젝트들을 알려주고, 기관정보 테이블은 프로젝트와 사용자가 어떤 기관에 속하여 있는지 나타낸다. 프로젝트 정보 테이블은 등록된 프로젝트들의 정보를 나타내며, 히스토리 정보 테이블에서 각 프로젝트들의 연혁을 기록한다. 프로젝트 지원 리스트는 해당 프로젝트에서의 지원 되거나 지원한 내역을 기록하는 테이블이다. 프로젝트 버전 리스트에 저장된 버전 리스트를 통해 프로젝트의 버전을 관리하고, 프로젝트의 권한은 프로젝트 권한 정보 테이블을 통해 저장된다. 이슈정보 테이블은 각 프로젝트들에 등록된 이슈들을 저장하는 테이블이다. 댓글정보 테이블과 첨부파일 테이블은 각 이슈들에 대해 첨부파일정보 및 댓글 정보를 저장하는 테이블이다.

## install and start

1) git clone this repository
2) open eclipse and open this directory (was installed STS)
3) start spring boot app
4) connect localhost

## youtube link

https://youtu.be/9nvY9KHDXm4
