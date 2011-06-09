/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package an.awesome.practice.forrr.me;

import java.util.Date;

/**
 * The path to the God DAO. 
 */
public class SampleDomain {
    private int id;
    private Integer someBoxedInteger;
    private String someString;
    private Date someDate;
    private float somePrimitiveFloat;
    private Float someBoxedFloat;
    
    @Transient
    private int someTransientThing; //not supposed to be saved
    
    private SomeEnum someEnum;
    
    public SampleDomain() {
        id = 1;
        someBoxedInteger = 11;
        someString = "some stupid string";
        someDate = new Date();
        somePrimitiveFloat = 100F;
        someTransientThing = 1;
        someEnum = SomeEnum.VALUE2;
    }
}
