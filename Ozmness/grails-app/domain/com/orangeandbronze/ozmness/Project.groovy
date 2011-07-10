package com.orangeandbronze.ozmness

class Project {
    String name
    Employee lead

    static hasMany = [
        technologies:Technology
    ]

    static mapping = {
        technologies(joinTable: [
            name: 'project_technologies',
            key: 'project_id',
            column: 'technology_id'
        ])
    }

    static constraints = {
        name(blank: false)
    }

    String toString() {
        "$name"
    }
}
