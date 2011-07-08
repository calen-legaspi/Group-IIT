package com.orangeandbronze.ozmness

class EmployeeRating extends Rating {
    String comment
    Date dateCreated
    Employee creator
    Employee rated

    static constraints = {
        comment()
        dateCreated()
        creator(blank: false)
        rated(blank: false)
    }
}
