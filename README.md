# Appgate calculator

This api provides tools to evaluate arithmetic operations (session calculator)

● ** Please, check the next videos before to continue: **

/_assets/hexagonal architecture compressed.mp4

/_assets/about app and installation compressed.mp4

● Functional requirement

Se debe implementar un API REST para calcular: sumar, resta, multiplicación,
división y potenciación de un conjunto de números.
Se espera tener mínimo tres servicios:

-- Nueva sesión (opcional): El servidor crea un nuevo ambiente donde empezar a
trabajar y retorna un identificador de este.

-- Agregar operando: se agrega un operando con el identificador retornado por el
servicio anterior.

-- Realizar operación: se envía la operación a realizar (suma, resta, multiplicación,
división, potenciación) con el identificador que se aplicará en cadena a todos los
operados previamente agregados

Los servicios deben responder al siguiente flujo:

-- El cliente llama un servicio para empezar (Nueva sesión).

-- El cliente llama un servicio para agregar los operandos (Agregar operando), tantas
veces como se quiera.

--mark El cliente llama un servicio para ejecutar una operación matemática (Realizar
operación).

Por ejemplo:

Cliente ------------------&gt; nueva operación ----------------------&gt; servidor

Cliente &lt;------------------ id &lt;---------------------- servidor

Cliente ------------------&gt; 2 ----------------------&gt; servidor

Cliente &lt;------------------ ok&lt;---------------------- servidor

Cliente ------------------&gt; 3 ----------------------&gt; servidor

Cliente &lt;------------------ ok&lt;---------------------- servidor

Cliente ------------------&gt; suma ----------------------&gt; servidor

Cliente &lt;------------------ 5&lt;---------------------- servidor

● Debe tener en cuenta

<font size="6" style="color:green;">&#9745;</font><font size="6" style="color:red;">&#9746;</font>

Se pueden agregar “n” operandos antes de realizar un calculo.

-- El resultado de un cálculo puede agregarse como operando para el siguiente
calculo.

-- El diseño de los servicios, incluyendo el manejo de errores y formato de los datos
queda a discreción del desarrollador.

-- Se debe entregar la documentación mínima para probar el funcionamiento de los
servicios, algo básico para saber como hacer pruebas de que el ejercicio esta
funcionando completo.

### Notes and plus

- Rate limit implementation: RateLimitInterceptor.java (app)
- Security endpoints with basic authentication (spring boot security): SecurityConfig.java

### TODO, to improve:

- Apply default query limits for list all entities
-

### run app (unit test):

Previously install maven: https://maven.apache.org/install.html

Please add configuration for environment variable JAVA_HOME with java11

```
echo $JAVA_HOME
export JAVA_HOME=/usr/lib/jvm/java-1.11.0-openjdk-amd64
```

Go to the next folder (/appgate-calculator):

![Folder path project](_assets/folder_path_project.png?raw=true "Folder path project")

Build: run the next comands:

```
$ mvn clean
$ mvn install
```
Build: java auto docs

```
$ mvn javadoc:javadoc
```

Run: unit test

```
$ mvn test
```

Run: app local jar
go to folder /appgate-calculator/launcher

```
$ cd launcher/
$ java -jar -Djava.security.egd=file:/dev/./urandom target/launcher-1.0.0.jar
```

Check your app into: http://localhost:8093

### Run with docker

Previously install docker and build the app (mvn install): https://docs.docker.com/engine/install/

```
sudo apt update
sudo snap install docker          # version 20.10.8, or
sudo apt  install docker-compose  # version 1.25.0-1
```

Open terminal and go to /appgate-calculator/launcher

- widnows: 

```
docker-compose up -d --build
```

- linux:

```
sudo docker-compose up -d --build
```

- other commands:

```
sudo docker-compose logs -f
sudo docker container ls
sudo docker image ls
sudo docker exec -it appgate_calc bash
sudo docker container stop appgate_calc
sudo docker logs appgate_calc -f
sudo docker rm -f appgate_calc
```

![Docker print](_assets/docker_print1.png?raw=true "Docker print")

Check your app into: http://localhost:8093

### Java docs:

Previously execute the next command into root path /appgate-calculator

```
$ mvn javadoc:javadoc
```
- Docs for domain package, please open with your browser: /app/target/site/apidocs/index.html
- Docs for infra package, please open with your browser: /infra/target/site/apidocs/index.html
- Docs for app package, please open with your browser: /infra/target/site/apidocs/index.html

![Docs print](_assets/docs_print.png?raw=true "Docs print")

### Swagger docs

http://localhost:8093/swagger-ui.html#/

please use the next Authroization: Basic YWRtaW46YWRtaW4=

![Swagger summary api](_assets/swagger_summary_api.png?raw=true "Swagger summary api")

### Coverage

- For domain:

![Coverage domain](_assets/coverage_domain.png?raw=true "Coverage domain")

- For infra:

![Coverage infra](_assets/coverage_infra.png?raw=true "Coverage infra")

### Basic hexagonal architecture with Spring Boot applied:
		
![Basic hexagonal architecture](_assets/hexagonal-architecture-generic.png?raw=true "Basic hexagonal architecture")

![Hexagonal diagram VS class](_assets/calculator-hexa.png?raw=true "Hexagonal diagram VS class")

### Basic diagram class:

![Basic diagram class](_assets/classes.png?raw=true "Basic diagram class")

### Database:

SQLite is a C-language library that implements a small, fast, self-contained, high-reliability, full-featured, SQL database engine (from local file system).
https://www.sqlite.org/index.html

SQLite file, for test: /infra/calculator_db_test.db

main file dtabase: /launcher/calculator_db.db

![Db structure view](_assets/db_part1.png?raw=true "Db structure view")

![Db constrains view](_assets/db_part2.png?raw=true "Db constrains view")

![Db data view](_assets/db_part3.png?raw=true "Db data view")

~~~~sql
CREATE TABLE ...
~~~~


