package servlet;

import bean.OrderItem;
import bean.Product;
import com.sun.org.apache.xpath.internal.operations.Or;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num = Integer.parseInt(req.getParameter("num"));
        int pid = Integer.parseInt(req.getParameter("pid"));
        Product p = new ProductDAO().getProduct(pid);
        OrderItem oi = new OrderItem();
        oi.setProduct(p);
        oi.setNum(num);

        List<OrderItem> ois = (List<OrderItem>) req.getSession().getAttribute("ois");

        if (null == ois) {
            ois = new ArrayList<>();
            req.getSession().setAttribute("ois", ois);
        }

        boolean found = false;
        for (OrderItem orderItem : ois) {
            if (orderItem.getProduct().getId() == oi.getProduct().getId()) {
                orderItem.setNum(orderItem.getNum() + oi.getNum());
                found = true;
                break;
            }
        }
        if (found != true) {
            ois.add(oi);
        }
        resp.sendRedirect("/listOrderItem");

    }
}
