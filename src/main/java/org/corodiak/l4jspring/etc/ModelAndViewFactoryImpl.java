package org.corodiak.l4jspring.etc;

import org.springframework.web.servlet.ModelAndView;

public class ModelAndViewFactoryImpl implements ModelAndViewFactory {
    @Override
    public ModelAndView mav() {
        return new ModelAndView();
    }
}
