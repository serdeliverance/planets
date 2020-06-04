package com.challenge.planets.util

import com.challenge.planets.domain.Coordenate;
import spock.lang.Specification;

class GeometricUtilsSpec extends Specification {

    def "when three coordinates are collinear it should return true"() {
        given:
        Coordenate p1 = new Coordenate(0,2)
        Coordenate p2 = new Coordenate(1,3)
        Coordenate p3 = new Coordenate(2,4)

        when:
        boolean result = GeometricUtils.areCollinear(p1, p2, p3)

        then:
        result == true
    }

    def "when three coordinates are collinear it should return - case 2"() {
        given:
        Coordenate p1 = new Coordenate(2,2)
        Coordenate p2 = new Coordenate(3,4)
        Coordenate p3 = new Coordenate(4,6)

        when:
        boolean result = GeometricUtils.areCollinear(p1, p2, p3)

        then:
        result == true
    }

    def "when three coordinates are not collinear it should return false"() {
        given:
        Coordenate p1 = new Coordenate(0,2)
        Coordenate p2 = new Coordenate(1,3)
        Coordenate p3 = new Coordenate(0,0)

        when:
        boolean result = GeometricUtils.areCollinear(p1, p2, p3)

        then:
        result == false
    }

    def "when the 4th coordinate is inside the triangle it should return true"() {
        given:
        Coordenate p1 = new Coordenate(-1,0)
        Coordenate p2 = new Coordenate(2,0)
        Coordenate p3 = new Coordenate(0,2)
        Coordenate p4 = new Coordenate(0,1)

        when:
        boolean result = GeometricUtils.isPointInsideTriangle(p1, p2, p3, p4)

        then:
        result == true
    }

    def "when the 4th coordinate is not inside the triangle it should return false"() {
        given:
        Coordenate p1 = new Coordenate(-1,2)
        Coordenate p2 = new Coordenate(2,2)
        Coordenate p3 = new Coordenate(0,4)
        Coordenate p4 = new Coordenate(0,1)

        when:
        boolean result = GeometricUtils.isPointInsideTriangle(p1, p2, p3, p4)

        then:
        result == false
    }
}