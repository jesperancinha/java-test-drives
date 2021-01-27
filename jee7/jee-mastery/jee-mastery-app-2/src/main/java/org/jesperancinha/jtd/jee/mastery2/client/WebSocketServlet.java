package org.jesperancinha.jtd.jee.mastery2.client;

import org.jesperancinha.jtd.jee.mastery2.sockets.Lyric;

import javax.inject.Inject;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.DeploymentException;
import java.io.IOException;
import java.net.URISyntaxException;

@WebServlet("/ariaschorus/socket")
public class WebSocketServlet extends HttpServlet {

    @Inject
    private WebSocketClient webSocketClient;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Lyric lyric = new Lyric();
        lyric.setArtist("Enya");
        lyric.setSong("So I could find my way");
        lyric.setLyricExtract("A thousand dreams");
        try {
            webSocketClient.send(lyric, "ws://localhost:8080/jee-mastery-app-2-1.0.0-SNAPSHOT/ariaschorus/lyrics");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (DeploymentException e) {
            e.printStackTrace();
        }
    }
}
