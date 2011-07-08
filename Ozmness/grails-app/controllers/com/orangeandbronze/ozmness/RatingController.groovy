package com.orangeandbronze.ozmness

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class RatingController {

    def scaffold = Rating
}
