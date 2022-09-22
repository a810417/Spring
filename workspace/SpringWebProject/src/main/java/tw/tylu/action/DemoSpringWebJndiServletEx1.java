package tw.tylu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.tylu.model.House;
import tw.tylu.model.HouseService;

@WebServlet("/DemoSpringWebJndiServletEx1.do")
public class DemoSpringWebJndiServletEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private WebApplicationContext context;

	public void init() throws ServletException {
		ServletContext application = getServletContext();
		context = WebApplicationContextUtils.getWebApplicationContext(application);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		HouseService houseService = context.getBean("houseService", HouseService.class);

		try {
			House resultBean = houseService.findById(1001);
			if (resultBean != null) {
				out.write(resultBean.getHouseid() + " " + resultBean.getHousename());
			} else {
				out.write("No Result!!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			out.write("Warning!!!");
			System.out.println("Warning!!!");
		}

		out.close();
	}

}
