package assembler;
import dto.CarDTO;
import web.MyRentController;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * This class shows a resource assembler for a HATEOAS REST Service we are
 * mapping the DTO to a resource that can provide links to the different parts
 * of the API See
 * http://docs.spring.io/spring-hateoas/docs/current/reference/html/
 *
 * @author Like
 */
@Component
public class CarResourceAssembler implements ResourceAssembler<CarDTO, Resource<CarDTO>>{

	@Override
	public Resource<CarDTO> toResource(CarDTO CarDTO) {
		String plateNumber = new String();
		plateNumber = CarDTO.getPlateNumber();
		
		Resource<CarDTO> CarResource = new Resource<CarDTO>(CarDTO);
		
		try {
            CarResource.add(linkTo(MyRentController.class).slash(plateNumber).withSelfRel());

        } catch (Exception ex) {
            Logger.getLogger(MyRentController.class.getName()).log(Level.SEVERE, "could not link resource from MyRentController", ex);
        }
		return CarResource;
	}

}
