import java.io.*;

import javax.servlet.*;

import javax.servlet.http.*;



public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title","servlet welcome page");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line = "";

        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        String data = builder.toString();
        String [] unparsed= data.split("&");
        String login=unparsed[0].split("=")[1];
        String pass=unparsed[1].split("=")[1];
        String filename=(login.equals("admin") && pass.equals("admin") ? "success.jsp" : "fail.jsp");
        request.getRequestDispatcher(filename).forward(request, response);
    }

}
