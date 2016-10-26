/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.cinemabo.modelBO;

import java.util.Date;
import java.util.List;

public class Show {



    private Integer id;

    private Date projectiondate;

    private Integer projectionhour;

    private Integer projectionminute;

    private List<Reservation> reservationList;

    private Movie movie;

    public Show() {
    }

    public Show(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getProjectiondate() {
        return projectiondate;
    }

    public void setProjectiondate(Date projectiondate) {
        this.projectiondate = projectiondate;
    }

    public Integer getProjectionhour() {
        return projectionhour;
    }

    public void setProjectionhour(Integer projectionhour) {
        this.projectionhour = projectionhour;
    }

    public Integer getProjectionminute() {
        return projectionminute;
    }

    public void setProjectionminute(Integer projectionminute) {
        this.projectionminute = projectionminute;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Show)) {
            return false;
        }
        Show other = (Show) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
