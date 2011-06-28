/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package an.awesome.practice.forrr.me;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for domain fields not meant for persistence.
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Transient {
    
}
