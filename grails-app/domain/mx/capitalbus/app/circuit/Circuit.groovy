package mx.capitalbus.app.circuit

class Circuit {

    String name
    Date creationDate
    String road
    boolean enabled

    static constraints = {
    }

    static mapping = {
        id generator: 'identity'
    }
}
