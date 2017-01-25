package edu.ap.spoedgevallen;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import edu.ap.xml.XMLParser;

/**
 * This resource represents an individual race instance
 */
public class SpoedgevalResource extends ServerResource {

	@Get("html")
	public String getSpoedgeval() {
		String spoedgeval_id = getAttribute("spoedgeval_id");
		XMLParser parser = new XMLParser();
		return parser.getSpoedgeval(spoedgeval_id);
	}
	
	@Post("txt")
	public String addPatientnaam(String patientnaam) {
		String spoedgeval_id = getAttribute("spoedgeval_id");
		XMLParser parser = new XMLParser();
		return parser.addRunner(spoedgeval_id, patientnaam);
	}

}
