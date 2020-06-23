package servlet;

import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OrderDAO;
import dao.OrderItemDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderCreateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u = (User) req.getSession().getAttribute("user");
        if (null == u) {
            resp.sendRedirect("/login.jsp");
            return;
        }

        List<OrderItem> ois = (List<OrderItem>) req.getSession().getAttribute("ois");

        if (null == ois) {
            return;
        } else {
            Order o = new Order();
            o.setUser(u);
            new OrderDAO().insert(o);

            for (OrderItem orderItem : ois) {
                orderItem.setOrder(o);
                new OrderItemDAO().insert(orderItem);
            }
            ois.clear();
            resp.setHeader("content-type", "text/html;charset=UTF-8");
            resp.getWriter().println("订单创建成功");
        }

    }

    public static void main(String[] args){
        HttpServletRequest request = null;
        OrderItem o = new OrderItem();
        o.setId(10);
        request.setAttribute("ois",o);

    }


}

