package mx.capitalbus.app

import grails.converters.JSON
import mx.capitalbus.app.bracelet.DaysDuration

class DaysDurationController {

    def index() {
        render (DaysDuration.list() as JSON)
    }
}
