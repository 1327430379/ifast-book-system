package com.fhk.sample.web.controller;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class MainController 
{
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String std(final HttpServletRequest httpRequest, final Locale locale, final ModelMap model, final HttpSession session) throws IOException 
	{
		final String APPLICATION = "std";

		model.put("app", APPLICATION);
		model.put("locale", locale);
		model.put("contextPath", httpRequest.getContextPath());
		return APPLICATION;
	}

	@RequestMapping(value = "/sandbox")
	public String sandbox(final HttpServletRequest httpRequest, final Locale locale, final ModelMap model) {
		return "sandbox";
	}
}
