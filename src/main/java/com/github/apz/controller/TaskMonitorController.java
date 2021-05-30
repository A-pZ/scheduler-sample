/**
 * 
 */
package com.github.apz.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.apz.model.Task;
import com.github.apz.service.TaskService;

import lombok.AllArgsConstructor;

/**
 * @author a-pz
 *
 */
@Controller
@RequestMapping("")
@AllArgsConstructor
public class TaskMonitorController {
	
	TaskService service;
	
	@GetMapping
	public ModelAndView display(ModelAndView mnv) {
		
		List<Task> tasks = service.taskList();
		
		mnv.addObject("tasks", tasks);
		mnv.setViewName("tasks");
		return mnv;
	}
	
}
