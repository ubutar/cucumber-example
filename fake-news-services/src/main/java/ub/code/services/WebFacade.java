package ub.code.services;

import org.springframework.beans.factory.annotation.Autowired;
import ub.code.core.driver.BrowserFactory;

public class WebFacade {
    @Autowired
    protected BrowserFactory browserFactory;
}
