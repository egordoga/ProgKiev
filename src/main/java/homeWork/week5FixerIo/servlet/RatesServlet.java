package homeWork.week5FixerIo.servlet;

import homeWork.week5FixerIo.entity.Currency;
import homeWork.week5FixerIo.util.Utils;
import sun.nio.cs.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RatesServlet")
public class RatesServlet extends HttpServlet {
    Currency currency = new Currency();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String json = new String(Utils.requestToArray(request.getInputStream()));
        currency.getEntity(json);
        response.sendRedirect("../java/homeWork/week5FixerIo/");
    }
}
