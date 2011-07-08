package com.orangeandbronze.ozmness

import grails.test.*

class ProjectTests extends GrailsUnitTestCase {
    Project p

    protected void setUp() {
        super.setUp()
        mockDomain(Project)
        p = new Project()
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
