package com.qh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/registration/*")
public class Loginfilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * HttpSession session= ServletActionContext.getRequest().getSession();
		 * String username = (String)session.getAttribute("username"); if (null
		 * != username) { chain.doFilter(request, response); }else {
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("/admin/login.jsp");
		 * dispatcher.forward(request, response); }
		 */

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		// 获得用户请求的URI
		String path = req.getRequestURI();
		System.out.println(path);
		// 从session取得已经登录验证的凭证
		String password = (String) session.getAttribute("username");
		
		//System.out.println(password);
		if (path.indexOf("login.jsp") > -1) {
			System.out.println("int----"+path.indexOf("login.jsp"));							// 不然过滤器就。。。。。自行调试不要偷懒！这样记忆深刻
			chain.doFilter(req, resp);
			return;
		} else {// 如果不是login.jsp进行过滤
			if (password == null || "".equals(password)) {
				// 跳转到登陆页面
				resp.sendRedirect("/ssh_3/admin/login.jsp");
			} else {
				// 已经登陆,继续此次请求
				chain.doFilter(req, resp);
			}
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
