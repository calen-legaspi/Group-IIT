package com.orangeandbronze.ozmness

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class ProjectController {

    def scaffold = Project
}
