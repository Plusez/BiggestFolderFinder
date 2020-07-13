import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.*;
import java.util.stream.Collectors;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    HashMap<Integer, Line> number2line;
    TreeSet<Station> stations;
    TreeMap<Station, TreeSet<Station>> connections;

    public void StationIndex() {}

    @Override
    protected void setUp() throws Exception {

//    public void StationIndex()
//        {

        number2line = new HashMap<>();
        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");
        number2line.put(1, line1);
        number2line.put(2, line2);
        number2line.put(3, line3);

        stations = new TreeSet<>();
        Station st1 = new Station("st1", line1);
        stations.add(st1);
        Station st2 = new Station("st2", line1);
        stations.add(st2);
        Station st3 = new Station("st3", line1);
        stations.add(st3);
        Station st4 = new Station("st4", line2);
        stations.add(st4);
        Station st5 = new Station("st5", line2);
        stations.add(st5);
        Station st6 = new Station("st6", line2);
        stations.add(st6);
        Station st7 = new Station("st7", line3);
        stations.add(st7);
        Station st8 = new Station("st8", line3);
        stations.add(st8);
        Station st9 = new Station("st9", line3);
        stations.add(st9);

        connections = new TreeMap<Station, TreeSet<Station>>();
        connections.put(st2, new TreeSet<Station>());

        TreeSet<Station> connectedStations = new TreeSet<>();
        connectedStations = connections.get(st2);
        connectedStations.add(st4);
        System.out.println("1connections - " + connections);

    }
//    public void testCalculateDuration(){
//        double actual = RouteCalculator.calculateDuration(route);
//        double expected = 21.5;
//        assertEquals(expected, actual);
//    }

    public void testGetRouteWithOneConnection() {

    }

    public void testGetShortestRoute () {

    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}