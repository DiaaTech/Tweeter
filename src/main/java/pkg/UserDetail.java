package pkg;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UserDetail")
@MultipartConfig
public class UserDetail extends HttpServlet {
	
	 void upload_file(InputStream is, String path) throws Exception {
	        File file = new File(path);
	        if(file.exists())
	            file.delete();

	        byte [] bytes = new byte[is.available()];
	        is.read(bytes);
	        OutputStream fops = new FileOutputStream(path);
	        fops.write(bytes);
	        fops.flush();
	        fops.close();
	 }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String name = request.getParameter("name");
		Part filePart = request.getPart("image");
		String bio = request.getParameter("bio");
		String location = request.getParameter("location");
		String email = (String) session.getAttribute("email");
		
		User user = new User(email, name, bio, location, "", filePart.getSubmittedFileName());
		System.out.print(filePart.getSubmittedFileName());
		
		  //Path of File on Server
		 String filePath = getServletContext().getRealPath("/" + "images" + File.separator + filePart.getSubmittedFileName());
        System.out.print(filePath);
             
		try {
			UserDataBase dBase = new UserDataBase();
	        //File Data & Required Name
	        InputStream data = filePart.getInputStream();
	        upload_file(data, filePath);
	        
			boolean check = dBase.insertUser(user);
			
			
			if(check) {
				response.sendRedirect("main.jsp");
			}
			else {
				response.sendRedirect("takeData.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
