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
## AtmAppConfig.java
### Configuration
The following is a description of the java annotations used to configure Spring MVC for the class AtmAppConfig
<br/>
<br/>
1. @Configuration<br/>indicates that this class declares one or more @Bean methods to be managed by the Spring container. @Bean methods return references to bean objects.
2. @EnableWebMvc<br/>imports the Spring MVC configuration from WebMvcConfigurationSupport (the main class providing the MVC configuration). To customize the imported configuration, implement the interface WebMvcConfigurer and override individual methods.
3. @EnableTransactionManagement<br/>Enables Spring's annotation-driven transaction management capability for the database transactions.
4. @ComponentScan<br/>allows this configuration class to scan the package “com.felix.atmSim” and its sub packages for components (beans) to be registered by the Spring container.
5. @PropertySource<br/>
adds a property source to Spring’s Environment interface. The properties are located in src/main/resources/persistence-mysql.properties (not included in this repo). It contains the JDBC connection properties, connection pool properties, and Hibernate properties.
### Fields
1. Environment variable<br/>
provides the user with the values from the property source. @Autowired makes use of Spring’s dependency injection facilities to inject the values from the property source into the Environment object.
### WebMvcConfigurer overriden methods
* addResourceHandlers<br/>
Uses the ResourceHandlerRegistry to store and serve static resources such as images, js, and css files from specific locations.
### Bean methods
* viewResolver<br/>
Generates the views for the view template. Returns the ViewResolver.
* securityDataSource<br/>
sets the JDBC connections and the connection pool properties using the Environment variable. Returns the DataSource.
* sessionFactory<br/>
creates a Hibernate session factory. A session factory gets a database connection and creates session objects which are used to interact with the database.
* transactionManager<br/>
binds a single session from a session factory to a transaction or thread.
