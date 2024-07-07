package com.car.search.carsearchapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.car.search.carsearchapp.dto.SearchParams;
import com.car.search.carsearchapp.entity.Car;
import com.car.search.carsearchapp.service.CarService;

import jakarta.servlet.http.HttpServletResponse;


/**
 * Controller handling web requests related to car searching and downloading in XML format.
 */
@Controller
public class CarController {

	@Autowired
	private CarService carService;

	
	/**
     * GET endpoint for displaying the car search form.
     * @param model Model for passing data to the view
     * @return View name for the car search form
     */
	@GetMapping("/cars")
	public String showCarSearchForm(Model model) {
		model.addAttribute("searchParams", new SearchParams());
		return "car-search-form";
	}

	 /**
     * POST endpoint for processing car search based on given parameters.
     * @param params Search parameters from the form
     * @param model Model for passing data to the view
     * @return View name for displaying search results
     */
	@PostMapping("/search")
    public String searchCars(@ModelAttribute("searchParams") SearchParams params, Model model) {
        List<Car> cars = carService.searchCars(params.getLength(), params.getMinLength(), params.getMaxLength(),
                                               params.getWeight(), params.getMinWeight(), params.getMaxWeight(),
                                               params.getVelocity(), params.getMinVelocity(), params.getMaxVelocity(),
                                               params.getColor());
        model.addAttribute("cars", cars);
        return "car-search-results";
    }

	
	 /**
     * POST endpoint for downloading car search results in XML format.
     * @param carIds List of car IDs to download
     * @param response HttpServletResponse to write XML response
     * @throws IOException If an I/O exception occurs during XML generation or writing
     */
	@PostMapping("/download/xml")
    public void downloadCarsXml(@RequestParam("carIds") List<Long> carIds, HttpServletResponse response)
            throws IOException {
        List<Car> cars = carService.getCarsByIds(carIds);

        // Generate XML content
        String xmlContent = generateXmlContent(cars);

        // Set the content type and header for the response
        response.setContentType("application/xml");
        response.setHeader("Content-Disposition", "attachment; filename=cars.xml");

        // Write XML content to the response
        response.getWriter().write(xmlContent);
    }

	
	/**
     * Generates XML content from the list of cars.
     * @param cars List of cars to convert to XML
     * @return XML content as a String
     */
    private String generateXmlContent(List<Car> cars) {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlBuilder.append("<cars>\n");
        for (Car car : cars) {
            xmlBuilder.append("\t<car>\n");
            xmlBuilder.append("\t\t<id>").append(car.getId()).append("</id>\n");
            xmlBuilder.append("\t\t<length>").append(car.getLength()).append("</length>\n");
            xmlBuilder.append("\t\t<weight>").append(car.getWeight()).append("</weight>\n");
            xmlBuilder.append("\t\t<velocity>").append(car.getVelocity()).append("</velocity>\n");
            xmlBuilder.append("\t\t<color>").append(car.getColor()).append("</color>\n");
            xmlBuilder.append("\t</car>\n");
        }
        xmlBuilder.append("</cars>");
        return xmlBuilder.toString();
    }
	
    /**
     * Exception handler for IOException specifically.
     * @param ex IOException instance
     * @param model Model for passing error data to the error page
     * @return View name for the error page
     */
    @ExceptionHandler(IOException.class)
    public String handleIOException(IOException ex, Model model) {
        model.addAttribute("error", "IO Error occurred: " + ex.getMessage());
        return "error-page";
    }

    
    /**
     * General exception handler for any unexpected exceptions.
     * @param ex Exception instance
     * @param model Model for passing error data to the error page
     * @return View name for the error page
     */
    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, Model model) {
        model.addAttribute("error", "An unexpected error occurred: " + ex.getMessage());
        return "error-page";
    }
	
	
	
}
