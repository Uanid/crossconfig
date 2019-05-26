# CrossConfig

다양한 텍스트 포맷을 지원하는 Java 8+ 전용 범용 Config library.

모듈 형태로 다양한 텍스트 포맷과 접근 프로토콜들을 지원할 수 있게 할 계획


현재 계획:
-
- 텍스트 포맷
    - INI, JSON, YAML, HOCON, XML, PROPERTIES(file)등의 포맷을 지원
    - 기본으로 제공되는 PROPERTIES 외에 나머진 optional 모듈 형태로 제공 (라이브러리 경량화)
- 접근 프로토콜
    - file, JARFile, ZIPFile, HTTP, HTTPS, FTP, SFTP, Property(java)
    - 기회가 된다면 JDBC(with driver)와 Windows 레지스트리도...
        - JDBC 프로토콜을 개발하려는 이유:
        - 실제 개발을 해보니 config data를 DB에서 가져올 필요가 종종 있었음...
        - 그러나 ORM모듈 등을 로딩하고 DB에서 config를 가져오면 초기화 순서가 꼬이게 됨
        - 결국 businiess logic이 가동하기 전 initialize time에서 db의 데이터에 접근이 필요함
    - 위와 마찬가지로 optional 모듈 형태로 제공
    
    
**요약: 초기화 시간에 많고 다양한 데이터를 사용할 수 있도록 하는 것이 목표**
