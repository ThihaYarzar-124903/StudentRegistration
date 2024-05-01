package student_persistant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import student_persistant.model.CourseBean;
import student_persistant.service.CourseService;

@Controller
public class CourseController {
	@Autowired
	private CourseService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayView(ModelMap model) {
		List<CourseBean> list = service.selectAll();
		if (list.size() == 0) {
			model.addAttribute("msg", "Data not found");
		} else {
			model.addAttribute("list", list);
		}

		return "displaycourse";
	}

	@RequestMapping(value = "/setupaddcourse", method = RequestMethod.GET)
	public ModelAndView setUpAddCourse() {
		return new ModelAndView("add_course", "bean", new CourseBean());
	}

	@RequestMapping(value = "/addcourse", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("bean") @Validated CourseBean bean, BindingResult bs, ModelMap model) {
		if (bs.hasErrors()) {
			return "add_course";
		} else {
			int i = service.insertData(bean);
			if (i == 0) {
				model.addAttribute("error", "Add Fail!!");
				return "add_course";
			}
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/setupupdate/{id}", method = RequestMethod.GET)
	public ModelAndView setUpUpdate(@PathVariable int id) {
		CourseBean bean = service.selectOne(id);
		return new ModelAndView("update", "courseBean", bean);
	}

	@RequestMapping(value = "/updatecourse", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("bean") @Validated CourseBean bean, BindingResult bs, ModelMap model) {
		if (bs.hasErrors()) {
			return "update";
		} else {

			int i = service.updateData(bean);
			if (i == 0) {
				model.addAttribute("error", "Update Fail!!");
				return "update";
			}
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/deletecourse/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable int id, ModelMap model) {

		int i = service.deleteData(id);
		if (i == 0) {
			model.addAttribute("error", "Delete Fail!!");
		}
		return "redirect:/";
	}
}
