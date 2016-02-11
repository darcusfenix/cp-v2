import mx.capitalbus.app.bracelet.Bracelet
import mx.capitalbus.app.bracelet.BraceletState
import mx.capitalbus.app.bracelet.CostBracelet
import mx.capitalbus.app.bracelet.DaysDuration
import mx.capitalbus.app.bracelet.KindPerson
import mx.capitalbus.app.bracelet.PersonDuration
import mx.capitalbus.app.circuit.Bus
import mx.capitalbus.app.circuit.Circuit
import mx.capitalbus.app.security.Role
import mx.capitalbus.app.security.UserRole
import mx.capitalbus.app.user.Salesman

class BootStrap {

    def init = { servletContext ->
        Circuit c = new Circuit()
        c.name = "Cuircuito General"
        c.enabled = true
        c.road = "poin(1,0) to poin(1,0)"
        c.creationDate = new Date()
        c.save()

        KindPerson kp = new KindPerson()
        kp.name = "niños"
        kp.save()

        KindPerson kp2 = new KindPerson()
        kp2.name = "Adultos"
        kp2.save()

        DaysDuration dd = new DaysDuration()
        dd.days = "lunes a viernes"
        dd.save()

        DaysDuration dd2 = new DaysDuration()
        dd2.days = "sábado y domingo"
        dd2.save(flush : true)

        def adminRole = new Role('ROLE_ADMIN').save()
        def salesManRole = new Role('ROLE_SALESMAN').save()

        def sm = new Salesman()
        sm.accountExpired = false
        sm.accountLocked = false
        sm.passwordExpired = false
        sm.password = "capitalbus"
        sm.email = "admin@capitalbus.mx"
        sm.enabled = true
        sm.username = "darcusfenix"
        sm.birthdate = new Date()
        sm.firstName = "JUAN"
        sm.lastName = "CRISÓSTOMO"
        sm.telephone = "5530271655"
        sm.save()

        UserRole.create sm,salesManRole
/*
        UserRole.withSession {
            it.flush()
            it.clear()
        }
*/
        def pdr = PersonDuration.create(kp, dd)
        PersonDuration.create(kp, dd2)
        PersonDuration.create(kp2, dd)
        PersonDuration.create(kp2, dd2)

        log.error(pdr)

        BraceletState bs = new BraceletState()
        bs.name = "generado"
        bs.description = "..."
        bs.save()

        BraceletState bs2 = new BraceletState()
        bs2.name = "activado"
        bs2.description = "..."
        bs2.save()

        BraceletState bs3 = new BraceletState()
        bs3.name = "Abordo"
        bs3.description = "..."
        bs3.save()

        BraceletState bs8 = new BraceletState()
        bs8.name = "bajada"
        bs8.description = "..."
        bs8.save()

        BraceletState bs4 = new BraceletState()
        bs4.name = "Abordo sin escaneo de bajada primer oportunidad"
        bs4.description = "..."
        bs4.save()

        BraceletState bs5 = new BraceletState()
        bs5.name = "Abordo sin escaneo de bajada segunda oportunidad"
        bs5.description = "..."
        bs5.save()

        BraceletState bs6 = new BraceletState()
        bs6.name = "Abordo sin escaneo de bajada tercer oportunidad"
        bs6.description = "..."
        bs6.save()

        BraceletState bs7 = new BraceletState()
        bs7.name = "caducado"
        bs7.description = "..."
        bs7.save()

        Bus b = new Bus()
        b.circuit = c
        b.enabled = true
        b.currentAltitude = "aa"
        b.currentLatitude = "s"
        b.imei = "a123"
        b.model = "sss"
        b.plate = "ds"
        b.year = new Date()
        b.lastUpdatedLocation = new Date()
        b.save()

        CostBracelet cb = new CostBracelet()
        cb.cost = 170.50
        cb.personDuration = pdr
        cb.circuit = c
        cb.save()

        Bracelet bracelet = new Bracelet()
        bracelet.braceletState = bs
        bracelet.code = "0123456789"
        bracelet.creationDate = new Date()
        bracelet.costBracelet = cb
        bracelet.validate()
        bracelet.save()
    }
    def destroy = {
    }
}
