package admin;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Insproduct
 */
@WebServlet("/insproduct")
public class Insproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	String pn=request.getParameter("pname");
	float pp=Float.valueOf(request.getParameter("pprice"));
	
	String hsnc=request.getParameter("hsnc");
	float cgst=Float.valueOf(request.getParameter("cgst"));
	float sgst=Float.valueOf(request.getParameter("sgst"));
		
	String barcode=request.getParameter("barcode");
	
	
	PrintWriter pr=response.getWriter();
	
	
	
	
	try {
		Connection con=Dbcon.getcon();
		
		Statement stmt=con.createStatement();
		
		
		String sql="INSERT INTO products SET product_name='"+pn+"',product_price='"+pp+"',product_hsnc='"+hsnc+"',product_cgst='"+cgst+"',product_sgst='"+sgst+"',product_barcode='"+barcode+"'";
		
		stmt.executeUpdate(sql);
		
		
		response.sendRedirect("listproducts");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
  
	
	
	
	
	
	
	
 
	
	
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
