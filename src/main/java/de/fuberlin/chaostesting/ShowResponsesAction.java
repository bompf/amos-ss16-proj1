package de.fuberlin.chaostesting;

import java.util.List;

import de.fuberlin.chaostesting.model.DAO;
import de.fuberlin.chaostesting.model.Response;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

@UrlBinding("/showResponses.action")
public class ShowResponsesAction extends GenericActionBean {

	List<Response> responses;	
	DAO<Response> responseDao = DAO.createInstance(Response.class);

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	@DefaultHandler
	public Resolution showResponses() {
		responses = responseDao.findAll();
		
		return new ForwardResolution("showResponses.jsp");
	}
}
