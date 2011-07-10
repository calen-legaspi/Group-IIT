package com.orangeandbronze.ozmness

import grails.test.*

class ProjectTests extends GrailsUnitTestCase {
    Project p

    protected void setUp() {
        super.setUp()
        mockDomain(Project)
        mockDomain(Employee)
        p = new Project()
        p.lead = new Employee()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testInvalidProjectName() {
        assert !p.validate()
    }

    void testValidProjectName() {
        p.name = "Project Ozmness"
        assert p.validate()
    }
}
