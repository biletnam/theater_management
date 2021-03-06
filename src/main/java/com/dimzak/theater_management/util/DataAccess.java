package com.dimzak.theater_management.util;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * @author Dimitris Zakas
 */
@Qualifier
@Retention(RUNTIME) @Target({TYPE, METHOD, FIELD, PARAMETER})
public @interface DataAccess {
}
