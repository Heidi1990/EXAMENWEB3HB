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
	public String getRace() {
		String race_id = getAttribute("race_id");
		XMLParser parser = new XMLParser();
		return parser.getRace(race_id);
	}
	
	@Post("txt")
	public String addRunner(String runner) {
		String race_id = getAttribute("race_id");
		XMLParser parser = new XMLParser();
		return parser.addRunner(race_id, runner);
	}

}
