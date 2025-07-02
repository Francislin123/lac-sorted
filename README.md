# Microsserviço de Informações Ambiental

# 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3.5.0
- Postgresql 42.7.7
- HTTP Client (para integrações)
- Lombok
- Gson 2.10.1 (Google)
- SpringDoc OpenAPI 2.5.0
- JUnit 4.13.2 (para testes unitários)
- Rest assured 5.4.0
- Logs (Slf4j)
- Spring Cache com Caffeine 

# ✅ Requisitos para Rodar o Projeto

- Para executar este projeto corretamente, é necessário que sua máquina atenda aos seguintes requisitos:
- Java JDK 17 ou superior instalado
- IntelliJ IDEA 2025 (recomendado): facilita a configuração do projeto e a integração com ferramentas do 
- ecossistema Spring

# Para executar o aplicativo basta seguir os passos abaixo.

- 1 - Entre na pasta onde está o jar do projeto
- 2 - Execute o seguinte comando com cmd
- 3 - java -jar lac-0.0.1-SNAPSHOT.jar --spring.config.location = file: C: /Config/application.yml

# Documentação para testar a API (Swagger)
- http://localhost:8077/api/v1/swagger-ui/index.html#/

### Arquitetura de solução baseada em MultiCloud.
![Captura de Tela 2019-05-11 às 18 46 50](https://private-user-images.githubusercontent.com/27180618/461718222-d4613223-b958-4f19-add9-1ae4e72ba167.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NTE0OTA1NjIsIm5iZiI6MTc1MTQ5MDI2MiwicGF0aCI6Ii8yNzE4MDYxOC80NjE3MTgyMjItZDQ2MTMyMjMtYjk1OC00ZjE5LWFkZDktMWFlNGU3MmJhMTY3LnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNTA3MDIlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjUwNzAyVDIxMDQyMlomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTk1NjMxOGQwMjM3MjgwZmU4MjAxNmI5MzE0MmJlMDdkZDJjYjhjOTM1MDRmMDFiNGY4NzU3MTViMjNlOWViZjcmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.0-4DJyc7igOkQA-V1a6xL3auih5fuh78j7_ZxoopwgQ)