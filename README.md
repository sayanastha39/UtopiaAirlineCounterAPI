Utopia Airline with Spring Security

Utopia Airline project has three core modules Payment Module, Ticket Access Module and Reschedule Module. Each of these modules contains multiple sub-modules like Batch control, Indexing, Scanning, Payment and others. In payment module, the application allows the users to make online purchases, web check in, reschedule travel etc.

Implement business components using spring dependency injection and accessed them using Spring provided annotations.Using Spring boot was very helpful as it is a J2EE framework that takes care of boilerplates and controls the application. I took advantage of this feature and implemented JPA Repository while working with data and objects. I used Hibernate because it is the most common JPA provider. It allowed me to load and save Java objects without writing queries. I took advantage of Java 8 features like lambda, forEach method, Collections and generics to create classes not tied to one datatype.

This is slightly different than nmy other repository UtopiaBackend as I have implemented Spring Security in the same applicaion.
Spring Security is a farmework of Spring which uses authentication and authorization mechanism to give control over accessing web application.

In the Controller folder, i had the  rest endpoints mentioned for the application and gave authorization to Clerk to all access using @PreAuthorize annotation. 

In SecurityConfiguration.java uses CustomUserDetails and override load by Username method from UserDetailsService  and quering using DAO. 
Before providing access to the endpoints in the controller this Spring Security will first authenticates and authorozes is the user can access the application or not.

If using custom login page .and().formLogin().loginPage("/loginpage").permitAll();
If not authenticated will go to login page
.antMatchers("**/users/**").authenticated() only authenticate but not authorized so to authorize use preauthorize
	
  
Used BCryptPasswordEncoder to encrypt the password and store in database to provide extra security to the application when hacked.
