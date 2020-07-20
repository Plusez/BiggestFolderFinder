import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.*;

public class RouteCalculatorTest extends TestCase {

    StationIndex stationIndex = new StationIndex();
    List<Station> expectedRouteOnTheLine = new ArrayList<>();
    List<Station> expectedRouteForOneConnection = new ArrayList<>();
    List<Station> expectedRouteForTwoConnection = new ArrayList<>();


    List<Station> actualRouteOnTheLine = new ArrayList<>();
    List<Station> actualRouteForOneConnection = new ArrayList<>();
    List<Station> actualRouteForTwoConnection = new ArrayList<>();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

    @Override
    public void setUp() throws Exception {

        Line line1 = new Line(1, "Первая");
        stationIndex.addLine(line1);
        Line line2 = new Line(2, "Вторая");
        stationIndex.addLine(line2);
        Line line3 = new Line(3, "Третья");
        stationIndex.addLine(line3);

        Station st1 = new Station("st1", line1);
        line1.addStation(st1);
        stationIndex.addStation(st1);
        Station st2 = new Station("st2", line1);
        line1.addStation(st2);
        stationIndex.addStation(st2);
        Station st3 = new Station("st3", line1);
        stationIndex.addStation(st3);
        line1.addStation(st3);
        Station st4 = new Station("st4", line2);
        stationIndex.addStation(st4);
        line2.addStation(st4);
        Station st5 = new Station("st5", line2);
        line2.addStation(st5);
        stationIndex.addStation(st5);
        Station st6 = new Station("st6", line2);
        line2.addStation(st6);
        stationIndex.addStation(st6);
        Station st7 = new Station("st7", line3);
        line3.addStation(st7);
        stationIndex.addStation(st7);
        Station st8 = new Station("st8", line3);
        line3.addStation(st8);
        stationIndex.addStation(st8);
        Station st9 = new Station("st9", line3);
        line3.addStation(st9);
        stationIndex.addStation(st9);

        List<Station> connectBetweenLin1AndLine2 = Arrays.asList(st2, st4);
        stationIndex.addConnection(connectBetweenLin1AndLine2);
        List<Station> connectBetweenLin2AndLine3 = Arrays.asList(st5, st8);
        stationIndex.addConnection(connectBetweenLin2AndLine3);

        expectedRouteOnTheLine.add(st1);
        expectedRouteOnTheLine.add(st2);
        expectedRouteOnTheLine.add(st3);

        expectedRouteForOneConnection.add(st1);
        expectedRouteForOneConnection.add(st2);
        expectedRouteForOneConnection.add(st4);
        expectedRouteForOneConnection.add(st5);
        expectedRouteForOneConnection.add(st6);

        expectedRouteForTwoConnection.add(st1);
        expectedRouteForTwoConnection.add(st2);
        expectedRouteForTwoConnection.add(st4);
        expectedRouteForTwoConnection.add(st5);
        expectedRouteForTwoConnection.add(st8);
        expectedRouteForTwoConnection.add(st9);

//        Station from = st1;
//        Station to = st3;

    }

    public void testGetShortestRoute() {
        actualRouteOnTheLine = routeCalculator.getShortestRoute (stationIndex.getStation("st1"), stationIndex.getStation("st3"));
        assertEquals(expectedRouteOnTheLine, actualRouteOnTheLine);
    }
    public void testGetShortestRouteForOneConnection(){
        actualRouteForOneConnection = routeCalculator.getShortestRoute(stationIndex.getStation("st1"), stationIndex.getStation("st6"));
        assertEquals(expectedRouteForOneConnection, actualRouteForOneConnection);
    }
    public void testGetShortestRouteForTwoConnection(){
        actualRouteForTwoConnection = routeCalculator.getShortestRoute(stationIndex.getStation("st1"), stationIndex.getStation("st9"));
        assertEquals(expectedRouteForTwoConnection, actualRouteForTwoConnection);
    }
    public void testCalculateDuration(){
        double actual = routeCalculator.calculateDuration(expectedRouteOnTheLine);
        double expected = 5.0;
        assertEquals(expected, actual);
    }
    public void testCalculateDurationForOneConnection(){
        double actual = routeCalculator.calculateDuration(expectedRouteForOneConnection);
        double expected = 11.0;
        assertEquals(expected, actual);
    }
    public void testCalculateDurationForTwoConnection(){
        double actual = routeCalculator.calculateDuration(expectedRouteForTwoConnection);
        double expected = 14.5;
        assertEquals(expected, actual);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
