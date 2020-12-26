package org.jesperancinha.jtd.jee.app1;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;

@WebServlet("/popartists/sales")
public class PopArtistsSalesServlet extends HttpServlet {

    @Inject
    PopArtistsService popArtistsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Consolerizer.typingWaitGlobal = 0;
        Consolerizer.maxLineCharsGlobal = 500;
        Consolerizer.titleSpread = 500;
        Consolerizer.blackAndWhite = false;
        printBlueGenericTitleLn("Application1");
        printBlueGenericTitleLn(PopArtistsSalesServlet.this.getClass());

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>An artists page</title></head><body>");
        writer.println("<h1>" + popArtistsService.popArtists() + "</h1>");
        final String exercise1 = "Note that in JEE, we do not need to use any extra annotation to inject a Service.\n"
            + "The service itself, does not use any annotation";
        writer.println("<p>" + exercise1 + "</p>");
        writer.println("</body></html>");
        writer.close();
    }

}