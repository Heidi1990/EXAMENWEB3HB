package edu.ap.spoedgevallen;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import edu.ap.xml.XMLParser;

public class SpoedgevallenResource extends ServerResource {

	@Get("html")
	public String getRaces() {
		XMLParser parser = new XMLParser();
		return parser.getRaces();
	}
	
	@Post("txt")
	public String addRace(String race) {
		XMLParser parser = new XMLParser();
		return parser.addRace(race);
	}

}
