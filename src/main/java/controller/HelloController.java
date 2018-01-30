package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class HelloController {
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, path = { "/hello.controller" })
	public String method2(String name, Model model, HttpSession session) {
		// 接收資料
		model.addAttribute(name);
		
		// 驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
		
		if (name == null || name.length() == 0) {
			errors.put("name", "name is required(annotation)");
		}

		if (errors != null && !errors.isEmpty()) {
			return "hello.form";
		}

		return "hello.success";
	}

}
