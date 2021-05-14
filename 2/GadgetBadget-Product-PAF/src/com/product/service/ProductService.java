package com.product.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.product.model.ProductServlet;

@Path("Products")
public class ProductService {
	
	ProductServlet productObj = new ProductServlet();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readProducts() {
		return productObj.readProducts();

	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String insertItem(
			@FormParam("productCode") String productCode,
			@FormParam("productName") String productName, 
			@FormParam("productPrice") String productPrice,
			@FormParam("productDesc") String productDesc) {
				
		String output = productObj.insertItem(productCode, productName, productPrice, productDesc);
		return output;
		
	}
	
	@PUT
	@Path("/")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String updateItem(String productData) {

		JsonObject productObject = new JsonParser().parse(productData).getAsJsonObject();

		 String productID = productObject.get("productID").getAsString(); 
		 String productCode = productObject.get("productCode").getAsString(); 
		 String productName = productObject.get("productName").getAsString(); 
		 String productPrice = productObject.get("productPrice").getAsString(); 
		 String productDesc = productObject.get("productDesc").getAsString(); 
		 String output = productObj.updateItem(productID, productCode, productName, productPrice, productDesc); 
		 return output;

	}
	
	@DELETE
	@Path("/")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_XML)
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String deleteItem(String productData) {
		
		Document ducument = Jsoup.parse(productData, "", Parser.xmlParser());
		
		String productID = ducument.select("projectID").text();
		System.out.println(productID);
		String output = productObj.deleteItem(productID);
		System.out.println(output);
		return output;
		
	}

}
