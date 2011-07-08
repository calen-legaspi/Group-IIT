package com.orangeandbronze.ozmness

import grails.test.*

class RatingTests extends GrailsUnitTestCase {
    Rating r1

    protected void setUp() {
        super.setUp()
        mockDomain(Rating)
        r1 = new Rating()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testValueOutOfRange() {
        r1.value = 100
        assert !r1.validate()
    }

    void testCorrectValue() {
        r1.technology = new Technology()
        r1.value = 1
        assert r1.validate()
        r1.value = 2
        assert r1.validate()
        r1.value = 3
        assert  r1.validate()
    }

}
