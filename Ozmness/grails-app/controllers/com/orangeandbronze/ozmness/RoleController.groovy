package com.orangeandbronze.ozmness

import grails.plugins.springsecurity.Secured

@Secured(["hasRole('ADMIN')"])
class RoleController {

    def scaffold = Role
}
