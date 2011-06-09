/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package an.awesome.practice.forrr.me;

import java.util.Date;

/**
 *
 * @author lyndon
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
    
}
