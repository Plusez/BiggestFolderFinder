import core.Line;
import core.Station;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;


public class RouteCalculatorTest {

    StationIndex stationIndex = new StationIndex();
    String routeString;
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

    @Before
    public void setUp() {

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
    }


    public List<Station> getExpectedRoute() {
        List<Station> expectedRoute = new ArrayList<>();
        for (String st : routeString.split(" ")) {
            stationIndex.getStation(st);
            expectedRoute.add(stationIndex.getStation(st));
        }
        return expectedRoute;
    }

    @Test
    public void testGetShortestRoute() {
        List<Station> actualRouteOnTheLine;
        routeString = "st1 st2 st3";
        actualRouteOnTheLine = routeCalculator.getShortestRoute(stationIndex.getStation("st1"), stationIndex.getStation("st3"));
        Assert.assertEquals(getExpectedRoute(), actualRouteOnTheLine);
    }

    @Test
    public void testGetShortestRouteForOneConnection() {
        List<Station> actualRouteForOneConnection;
        routeString = "st1 st2 st4 st5 st6";
        actualRouteForOneConnection = routeCalculator.getShortestRoute(stationIndex.getStation("st1"), stationIndex.getStation("st6"));
        Assert.assertEquals(getExpectedRoute(), actualRouteForOneConnection);
    }

    @Test
    public void testGetShortestRouteForTwoConnection() {
        List<Station> actualRouteForTwoConnection;
        routeString = "st1 st2 st4 st5 st8 st9";
        actualRouteForTwoConnection = routeCalculator.getShortestRoute(stationIndex.getStation("st1"), stationIndex.getStation("st9"));
        Assert.assertEquals(getExpectedRoute(), actualRouteForTwoConnection);
    }

    @Test
    public void testCalculateDuration() {
        routeString = "st1 st2 st3";
        double actual = RouteCalculator.calculateDuration(getExpectedRoute());
        double expected = 5.0;
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalculateDurationForOneConnection() {
        routeString = "st1 st2 st4 st5 st6";
        double actual = routeCalculator.calculateDuration(getExpectedRoute());
        double expected = 11.0;
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalculateDurationForTwoConnection() {
        routeString = "st1 st2 st4 st5 st8 st9";
        double actual = routeCalculator.calculateDuration(getExpectedRoute());
        double expected = 14.5;
        Assert.assertEquals(expected, actual, 0.1);
    }
}
