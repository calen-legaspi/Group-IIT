package com.orangeandbronze.ozmness

class EmployeeRating extends Rating {
    String comment
    Date dateCreated
    Employee creator
    Employee rated

    static belongsTo = [Employee]

    static constraints = {
        comment()
        dateCreated()
        creator(blank: false)
        rated(blank: false)
    }

    String toString() {
        "$rated $technology[$value/3] by $creator"
    }
}
