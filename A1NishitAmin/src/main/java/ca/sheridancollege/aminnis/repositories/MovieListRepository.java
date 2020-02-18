package ca.sheridancollege.aminnis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import ca.sheridancollege.aminnis.beans.Movies;

public interface MovieListRepository extends JpaRepository<Movies,Long>{

	public List<Movies> findByMovietitleContaining(String title);
	public List<Movies> findByDirectorsContaining(String directors);
	public List<Movies> findByGenreContaining(String genre);
	public List<Movies> findByStarratingContaining(String starrating);
	public List<Movies> findByYearContaining(String year);
	public List<Movies> findByMovieid(Long movieid);
	public List<Movies> findByOrderByMovietitle();
	public List<Movies> findByOrderByDirectors();
	public List<Movies> findByOrderByGenre();
	public List<Movies> findByOrderByYear();
	public List<Movies> findByOrderByStarrating();
}