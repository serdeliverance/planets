package com.challenge.planets.domain


import spock.lang.Specification

class SegmentSpec extends Specification {

    def "when calculate the segment between two points it should return the right value"() {
        given:
        Coordenate a = new Coordenate(1,3)
        Coordenate b = new Coordenate(2, 5)

        when:
        Segment result = Segment.of(a,b)

        then:
        result != null
        result.x == 1
        result.y == 2
    }

    def "when calculate the modulus of a segment it should return the right value"() {
        given:
        Segment segmento = new Segment(3, 4)

        when:
        double result = segmento.magnitude

        then:
        result == Math.sqrt(Math.pow(3,2) + Math.pow(4,2))
    }
}