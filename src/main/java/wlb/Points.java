package wlb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Points extends AbstractHandler {
    public static final String path = "/api/v1/points";

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String totalPrice = request.getParameter("totalPrice");
        Royalty royalty = new Royalty();
        Point point = royalty.calculate(Double.parseDouble(totalPrice));
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        out.println(mapper.writeValueAsString(point));
        baseRequest.setHandled(true);
    }
}

class Point {
    private final int normalPoints;

    public Point(int normalPoints) {
        this.normalPoints = normalPoints;
    }

    public int getNormalPoints() {
        return normalPoints;
    }
}