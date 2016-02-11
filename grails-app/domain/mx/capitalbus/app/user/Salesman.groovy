package mx.capitalbus.app.user

import mx.capitalbus.app.security.User


class Salesman extends User{

    String firstName
    String lastName
    Date birthdate
    String telephone


    static constraints = {
    }

    static mapping = {
        id generator: 'identity'
    }
}
