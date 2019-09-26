package airport.cac226.rxr353;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class RouteNode implements Comparable<RouteNode>{

    private final Airport airport;
    private final RouteTime arrivalTime;
    private final RouteNode previous;

    private RouteNode(Airport airport, RouteTime arrivalTime, RouteNode previous) {
        this.airport = airport;
        this.arrivalTime = arrivalTime;
        this.previous = previous;
    }

    public static final RouteNode of(Airport airport, RouteTime routeTime, RouteNode previous){
        Objects.requireNonNull(airport);
        Objects.requireNonNull(routeTime);
        Objects.requireNonNull(previous);

        return new RouteNode(airport, routeTime, previous);
    }

    public static final RouteNode of(Flight flight, RouteNode previous){
        Objects.requireNonNull(flight.destination());
        Objects.requireNonNull(previous);

        return new RouteNode(flight.destination(), null, previous);
    }


    @Override
    public int compareTo(@NotNull RouteNode o) {
        return 0;
    }
}
