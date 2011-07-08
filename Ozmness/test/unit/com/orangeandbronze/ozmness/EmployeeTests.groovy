package com.orangeandbronze.ozmness

import grails.test.*

class EmployeeTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testTheSameMentor() {
        shouldFail(Exception) {
            Employee e1 = new Employee()
            e1.mentor = e1
        }
    }

    void testCorrectMentor() {
        Employee e1 = new Employee()
        Employee e2 = new Employee()
        e1.mentor = e2
        assert e1.mentor.equals(e2)
    }
}
