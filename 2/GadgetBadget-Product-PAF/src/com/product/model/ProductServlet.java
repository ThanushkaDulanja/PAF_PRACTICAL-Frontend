package com.product.model;

import java.sql.*;

public class ProductServlet {
	

	private static Connection connect() {

		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/productdb", "root", "");

			System.out.println("Connection succsessful");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

	
	public static String readProducts() {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed

			output = "<div class=''><table class='table table-hover table-bordered table-striped table-bordered' style='width:100%' style='text-align:center'><thead class='thead-dark'>"
					+ "<th style='padding:10px; text-align:center;'>Product ID</th>"
					+ "<th style='padding:10px; text-align:center;'>Product Organization Name</th>"
					+ "<th style='padding:10px; text-align:center;'>Product Description</th>"
					+ "<th style='padding:10px; text-align:center;'>Product Country</th>"
					+ "<th style='padding:10px; text-align:center;'>Product Amount</th>"
					+ "<th style='padding:10px; text-align:center;'>Update</th><th>Remove</th></thead>";

			String query = "SELECT * FROM products";
//			System.out.println(query);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String productID = Integer.toString(rs.getInt("productID"));
				String productCode = rs.getString("productCode");
				String productName = rs.getString("productName");
				String productPrice = rs.getString("productPrice");
				String productDesc = rs.getString("productDesc");
				


				// Add into the html table
				output += "<tbody><td style='padding:10px; text-align:center;'>" + productID + "</td>";
				output += "<td style='padding:10px; text-align:center;'>" + productCode + "</td>";
				output += "<td style='padding:10px; text-align:center;'>" + productName + "</td>";
				output += "<td style='padding:10px; text-align:center;'>" + productPrice + "</td>";
				output += "<td style='padding:10px; text-align:center;'>" + productDesc + "</td>";

				// buttons
				
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-success'></td>"
						+ "<td><button class='btnRemove btn btn-danger' name='btnRemove' id ='btnRemove' value='"+ productID +"' >Remove</button></td></tbody>";
				
			}
			con.close();
			// Complete the html table
			output += "</table></div>";
		} catch (Exception e) {
			output = "Error while reading the product details...!";
			System.out.println(e.getMessage());
			System.out.println(e);
			e.printStackTrace();
		}
		return output;
	}
	
	// insert
		public String insertItem(String productCode, String productName,String productPrice,
				String productDesc) {

			String output = "";

			try {

				Connection con = connect();
				if (con == null) {
					return "Error Inserting";
				}

				String query = "INSERT INTO products (productCode, productName,productPrice, productDesc) VALUES (?, ?, ?, ?)";

				PreparedStatement ps = con.prepareStatement(query);

//						ps.setInt(1, 0);;
				ps.setString(1, productCode);
				ps.setString(2, productName);
				ps.setString(3, productPrice);
				ps.setString(4, productDesc);

				ps.execute();
				con.close();

				String newProduct = readProducts();
				output = "{\"status\":\"success\", \"data\": \"" + newProduct + "\"}";

				// output = "products Details have been Inserted Successfully !";

			} catch (Exception e) {
				// output = "products Details Inserted Failed";

				output = "{\"status\":\"error\", \"data\": \"Error while inserting the order.\"}";
				System.out.println(e.getMessage());
				System.out.println(e);
				e.printStackTrace();
			}

			return output;
		}
	
	
		// update
		public String updateItem(String productID, String productCode, String productName, String productPrice, String productDesc)
		{
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for updating."; }
			 // create a prepared statement
			 String query = "UPDATE products SET productCode=?,productName=?,productPrice=?,productDesc=? WHERE productID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setString(1, productCode);
			 preparedStmt.setString(2, productName);
			 preparedStmt.setString(3, productPrice);
			 preparedStmt.setString(4, productDesc);
			 preparedStmt.setInt(5, Integer.parseInt(productID));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();

				String newProducts = readProducts();

				output = "{\"status\":\"success\", \"data\": \"" + newProducts +  "\"}";

				 //output = "products details have been updated successfully...!";

			} catch (Exception e) {

				output = "{\"status\":\"error\", \"data\": \"Error while updating .\"}";

				// output = "Error while updating project details...!";
				System.err.println(e.getMessage());
				System.out.println(e.getMessage());
				System.out.println(e);
				e.printStackTrace();
			}

			return output;

		}

		// delete
		public String deleteItem(String productID) {

			String output = "";

			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			try {

				String query = "DELETE FROM products WHERE productID=?";
				PreparedStatement ps = con.prepareStatement(query);

		

				ps.setInt(1, Integer.parseInt(productID));

				ps.execute();
				con.close();

				String newProducts = readProducts();

				output = "{\"status\":\"success\", \"data\": \"" + newProducts + "\"}";

				

			} catch (SQLException e) {
				
				output = "{\"status\":\"error\", \"data\": \"Error while deleting the order.\"}";

				//output = "Error while deleting the project from the database.";
				System.err.println(e.getMessage());
				System.out.println(e.getMessage());
				System.out.println(e);
				e.printStackTrace();

			}

			return output;

		}
}
