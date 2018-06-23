package com.musicbuddy.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.musicbuddy.Results;
import com.musicbuddy.ResultsArr;
import com.musicbuddy.ResultsContainer;

@Controller
@RequestMapping({"/","/albums"})
public class ResultsController {

	private List<Results> list = new ArrayList<Results>();

		
	@RequestMapping(value = "/albums", method = RequestMethod.GET)
	public ModelAndView get() {
		ResultsArr.getAllAlbums();
		ResultsContainer resultsContainer = new ResultsContainer();
		resultsContainer.setList(list);
		
		return new ModelAndView("albums" , "resultsContainer", resultsContainer);
	}
	
	//@SuppressWarnings("static-access")
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view() {
		ResultsContainer vm = new ResultsContainer();
		vm.setList(new ResultsArr().getAllAlbums());
		
		return new ModelAndView("view", "model", vm);
	}
}