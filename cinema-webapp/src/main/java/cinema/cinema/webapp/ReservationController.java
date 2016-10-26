/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.cinema.webapp;

import cinema.cinemabo.CinemaBO;
import cinema.cinemabo.modelBO.SeatShow;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Krystian
 */
@Controller
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    private CinemaBO BO;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showMovies(ModelMap model) {
        model.addAttribute("movies", BO.getAllMovies());
        return "reservation";
    }

    @RequestMapping(value = "/movie/{movie_id}", method = RequestMethod.GET)
    public String getMovieShows(@PathVariable(value = "movie_id") int movieId, ModelMap model) {

        model.addAttribute("shows", BO.getShowsByMovie(BO.getMovieById(movieId)));
        return "showList";
    }

    @RequestMapping(value = "/show/{show_id}/chooseSeat", method = RequestMethod.GET)
    public String getShowSeat(@PathVariable(value = "show_id") int showId, ModelMap model) {
        model.addAttribute("seats", BO.getSeatShow(showId));
        model.addAttribute("rowNumber", BO.getRowNumber());
        model.addAttribute("colNumber", BO.getColumnNumber());
        return "showSeat";
    }

    @RequestMapping(value = "/show/{show_id}/reserve", method = RequestMethod.POST)
    public ResponseEntity<String> getShowSeat(
            @PathVariable("show_id") int showId,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("seats[]") String seats,
            ModelMap model) {

        ObjectMapper mapper = new ObjectMapper();
        TypeFactory typeFactory = mapper.getTypeFactory();
        
        try {
            List<SeatShow> seatShow = mapper.readValue(seats, typeFactory.constructCollectionType(List.class, SeatShow.class));
            System.out.println(seatShow.get(0).getColumnNumber());
            // ToDo system rejestracji klientow - klienci dodają się za każdą nową rezerwacją
            BO.addReservation(seatShow, showId, BO.addClient(name, surname, phone, email));
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (IOException ex) {
            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //model.addAttribute("seats", dao.getMovie));
        //model.addAttribute("rowNumber", "26");
        //model.addAttribute("colNumber", "26");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
