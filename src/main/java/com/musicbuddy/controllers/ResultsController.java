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

	private static List<Results> list = new ArrayList<Results>();

		
	@RequestMapping(value = "/albums", method = RequestMethod.GET)
	public ModelAndView get() {
		ResultsArr.getAllAlbums();
		ResultsContainer resultsContainer = new ResultsContainer();
		resultsContainer.setList(list);
		
		return new ModelAndView("albums" , "resultsContainer", resultsContainer);
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("resultsContainer") ResultsContainer resultsContainer) {
		System.out.println(resultsContainer);
		System.out.println(resultsContainer.getList());
		List<Results> list = resultsContainer.getList();
		
		if(null != list && list.size() > 0) {
			ResultsController.list = list;
			for (Results lists : list) {
				System.out.printf("%s \t %s \n", lists.getName(), lists.getTitle());
			}
		}
		
		return new ModelAndView("view", "resultsContainer", resultsContainer);
	}
}