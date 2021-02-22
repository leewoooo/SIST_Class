package filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class LogFilter implements Filter{
	
	private PrintWriter printWriter;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String filename = filterConfig.getInitParameter("filename");
		if(filename == null) {
			throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
		}
		try{
			//FileWriter의 두번째 인자를 true로 준 이유는 작성할 때 이미 작성된 
			//내용에 추가로 append하기 위해서이다.
			//PrintWriter의 두번째 매개변수인 true는 autoflush기능을 참으로 설정
			printWriter = new PrintWriter(new FileWriter(filename,true),true);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		printWriter.println("접속한 클라이언트 IP: "+request.getRemoteAddr());
		Long start = System.currentTimeMillis();
		printWriter.println("접근한 URL 경로: "+ getURLPath(request));
		printWriter.println("요청 처리 시작 시간: " + getCurrentTime());
		chain.doFilter(request, response);
		
		Long end = System.currentTimeMillis();
		printWriter.println("요청 처리 종료 시간: " + getCurrentTime());
		printWriter.println("요청 처리 소요 시간: " + (end-start));
		printWriter.println("==================================================");
	}
	
	
	@Override
	public void destroy() {
		printWriter.close();
	}
	
	private String getURLPath(ServletRequest request) {
		HttpServletRequest httpServletRequest;
		String currentPath="";
		String queryString="";
		if(request instanceof HttpServletRequest) {
			httpServletRequest = (HttpServletRequest)request;
			currentPath = httpServletRequest.getRequestURI();
			queryString = queryString == null ? "" : "?"+queryString;
		}
		return currentPath + queryString;
	}
	
	private String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return dateFormat.format(calendar.getTime());
	}
	
}
