<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <div class="col-sm-6 col-md-4">

          <div class="thumbnail">
              <h3>Film</h3>
            <div class="caption">
                <p>${movie.id}</p>
               
              <a href="./reservation/movie/${movie.id}" class="btn btn-danger" role="button" >Rezerwuj</a> 
            </div>
          </div>
        </div>
        


