# filter-request-jpa
Stores the request model using jpa.

    trace-request.hibernate.hbm2ddl.auto=none
    trace-request.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    trace-request.jdbc.driverClassName=org.postgresql.Driver
    trace-request.jdbc.url=jdbc:postgresql://localhost:5432/trace_request
    trace-request.jdbc.user=postgres
    trace-request.jdbc.pass=postgres@123
    
    
Spring configuration
    
    @EnableTraceRequestJpa
    
    
If you have an existing ds, mark it as @Primary, e.g.

    @Primary
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/trace_request");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres@123");
        return dataSource;
    }
