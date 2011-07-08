package com.orangeandbronze.ozmness

import grails.plugins.springsecurity.Secured

@Secured(["hasRole('ADMIN')"])
class TechnologyController {

    def scaffold = Technology
}
