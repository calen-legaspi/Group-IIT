package com.orangeandbronze.ozmness

import grails.plugins.springsecurity.Secured

@Secured(["hasRole('ADMIN')"])
class EmployeeController {

    def scaffold = Employee
}
