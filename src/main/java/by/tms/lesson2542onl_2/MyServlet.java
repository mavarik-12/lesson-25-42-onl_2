package by.tms.lesson2542onl_2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/hello")
public class MyServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("=== Приложение запущено и работает! ===");
        System.out.println("Инициализирован сервлет: " + getServletName());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logRequest(req);
        resp.setContentType("text/plain; charset=UTF-8");
        resp.getWriter().write("Привет! GET-запрос успешно обработан.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logRequest(req);
        resp.setContentType("text/plain; charset=UTF-8");
        resp.getWriter().write("POST-запрос успешно обработан.");
    }

    private void logRequest(HttpServletRequest req) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeString = now.format(formatter);

        String method = req.getMethod();
        String path = req.getRequestURI();
        String ip = req.getRemoteAddr();

        System.out.printf("[LOG] %s %s от %s в %s%n", method, path, ip, timeString);
    }
}