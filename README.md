# bjgenerator
- 패키지 만들고 Main클래스 생성하고 main함수 만들고 BufferedReader 객체 생성하고 ~
- 백준 문제 풀이를 위해 반복되는 위 작업을 한번에 해드립니다!


# 사용법
* config.yaml 설정
  + srcRoute : 백준 풀이에 사용할 java 프로젝트의 src폴더 위치를 입력해주세요.
  + packageName : 패키지명 규칙을 입력해주세요.
    - ex) ```packageName : bj``` => bj1001, bj1002 ~~ 이렇게 생성
  + comment : 생성되는 java 파일의 상단에 넣을 주석을 입력해주세요. 줄바꿈은 \n으로 나타내면 됩니다.
    - ex) ```/*\n문제 이름:\n알고리즘:\n자료구조:\n*/\n\n```
  + prgJSRoute : 프로그래머스 풀이에 사용할 javascript 프로젝트의 폴더 위치를 입력해주세요.

* 터미널에서 실행
  + java -jar bjgenerator.jar [--help] [<bj problem num>] [-pjs <problem name>] [-bjj <bj problem num>]
  + ex) ```java -jar bjgenerator.jar 12345```, ```java -jar bjgenerator.jar -bjj 12345```  => 백준 12345번 문제 파일 생성
  + ex) ```java -jar bjgenerator.jar -pjs 소수 만들기```  => 프로그래머스 소수 만들기 문제 파일 생성
  
