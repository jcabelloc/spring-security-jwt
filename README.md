# Prueba de concepto de Spring Security con JWTs

## Objetivo
Tener una prueba de concepto basica de Spring Security con JWTs

## Referencias
* [Spring Boot + Spring Security + JWT from scratch - Java Brains](https://www.youtube.com/watch?v=X80nJ5T7YpE)
* [Java JWT: JSON Web Token for Java and Android](https://github.com/jwtk/jjwt)
* [Spring Security - Authentication] (https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authentication)
* [Spring Boot Security + JWT ''Hello World'' Example] (https://dzone.com/articles/spring-boot-security-json-web-tokenjwt-hello-world)

## Entorno
* Proyecto usando Spring boot Initializer
* JDK: 11
* Depedencias iniciales: spring-boot-starter-web, spring-boot-starter-security


## Configuracion basica
* Agregar clases: DemoRest, WebSecurityConfig (con @Override method configure), MyUserDetailsService
* En el Chrome
	* Probar el ingreso al URL: .../message. Ingresar usuario/password en el formulario de login
	* En el cliente, ver que se ha obtenido el cookie JSESSIONID
* En el postman
	* Probar el ingreso al URL: .../message. Ingresar el usuario/password en Authorizacion / Basic Authentication
	* Ver que se retorna un cookie JSESSIONID

## Paso 1: Entregar un JWT cuando el usuario se autentica correctamente

### Depedencias Adicionales
```xml
		<dependency>
		  <groupId>io.jsonwebtoken</groupId>
		  <artifactId>jjwt</artifactId>
		  <version>0.9.1</version>
		</dependency>
		<dependency>
		  <groupId>javax.xml.bind</groupId>
		  <artifactId>jaxb-api</artifactId>
		  <version>2.3.1</version>
		</dependency>
```

### Codificacion y Configuracion
* Agregar la Clase JwtUtilService
* Crear un punto de autenticacion que sea publico: .../authenticate
* En la clase WebSecurityConfig, configurar los metodos: authenticationManagerBean y configure(HttpSecurity http)


## Paso 2: 
* Interceptar todas las llamadas entrantes, usando un filter
* Extraer el JWT del header
* Validar y configurar el contexto de ejecucion (Execution context)


