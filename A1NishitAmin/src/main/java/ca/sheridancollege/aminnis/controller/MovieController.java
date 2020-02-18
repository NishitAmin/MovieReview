package ca.sheridancollege.aminnis.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.aminnis.beans.Movies;
import ca.sheridancollege.aminnis.beans.Review;
import ca.sheridancollege.aminnis.repositories.MovieListRepository;
import ca.sheridancollege.aminnis.repositories.ReviewListRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MovieController {

	private MovieListRepository movieListRepository;
	private ReviewListRepository reviewListRepository; 
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("movieList",movieListRepository.findAll());
		return "index";
	}

	@GetMapping("/findByMovieTitle")
	public String findByMovietitle(Model model,@RequestParam String search) {
		List<Movies> movielist=movieListRepository.findByMovietitleContaining(search);
		for(Movies movie:movielist)
			System.out.println(movie);
		model.addAttribute("movieList",movielist);
		return "viewData";
	}
	
	@GetMapping("/findByDirectors")
	public String findByDirectors(Model model, @RequestParam String search) {
		List<Movies> movieList = movieListRepository.findByDirectorsContaining(search);
		for(Movies movie:movieList)
			System.out.println(movie);
		model.addAttribute("movieList",movieList);
		return "viewData";
	}
	
	@GetMapping("/findByGenre")
	public String findByGenre(Model model, @RequestParam String search) {
		List<Movies> movieList = movieListRepository.findByGenreContaining(search);
		for(Movies movie:movieList)
			System.out.println(movie);
		model.addAttribute("movieList", movieList);
		return "viewData";
	}
	
	@GetMapping("/findByStarrating")
	public String findByStarrating(Model model, @RequestParam String search) {
		List<Movies> movieList = movieListRepository.findByStarratingContaining(search);
		for(Movies movie:movieList)
			System.out.println(movie);
		model.addAttribute("movieList",movieList);
		return "viewData";
	}
	
	@GetMapping("/findByYear")
	public String findByYear(Model model, @RequestParam String search) {
		List<Movies> movieList = movieListRepository.findByYearContaining(search);
		for(Movies movie:movieList)
			System.out.println(movie);
		model.addAttribute("movieList", movieList);
		return "viewData";
	}
	
	@GetMapping("/addReview/{id}")
	public String addReview(Model model, @PathVariable Long id) {
		model.addAttribute("reviewList",reviewListRepository.findByMovieid(id));
		model.addAttribute("movie",movieListRepository.findById(id).get());
		return "review";
	}
	
	@GetMapping("/posted/{id}")
	public String addReview(Model model, @RequestParam String review, @RequestParam String star, @PathVariable Long id) {
		Review newReview = new Review();
		newReview.setMovieid(id);
		newReview.setReview(review);
		newReview.setStar(star);
		reviewListRepository.save(newReview);
		model.addAttribute("reviewList", reviewListRepository.findByMovieid(id));
		model.addAttribute("movie",movieListRepository.findById(id).get());
		return "review";
	}
	
	@GetMapping("/title")
	public String title(Model model) {
		model.addAttribute("movieList", movieListRepository.findByOrderByMovietitle());
		return "index";
	}
	
	@GetMapping("/directors")
	public String directors(Model model) {
		model.addAttribute("movieList", movieListRepository.findByOrderByDirectors());
		return "index";
	}
	
	@GetMapping("/genre")
	public String genre(Model model) {
		model.addAttribute("movieList", movieListRepository.findByOrderByGenre());
		return "index";
	}
	
	@GetMapping("/starrating")
	public String starrating(Model model) {
		model.addAttribute("movieList", movieListRepository.findByOrderByStarrating());
		return "index";
	}
	
	@GetMapping("/year")
	public String year(Model model) {
		model.addAttribute("movieList", movieListRepository.findByOrderByYear());
		return "index";
	}
}
