package com.orangeandbronze.ozmness

class Employee extends User {
    String firstName
    String lastName
    Employee mentor
    Position position

    static hasMany = [projects:Project, ratings:EmployeeRating]
    static mappedBy = [ratings:'rated']

    static constraints = {
        firstName(blank: false)
        lastName(blank: false)
        mentor()
        position(blank: false)
    }

    String toString() {
        "$firstName $lastName"
    }
}
