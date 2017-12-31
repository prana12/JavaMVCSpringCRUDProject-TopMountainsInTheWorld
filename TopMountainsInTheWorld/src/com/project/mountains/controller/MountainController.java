package com.project.mountains.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.mountains.entity.Mountain;
import com.project.mountains.service.MountainService;

@Controller
@RequestMapping("/mountain")
public class MountainController {

	@Autowired
	private MountainService mountainService;

	//add init binder to convert trim input strings
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/list")
	public String listMountains(Model theModel){
		//get the mountains from service
		List<Mountain> theMountains = mountainService.getMountains();
		theModel.addAttribute("mountains", theMountains);
		return "list-mountains";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){

		//create model attribute to bind the data
		Mountain theMountain = new Mountain();
		theModel.addAttribute("mountain",theMountain);
		theModel.addAttribute("disable", false);//disable is not enabled

		return "mountain-form";
	}

	@PostMapping("/saveMountain")
	public String saveMountain(@Valid @ModelAttribute("mountain") Mountain theMountain, 
			BindingResult theBindingResult){
		//if any errors
		//System.out.println("Name: |"+theMountain.getName()+"|");

		//System.out.println("the length of name is "+theMountain.getName().length());
		//System.out.println("the Binding Result: "+theBindingResult);
		//System.out.println("\n\n\n");
		if(theBindingResult.hasErrors()){
			return "mountain-form";
		}

		mountainService.saveMountain(theMountain);
		return "redirect:/mountain/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("rank") int rank, Model theModel){
		//get the mountain from service
		Mountain theMountain = mountainService.getMountain(rank);

		//set mountain as the model attribute to prepopulate the form
		theModel.addAttribute("mountain", theMountain);
		theModel.addAttribute("disable", true);//disable is enabled

		//send over to the form
		return "mountain-form";
	}

	@GetMapping("/delete")
	public String deleteMountain(@RequestParam("rank") int rank){
		//delete the mountain
		mountainService.deleteMountain(rank);

		return "redirect:/mountain/list";
	}

}
