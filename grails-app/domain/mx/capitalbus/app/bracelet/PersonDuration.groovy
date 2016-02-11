package mx.capitalbus.app.bracelet

import org.apache.commons.lang.builder.HashCodeBuilder

class PersonDuration implements Serializable{

    KindPerson kindPerson
    DaysDuration daysDuration

    PersonDuration(KindPerson u, DaysDuration r) {
        this()
        kindPerson = u
        daysDuration = r
    }


    @Override
    boolean equals(other) {
        if (!(other instanceof PersonDuration)) {
            return false
        }
        other.kindPerson?.id == kindPerson?.id && other.daysDuration?.id == daysDuration?.id
    }

    @Override
    int hashCode() {
        def builder = new HashCodeBuilder()
        if (kindPerson) builder.append(kindPerson.id)
        if (daysDuration) builder.append(daysDuration.id)
        builder.toHashCode()
    }

    static constraints = {
    }

    static mapping = {
        id composite: ['kindPerson', 'daysDuration']
        version false
    }

    static PersonDuration create(KindPerson kindPerson, DaysDuration daysDuration, boolean flush = false) {
        def instance = new PersonDuration(kindPerson: kindPerson, daysDuration: daysDuration)
        instance.save(flush: flush, insert: true)
        instance
    }
}
