/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package an.awesome.practice.forrr.me;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lyndon
 */
public class SampleDomainTest {
    
    public SampleDomainTest() {
    }

    @Test
    public void testSomeMethod() throws Exception {
        SampleDomain s = new SampleDomain();
        
        Class c = s.getClass();
        Field[] fields = c.getDeclaredFields();
        
        System.out.println("Field Name: Field Value (Data Type) for the "+c);
        for(Field f:fields) {    
            f.setAccessible(true);
            
            System.out.println(f.getName()+":"+f.get(s)+"("+f.getType()+")");
        }
         
        fields[0].setAccessible(true);
        fields[0].setInt(s,12);
        
        System.out.print(fields[0].get(s));
        System.out.print(fields[6].isAnnotationPresent(Transient.class));
    }
}
