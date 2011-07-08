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

    /**
     * Override the default.
     * Make sure that the mentor is a different instance.
     * @param mentor
     */
    public void setMentor(Employee mentor) {
        if(this.equals(mentor)) {
            throw new Exception("Circular reference on field: mentor");
        }
        this.mentor = mentor
    }
}
