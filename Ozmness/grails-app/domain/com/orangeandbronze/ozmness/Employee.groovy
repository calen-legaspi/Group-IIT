package com.orangeandbronze.ozmness

class Employee extends User {
    String firstName
    String lastName
    Position position
    Employee mentor

    static constraints = {
        firstName(blank: false)
        lastName(blank: false)
        position(blank: false)
        mentor(null: true)
    }

    String toString() {
        "$firstName $lastName [$position]"
    }

    /**
     * Make sure that the mentor is a different instance.
     * Self-studies don't count.
     * @param mentor
     */
    void setMentor(Employee mentor) {
        if(this.equals(mentor)) {
            throw new Exception("Circular reference on field: mentor");
        }
        this.mentor = mentor
    }
}