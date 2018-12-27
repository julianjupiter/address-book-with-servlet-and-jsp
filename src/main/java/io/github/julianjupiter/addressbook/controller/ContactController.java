package io.github.julianjupiter.addressbook.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.julianjupiter.addressbook.domain.Contact;
import io.github.julianjupiter.addressbook.exception.ResourceNotFoundException;
import io.github.julianjupiter.addressbook.service.ContactService;
import io.github.julianjupiter.addressbook.service.ContactServiceImpl;
import io.github.julianjupiter.addressbook.util.ContactValidator;
import io.github.julianjupiter.addressbook.util.RequestUtil;
import io.github.julianjupiter.addressbook.util.Validation;

@WebServlet(name = "contactController", urlPatterns = "/contacts")
public class ContactController extends HttpServlet {

	private static final long serialVersionUID = 5063133391812788375L;
	private static final Logger LOGGER = Logger.getLogger(ContactController.class.getName());
	private static final String TEMPLATE = "/WEB-INF/template/";
	private static final String ACTION = "action";
	private static final String ID = "id";
	private static final String ERROR = "error";
	private static final String ERROR_MESSAGE = "errorMessage";
	private static final String LIST = "list";
	private static final String VIEW = "view";
	private static final String EDIT = "edit";
	private static final String UPDATE = "update";
	private static final String NEW = "new";
	private static final String SAVE = "save";
	private static final String DELETE = "delete";
	private final ContactService contactService;
	
	public ContactController() {
		this.contactService = new ContactServiceImpl();
	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean containsAction = request.getParameterMap().containsKey(ACTION);        
        if (containsAction) {
        	String action = request.getParameter(ACTION);
			boolean containsId = request.getParameterMap().containsKey(ID);
        	if (action.equals(LIST)) {
        		findAll(request, response);
        	} else if (action.equals(VIEW) && containsId) {
				view(request, response);
			} else if (action.equals(EDIT) && containsId) {
				edit(request, response);
			} else if (action.equals(NEW)) {
				create(request, response);
			} else if (action.equals(DELETE) && containsId) {
				delete(request, response);
			} else {
				response.setStatus(404);
				request.setAttribute(ERROR_MESSAGE, "Error 404, page not found!");
				render(request, response, ERROR);
			}	
		} else {
			findAll(request, response);
		}
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	boolean containsAction = request.getParameterMap().containsKey(ACTION);
        if (containsAction) {
        	String action = request.getParameter(ACTION);
        	boolean containsId = request.getParameterMap().containsKey(ID);
        	if (action.equals(SAVE)) {
	    		save(request, response);            	
        	} else if (action.equals(UPDATE) && containsId) {
	    		update(request, response);            	
        	} else if (action.equals(DELETE) && containsId) {
	    		delete(request, response);            	
        	} else {
        		response.setStatus(404);
				request.setAttribute(ERROR_MESSAGE, "Error 404, page not found!");
				render(request, response, ERROR);
        	}
        } else {
        	redirect(response, request.getRequestURI());
        }
    } 
    
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			List<Contact> contacts = contactService.findAll();
			request.setAttribute("contacts", contacts);
			render(request, response, "contact/findAll");
		} catch (Exception exception) {
			LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
			response.setStatus(500);
			request.setAttribute(ERROR_MESSAGE, "An error occurred. Please contact Administrator!");
			render(request, response, ERROR);
		}
    }
    
    public void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
	    	long id = Long.parseLong(request.getParameter(ID));
			Contact contact = contactService.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Contact with ID " + id + " not found."));
			request.setAttribute("contact", contact);
			render(request, response, "contact/view");
	    } catch (ResourceNotFoundException exception) {
			LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
			response.setStatus(404);
			request.setAttribute(ERROR_MESSAGE, exception.getMessage());
			render(request, response, ERROR);
		} catch (Exception exception) {
			LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
			response.setStatus(500);
			request.setAttribute(ERROR_MESSAGE, "An error occurred. Please contact Administrator!");
			render(request, response, ERROR);
		}
	}
    
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			render(request, response, "contact/create");
		} catch (Exception e) {
			response.setStatus(500);
			request.setAttribute(ERROR_MESSAGE, "An error occurred. Please contact Administrator!");
			render(request, response, ERROR);
		}
	}
    
    public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String firstName = RequestUtil.input(request, "firstName").trim();
    	String lastName = RequestUtil.input(request, "lastName").trim();
    	String mobileNumber = RequestUtil.input(request, "mobileNumber").trim();
    	String emailAddress = RequestUtil.input(request, "emailAddress").trim();
    	String address = RequestUtil.input(request, "address").trim();
    	Contact contact = new Contact();
    	contact.setFirstName(firstName);
    	contact.setLastName(lastName);
    	contact.setMobileNumber(mobileNumber);
    	contact.setEmailAddress(emailAddress);
    	contact.setAddress(address);
    	Validation validation = new ContactValidator().validate(contact);
    	if (validation.hasErrors()) {
			request.setAttribute("contact", contact);
			request.setAttribute("errors", validation.getErrors());
			
			create(request, response);
		} else {
			contactService.save(contact);
	    	
	    	redirect(response, request.getRequestURI());
		}    	
    	
	}
    
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
	    	long id = Long.parseLong(request.getParameter(ID));
			Contact contact = contactService.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Contact with ID " + id + " not found."));
			request.setAttribute("contact", contact);
			render(request, response, "contact/edit");
	    } catch (ResourceNotFoundException exception) {
			LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
			response.setStatus(404);
			request.setAttribute(ERROR_MESSAGE, exception.getMessage());
			render(request, response, ERROR);
		} catch (Exception exception) {
			LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
			response.setStatus(500);
			request.setAttribute(ERROR_MESSAGE, "An error occurred. Please contact Administrator!");
			render(request, response, ERROR);
		}
	}
    
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	long id = Long.parseLong(request.getParameter(ID));
    	String firstName = RequestUtil.input(request, "firstName").trim();
    	String lastName = RequestUtil.input(request, "lastName").trim();
    	String mobileNumber = RequestUtil.input(request, "mobileNumber").trim();
    	String emailAddress = RequestUtil.input(request, "emailAddress").trim();
    	String address = RequestUtil.input(request, "address").trim();
    	Contact contact = new Contact();
    	contact.setId(id);
    	contact.setFirstName(firstName);
    	contact.setLastName(lastName);
    	contact.setMobileNumber(mobileNumber);
    	contact.setEmailAddress(emailAddress);
    	contact.setAddress(address);
    	Validation validation = new ContactValidator().validate(contact);
    	if (validation.hasErrors()) {
			request.setAttribute("contact", contact);
			request.setAttribute("errors", validation.getErrors());
			
			edit(request, response);
		} else {
			contactService.update(contact);
	    	
	    	redirect(response, request.getRequestURI());
		}    	
    	
	}
    
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
		String httpMethod = request.getMethod();
		long id = Long.parseLong(request.getParameter(ID));
		try {
			Contact contact = contactService.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Contact with ID " + id + " not found."));
			if (httpMethod.equals("POST")) {
				contactService.delete(id);
				redirect(response, request.getRequestURI());
			} else {
				request.setAttribute("contact", contact);
				render(request, response, "contact/delete");
			}
		} catch (ResourceNotFoundException exception) {
			LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
			response.setStatus(404);
			request.setAttribute(ERROR_MESSAGE, exception.getMessage());
			render(request, response, ERROR);
		} catch (Exception exception) {
			LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
			response.setStatus(500);
			request.setAttribute(ERROR_MESSAGE, "An error occurred. Please contact Administrator!");
			render(request, response, ERROR);
		}
	}
    
    private void render(HttpServletRequest request, HttpServletResponse response, String template) throws ServletException, IOException {
    	request.getRequestDispatcher(TEMPLATE + template + ".jsp").forward(request, response);
    }
    
    private void redirect(HttpServletResponse response, String url) throws IOException {
    	response.sendRedirect(url);
    }
}
