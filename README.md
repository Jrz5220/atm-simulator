# atm-simulator
A Spring MVC web app with Java based configuration that simulates an ATM. Includes additional features to register for an account and update acount settings.
<br/>
<br/>
**Backend:** Java 8, Spring MVC, Spring Security, Hibernate Validator, Hibernate ORM
<br/>
**Frontend:** JSP, JSTL, CSS3, JavaScript, Bootstrap 5
<br/>
**Build tool:** Maven
<br/>
<br/>
## Configuration ##
The following is a description of the java annotations used to configure Spring MVC
<br/>
<br/>
1. @Configuration
    indicates that this class declares one or more @Bean methods to be managed by the Spring container. @Bean methods return references to bean objects.
2. @EnableWebMvc
    imports the Spring MVC configuration from WebMvcConfigurationSupport (the main class providing the MVC configuration). To customize the imported configuration, implement the interface WebMvcConfigurer and override individual methods.
3. @EnableTransactionManagement
    Enables Spring's annotation-driven transaction management capability for the database transactions.
