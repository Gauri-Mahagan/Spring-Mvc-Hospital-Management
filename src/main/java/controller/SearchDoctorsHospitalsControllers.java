package controller;

import dao.SearchDoctorsDao;
import domain.SearchDoctors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("doctorsSearchBar")
public class SearchDoctorsHospitalsControllers {
    @Autowired
    SearchDoctorsDao searchDoctorsDao;

    public SearchDoctorsHospitalsControllers(SearchDoctorsDao searchDoctorsDao) {
        this.searchDoctorsDao = searchDoctorsDao;
    }

    @ModelAttribute
    public SearchDoctors getSearchDoctors() {
        return new SearchDoctors();
    }

    //for searching doctors in hospital controller
    @RequestMapping("/searchdoctorsfromhospital")
    public String searchDoctorsFromHospitals(Model model) {
        model.addAttribute("command", new SearchDoctors());
        return "searchdoctorfromhospitals";
    }

    // for this it provides the facility of to check are available
    @RequestMapping(value = "/ checkdoctorsonlineavaliabilities", method = RequestMethod.POST)
    public ModelAndView howManyDoctorsAreThereInUnits(@ModelAttribute("doctors") SearchDoctors searchDoctors) {
        ModelAndView modelAndView = null;
        SearchDoctors searchDoctors1 = null;
        try {
            if (searchDoctors.getDoctorName() != null && searchDoctors.getDoctorName() != "") {
                searchDoctors1 = searchDoctors.getDoctorByName(searchDoctors.getDoctorName());
            }
            if (searchDoctors.getDoctorName() != null && searchDoctors.getDoctorRegistrationNumber() != "") {
                searchDoctors1 = searchDoctors.getDoctorByRegistrationNumber(searchDoctors.getDoctorRegistrationNumber());
            }
            modelAndView = new ModelAndView();
            if (null != searchDoctors1) {
                System.out.print(searchDoctors1.getId() + "......" + searchDoctors1.getDoctorName() + ".........." +
                        searchDoctors1.getDoctorRegistrationNumber() + "...." + searchDoctors1.getGender() + "......" + searchDoctors1.getQualification());

                boolean isAvailable = false;
                modelAndView.addObject("DoctorName", searchDoctors1.getDoctorName());
                modelAndView.addObject("  DoctorRegistrationNumber", searchDoctors1.getDoctorRegistrationNumber());
                modelAndView.addObject("Qualification", searchDoctors1.getQualification());
                modelAndView.addObject("Gender", searchDoctors1.getGender());


            } else {

                modelAndView.addObject("DoctorName", searchDoctors1.getDoctorName());
                modelAndView.addObject("DoctorRegistrationNumber", " Not available ");
            }


        } catch (Exception exception) {
            exception.printStackTrace();

        }
        return modelAndView;
    }
}