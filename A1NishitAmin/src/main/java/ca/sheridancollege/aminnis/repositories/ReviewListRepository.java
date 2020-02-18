package ca.sheridancollege.aminnis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.aminnis.beans.Review;

public interface ReviewListRepository extends JpaRepository<Review,String>{

	public List<Review> findByMovieid(Long movieid);
	
}