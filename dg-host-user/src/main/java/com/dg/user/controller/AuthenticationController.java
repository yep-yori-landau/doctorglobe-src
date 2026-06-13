package com.dg.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.user.service.Authenticate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AuthenticationController {

  private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

  @Autowired
  private Authenticate authenticate;

  /**
   * Authenticate User
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public @ResponseBody
  boolean authenticate(@RequestParam(value = "username", required = true) String username,
      @RequestParam(value = "password", required = true) String password) {
    logger.debug("Authenticating user");
    boolean authenticated = authenticate.login(username, password);
    return authenticated;
  }

}
