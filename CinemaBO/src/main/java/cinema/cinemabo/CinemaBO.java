package cinema.cinemabo;

import cinema.cinemabo.modelBO.Client;
import cinema.cinemabo.modelBO.Movie;
import cinema.cinemabo.modelBO.Reservation;
import cinema.cinemabo.modelBO.Seat;
import cinema.cinemabo.modelBO.SeatShow;
import cinema.cinemabo.modelBO.Show;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

/**
 *
 * @author Krystian
 */
public class CinemaBO {

    private List<Movie> movies;
    private List<Reservation> reservations;
    private List<Seat> seats;
    private List<Show> shows;
    private List<Client> clients;

    private int columnNumber;
    private int rowNumber;

    public CinemaBO() {

    }

    @PostConstruct
    public void init() {

        columnNumber = 20;
        rowNumber = 20;
        allocateList();
        generateData();
    }

    public void allocateList() {
        movies = new ArrayList<>();
        reservations = new ArrayList<>();
        seats = new ArrayList<>();
        shows = new ArrayList<>();
        clients = new ArrayList<>();
    }

    private void generateData() {
        Random random = new Random();
        for (int movieAdded = 0; movieAdded < 300; movieAdded++) {
            Movie added = new Movie(movieAdded);
            added.setName("Film " + movieAdded);
            movies.add(added);
        }
        movies.stream().forEach((Movie movie) -> {
            for (int showNumber = 0; showNumber < 30; showNumber++) {
                Show added = new Show(showNumber + movie.getId() * 30);
                added.setProjectiondate(new Date(2016, 11, showNumber));
                added.setProjectionhour(random.nextInt(24));
                added.setProjectionminute(random.nextInt(60));
                added.setMovie(movie);
                shows.add(added);
            }
        });

        //generowanie sali kinowej
        generateSeats(0,19,5,13);
        generateSeats(19,20,0,20);
        generateSeats(7,19,0,2);
        generateSeats(7,19,17,20);
    }

    public void generateSeats(int row0,int row1, int col0,int col1) {
        for (int col = col0; col < col1; col++) {
            for (int row = row0; row < row1; row++) {
                seats.add(new Seat(col + row * 20, row, col));
            }
        }
    }

    public List<SeatShow> getSeatShow(int showId) {
        List<Seat> allSeats = getAllSeats();
        List<Reservation> reservationsOnShow = getReservationOnShow(getShowById(showId));

        List<Seat> reservedSeats = new ArrayList<>();
        List<Seat> freeSeats = new ArrayList<>();
        allSeats.stream().forEach(
                seat -> {
                    if (reservationsOnShow.stream().anyMatch(r -> r.getSeat().equals(seat))) {
                        reservedSeats.add(seat);
                    } else {
                        freeSeats.add(seat);
                    }
                }
        );

        List<SeatShow> seatShow = reservedSeats.stream().map(s -> new SeatShow(s.getRow(), s.getCol(), true)).collect(Collectors.toList());

        seatShow.addAll(freeSeats.stream().map(s -> new SeatShow(s.getRow(), s.getCol(), false)).collect(Collectors.toList()));

        return seatShow;
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public List<Seat> getAllSeats() {
        return seats;
    }

    public List<Show> getAllShows() {
        return shows;
    }

    public List<Show> getShowsFromDate(Date date) {
        return shows.stream().filter(s -> s.getProjectiondate().after(date)).collect(Collectors.toList());
    }

    public List<Reservation> getReservationOnShow(Show show) {
        if (reservations.isEmpty()) {
            return new ArrayList<>();
        }
        return reservations.stream().filter(r -> r.getShow() == show).collect(Collectors.toList());
    }

    public Movie getMovieById(int id) {
        Movie movie = movies.stream().filter(m -> m.getId().equals(id)).findFirst().get();
        return movie;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public Client addClient(String name, String surname, String phone, String email) {
        Client added = new Client(name, surname, phone, email);
        clients.add(added);
        return added;
    }

    public void addReservation(Show show, Seat seat, Client client) {
        Reservation reservation = new Reservation();
        reservation.setSeat(seat);
        reservation.setShow(show);
        reservations.add(reservation);
    }

    public void addReservation(Show show, List<Seat> seat, Client client) {
        seat.forEach(s
                -> {
            Reservation reservation = new Reservation();
            reservation.setSeat(s);
            reservation.setShow(show);
            reservations.add(reservation);
        });
    }

    public void addReservation(List<SeatShow> seatshow, int showID, Client client) {
        seatshow.forEach(ss
                -> {
            Reservation reservation = new Reservation();
            reservation.setSeat(getSeat(ss.getRowNumber(), ss.getColumnNumber()));
            reservation.setShow(getShowById(showID));
            reservations.add(reservation);
        });
    }

    public List<Show> getShowsByMovie(Movie movie) {
        return shows.stream().filter(s -> s.getMovie().equals(movie)).collect(Collectors.toList());
    }

    public Show getShowById(int id) {
        return shows.stream().filter(s -> s.getId() == id).findFirst().get();
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Seat getSeat(int row, int column) {
        Seat searched = seats.stream().filter(s -> (s.getCol() == column && s.getRow() == row)).findFirst().get();
        return searched;
    }
}
