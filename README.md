# atm-simulator
A Spring MVC web app with Java based configuration that simulates an ATM. Includes additional features to register for an account and update acount settings.
\
\
**Backend:** Java 8, Spring MVC, Spring Security, Hibernate Validator, Hibernate ORM
\
**Frontend:** JSP, JSTL, CSS3, JavaScript, Bootstrap 5
\
**Build tool:** Maven
\
\
## Configuration ##
The following is a description of the java annotations used to configure Spring MVC
\
\
1. @Configuration
  1. indicates that this class declares one or more @Bean methods to be managed by the Spring container. @Bean methods return references to bean objects.
2. @EnableWebMvc
  1. imports the Spring MVC configuration from WebMvcConfigurationSupport (the main class providing the MVC configuration). To customize the imported configuration, implement the interface WebMvcConfigurer and override individual methods.
3. @EnableTransactionManagement
  1. Enables Spring's annotation-driven transaction management capability for the database transactions.
