package com.nikolay.converterdemo;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TemperatureConversionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;                                                                    // for compatibility and version control when the servlet might be serialized(not required)

    public void doGet (HttpServletRequest req, HttpServletResponse res)                                                 // method is automatically called when the client sends a GET request
            throws ServletException, IOException {

        String unitF = req.getParameter("fahrenheit");                                                               //!!!!!!!!!!!Must match fahrenheit from var url = "/SimpleTemperatureConverter/convert?fahrenheit=" + encodeURIComponent(value);!!!!!

        res.setContentType("text/xml");
        res.setHeader("Cache-Control", "no-cache");

        if (unitF != null)
            try {                                                                                                       // try catch because user might input something wrong but still execute because otherwise crash

                double fValue = Double.parseDouble(unitF);
                double cValue = (fValue - 32) * 5 / 9;

                String xml = "<conversion>" + "<result>" + String.format("%.2f", cValue) + "</result>" + "</conversion>";

                res.getWriter().write(xml);

            } catch (NumberFormatException e) {

                res.getWriter().write("<conversion><result>?</result></conversion>");

            }
        else {

            res.getWriter().write("<conversion><result>?</result></conversion>");

        }

    }

}
