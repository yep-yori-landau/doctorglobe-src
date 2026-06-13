package com.dg.data.controller.crud;

import java.io.File;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.data.model.db.Healthcareproviderphoto;
import com.dg.data.service.HealthcareproviderphotoService;
import com.dg.data.service.HealthcareproviderService;

/**
 * Handles all crud operations for Healthcareproviderphoto table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareproviderphoto")
public class HealthcareproviderphotoController
		extends AbstractCrudController<Healthcareproviderphoto> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderphotoController.class);

	@Autowired
	public HealthcareproviderphotoService healthcareproviderphotoService;

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public HealthcareproviderphotoController(
			HealthcareproviderphotoService healthcareproviderphotoService) {
		super.setGenericService(healthcareproviderphotoService);
	}

	/**
	 * 
	 * handle healthcareproviderphoto edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Healthcareproviderphoto healthcareproviderphoto, Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderphoto",
					healthcareproviderphotoService.get(id));
		}
		model.addAttribute("healthcareproviderList",
				healthcareproviderService.getAll());
		return "healthcareproviderphoto/edit";
	}

	/**
	 * 
	 * handle healthcareproviderphoto edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Healthcareproviderphoto healthcareproviderphoto,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			@RequestParam("file") MultipartFile file,
			MultipartHttpServletRequest request, Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save healthcareproviderphoto",
					bindingResult.getErrorCount());
			model.addAttribute("healthcareproviderList",
					healthcareproviderService.getAll());
			return "healthcareproviderphoto/edit";
		}
		logger.info(file.getOriginalFilename());
		if (!file.isEmpty()) {
			try {
				String filename = file.getOriginalFilename();
				File f = new File("/tmp/" + file.getOriginalFilename());
				file.transferTo(f);
				healthcareproviderphoto.setPath(filename);
				healthcareproviderphoto.setType("photo");
				healthcareproviderphotoService.edit(healthcareproviderphoto);
				redirectAttributes.addFlashAttribute("message",
						"Successfully Created/Edited");
			}
			catch (Exception ex) {
				logger.info(ex.getMessage());
			}
		}
		return "redirect:/healthcareproviderphoto/index";
	}

}