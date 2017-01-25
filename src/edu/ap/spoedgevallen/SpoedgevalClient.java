package edu.ap.spoedgevallen;

import org.restlet.resource.ClientResource;

public class SpoedgevalClient {

     public static void main(String[] args) {
           
             try {
            	ClientResource resource = new ClientResource("http://localhost:8181/Spoedgevallen/spoedgeval");
            	// Post a new spoedgeval
            	String spoedgeval = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
            	spoedgeval += "<patientnaam=\"Jan Smith\" geboortedatum=\"13/07/2010\" verpleegkundigenaam=\"Lucie de Bie\" diagnose=\"oorontsteking\"id=\"25\"><uri>spoedgeval/25</uri>";
            	
            	spoedgeval += "<patienten></patienten></spoedgeval>";
        		resource.post(spoedgeval);
        		// get the response
            	System.out.println(resource.getResponseEntity().getText());
            }
            catch (Exception e) {
                System.out.println("In main : " + e.getMessage());
            }
        }
    }
