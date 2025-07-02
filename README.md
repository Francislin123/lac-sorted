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

### Arquitetura de solução baseada em GCP
![Captura de Tela 2019-05-11 às 18 46 50](https://user-images.githubusercontent.com/27180618/57575590-b4f2d000-7423-11e9-9ad5-ec3623d012bf.png)