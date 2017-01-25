package edu.ap.spoedgevallen;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import edu.ap.xml.XMLParser;

public class SpoedgevallenResource extends ServerResource {

	@Get("html")
	public String getSpoedgevallen() {
		XMLParser parser = new XMLParser();
		return parser.getSpoedgevallen();
	}
	
	@Post("txt")
	public String addSpoedgeval(String spoedgeval) {
		XMLParser parser = new XMLParser();
		return parser.addSpoedgeval(spoedgeval);
	}

}
