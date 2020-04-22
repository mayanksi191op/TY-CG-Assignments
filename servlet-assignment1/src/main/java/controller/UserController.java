package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserDao;
import dao.UserDaoImplementation;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {

	RequestDispatcher requestDispatcher = null;
		UserDao userDao = null;

		public UserController() {
			userDao = new UserDaoImplementation();
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String action = request.getParameter("action");
			if (action == null) {
				action = "LIST";
			}

			switch (action) {
			case "LIST":
				listUser(request, response);
				break;
			case "EDIT":
				getSingleUser(request, response);
				break;
			case "DELETE":
				deleteUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String sex = request.getParameter("sex");
			String email = request.getParameter("email");
			String country = request.getParameter("country");
			UserBean userBean = new UserBean();
			userBean.setName(name);
			userBean.setCountry(country);
			userBean.setEmail(email);
			userBean.setPassword(password);
			userBean.setSex(sex);
			if (id.isEmpty() || id==null) {
				if (userDao.save(userBean)) {
					request.setAttribute("message", "saved successfully");
				}
			} else {
				userBean.setId(Integer.parseInt(id));
				if (userDao.update(userBean)) {
					request.setAttribute("message", "update successfully");
				}
			}
			listUser(request, response);
		}

		public void listUser(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			List<UserBean> list = userDao.get();
			request.setAttribute("list1", list);
			requestDispatcher = request.getRequestDispatcher("/views/users-list.jsp");
			requestDispatcher.forward(request, response);
		}
		
		public void getSingleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
			UserBean user = userDao.get(Integer.parseInt(id));
			request.setAttribute("user", user);
			requestDispatcher = request.getRequestDispatcher("/views/users-add.jsp");
			requestDispatcher.forward(request, response);
		}
		
		public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
			if(userDao.delete(Integer.parseInt(id))) {
				request.setAttribute("NOTIFICATION", "Employee Deleted Successfully!");
			}
			listUser(request, response);
		}
		
	}