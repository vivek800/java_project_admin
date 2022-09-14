package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class Listproducts
 */
@WebServlet("/listproducts")
public class Listproducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listproducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
HttpSession session=request.getSession();
		
		if(session.getAttribute("admin_name")==null) {
			response.sendRedirect("/project_bill/");
		}else {
		
		try {
			Connection con=Dbcon.getcon();
			
			Statement st=con.createStatement();
			
			String sql="SELECT * FROM products";
			
		ResultSet rs=st.executeQuery(sql);
		
		ArrayList<HashMap<String, String>> ar=new ArrayList<>();
		
		while(rs.next()) {
			HashMap<String, String> hm=new HashMap<>();
			hm.put("id", rs.getString("product_id"));
			hm.put("pname", rs.getString("product_name"));
			hm.put("pprice", rs.getString("product_price"));
			hm.put("phsnc", rs.getString("product_hsnc"));
			hm.put("pcgst", rs.getString("product_cgst"));
			hm.put("psgst", rs.getString("product_sgst"));
			hm.put("pbarcode", rs.getString("product_barcode"));
			
			ar.add(hm);
			
			
		}
		request.setAttribute("products", ar);
		
		request.getRequestDispatcher("listproduct.jsp").forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
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
