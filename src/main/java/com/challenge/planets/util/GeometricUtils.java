package com.challenge.planets.util;

import com.challenge.planets.domain.Coordenate;
import com.challenge.planets.domain.Segment;

import static com.challenge.planets.util.Utils.round;

public class GeometricUtils {

    public static boolean areCollinear(Coordenate p1, Coordenate p2, Coordenate p3) {
        return round((p2.getY()-p1.getY())/(p2.getX()-p1.getX()),2) == round((p3.getY()-p2.getY())/(p3.getX()-p2.getX()),2);
    }

    public static boolean isPointInsideTriangle(Coordenate p1, Coordenate p2, Coordenate p3, Coordenate p4) {
        Segment segmentAB = Segment.of(p1, p2);
        Segment segmentAC = Segment.of(p1, p3);

        double w1 = (segmentAC.getX() * (p1.getY() - p4.getY()) + segmentAC.getY() * (p4.getX() - p1.getX())) / (segmentAB.getX() * segmentAC.getY() - segmentAB.getY() * segmentAC.getX());
        double w2 = (p4.getY() - p1.getY() - w1 * segmentAB.getY()) / segmentAC.getY();

        return w1 >= 0.0 && w2 >= 0.0 && (w1 + w2 <= 1.0);
    }
}
