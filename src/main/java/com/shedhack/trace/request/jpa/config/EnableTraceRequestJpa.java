package com.shedhack.trace.request.jpa.config;

import com.shedhack.trace.request.api.service.TraceRequestService;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <pre>
 *     Most applications usually access databases and define their own
 *     datasources. This library also requires a db and in the
 *     case of trace-request-jpa it assumes that the db it will be writing
 *     to will be a central one, and probably not the applications db.
 *     As a result you'll see a separate TX manager, EMF and of course
 *     the database. Please note that you may need to use {@link org.springframework.beans.factory.annotation.Qualifier}
 *     to your existing database to prevent any conflicts.
 * </pre>
 *
 * @author imamchishty
 */
@Target({java.lang.annotation.ElementType.TYPE})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
@Import(TraceRequestJpaConfiguration.class)
public @interface EnableTraceRequestJpa {
}
