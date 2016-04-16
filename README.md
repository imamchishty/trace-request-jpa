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