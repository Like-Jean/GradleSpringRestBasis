package web;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import dto.CarDTO;

public interface RentService {

	@RequestMapping(value = "/entryPoint", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResourceSupport get();
	
	/**
	*
	* @return all cars not rented
	*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Resource<CarDTO>> getCars();
	
	/**
	* Return specifications of a car.
	* @param plateNumber
	* @return car specifications only (if not rented)
	* @throws Exception no car with this plate number or already rented
	*/
	@RequestMapping(value = "/car/{plateNumber}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Resource<CarDTO> getCar(@PathVariable("plateNumber") String plateNumber) throws Exception;
	
	/**
	* Rent a car.
	* @param plateNumber
	* @return car specifications
	* @throws Exception no car with this plate number or already rented
	*/
	@RequestMapping(value = "/car/{plateNumber}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void rentCar(@PathVariable("plateNumber") String plateNumber) throws Exception;

	/**
	*
	** @return get back a car
	* @throws Exception no car with this plate number or not rented
	*/
	@RequestMapping(value = "/car/{plateNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void renderCar(@PathVariable("plateNumber") String plateNumber) throws Exception;
}
