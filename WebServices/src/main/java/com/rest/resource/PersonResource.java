package com.rest.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

import com.rest.model.Person;


@Api(value = "/people",	
		description = "People Resource",
		produces = MediaType.APPLICATION_JSON, 
		consumes = MediaType.APPLICATION_JSON)
@Component
@Path("/people")
public class PersonResource {
	
	/**
	 * 
	 * @param startIndex
	 * @param size
	 * @return
	 */
	
	@GET
	@Produces("application/json")
	@ApiOperation(value = "Get all people", notes = "Returns a list of people", response = Person.class, responseContainer="List")
	public Response getAllPeople(
				@ApiParam(value = "Start index of the list of people", allowableValues = "range[1,1000]", required = true) 
				@QueryParam(value="startIndex") int startIndex, 
				@ApiParam(value = "List size of people returned", allowableValues = "range[1,1000]", required = true)
				@QueryParam(value="size") int size)
	{		
		List<Person> personList = getPersonList();	
		return Response.ok(personList).build();		
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	@ApiOperation(value = "Find person by ID", notes = "Returns a pet nonintegers will simulate API error conditions", response = Person.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied"), @ApiResponse(code = 404, message = "Person not found") })
	public Response getPerson(
			@ApiParam(value = "ID of person that needs to be fetched", allowableValues = "range[1,1000]", required = true) 
			@PathParam(value="id") int id)
	{
		Person person = getExamplePerson();
		
		//If there is no resource at the requested location a resource not found status is the appropriate response
		if (person == null){
	        return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok(person).build();		
	}
	
	
	/**
	 * 
	 * @param person
	 * @return
	 * @throws YpException
	 * @throws JSchException
	 * @throws SftpException
	 * @throws URISyntaxException
	 */
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	@ApiOperation(value = "Update an existing person")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied"),
	      @ApiResponse(code = 404, message = "Person not found"),
	      @ApiResponse(code = 405, message = "Validation exception") })
	public Response putPerson(@ApiParam(value = "Person object that needs to be added", required = true) Person person) {	
	
		//TODO update person	
		return Response.noContent().build();
	}
	
	/**
	 * 
	 * @param person
	 * @return
	 * @throws YpException
	 * @throws JSchException
	 * @throws SftpException
	 * @throws URISyntaxException
	 */
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@ApiOperation(value = "Add a new person")
	@ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input") })
	public Response postPerson(
			@ApiParam(value = "Pet object that needs to be added to the store", required = true) Person person) throws URISyntaxException
	{		
		//TODO save person
		Person savedPerson = getExamplePerson();
		URI location = new URI("/people/" + savedPerson.getId());
		return Response.created(location).entity(savedPerson).build();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	@DELETE
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	@ApiOperation(value = "Delete person by ID")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Person deleted")})
	public Response deletePerson( 
			@ApiParam(value = "ID of person that needs to be deleted", allowableValues = "range[1,1000]", required = true) 
			@PathParam(value="id") int id)
	{
		//TODO delete person
		return Response.noContent().build();
	}
	
	
	private Person getExamplePerson(){
		Person person = new Person();
		person.setId(1);
		person.setFirstName("don");
		person.setLastName("magic juan");
		
		return person;
	}
	
	private List<Person> getPersonList(){
		List<Person> personList = new ArrayList<Person>();
		personList.add(getExamplePerson());
		personList.add(getExamplePerson());
		personList.add(getExamplePerson());
		return personList;		
	}
}
