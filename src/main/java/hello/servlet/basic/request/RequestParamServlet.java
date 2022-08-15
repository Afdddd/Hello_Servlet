package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회]"); // http://localhost:8080/request-param?name=kim&age=20

        request.getParameterNames().asIterator()
                .forEachRemaining(paramNames -> System.out.println(paramNames +"="+ request.getParameter(paramNames)));

        System.out.println();

        System.out.println("[단일 파라미터 조회]"); // http://localhost:8080/request-param?name=kim&age=20
        String username = request.getParameter("name");
        String age = request.getParameter("age");

        System.out.println("name = "+username);
        System.out.println("age = "+age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]"); // http://localhost:8080/request-param?name=kim&age=20&name=park
        String[] names = request.getParameterValues("name");
        for (String name : names) {
            System.out.println("name = "+name);
        }
        System.out.println();

        response.getWriter().write("ok");
    }
}
