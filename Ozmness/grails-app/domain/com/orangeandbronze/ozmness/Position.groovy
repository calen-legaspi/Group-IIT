package com.orangeandbronze.ozmness

class Position {
    String name

    static hasMany = [
        ratings:Rating
    ]

    static mapping = {
        table('positions')
        ratings(joinTable: [
            name: 'position_ratings',
            key: 'position_id',
            column: 'rating_id'
        ])
    }

    static constraints = {
        name(blank: false)
    }

    String toString() {
        "$name"
    }
}
