package mx.capitalbus.app

import grails.converters.JSON
import mx.capitalbus.app.bracelet.KindPerson

class KindPersonController {

    def index() {
        render(KindPerson.list() as JSON)
    }
}
