package net.gondor.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class View11stServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public View11stServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Document doc = null;
		doc = Jsoup.connect("http://www.11st.co.kr/html/bestSellerMain9.html").
				get();
		Elements bestGoods = doc.select("div.pub_photo > a > span > img");
		
		StringBuffer images = new StringBuffer();
		
		for(Element goods : bestGoods){
			images.append("<div style='display:inline-block;'>"+goods.toString()+"</div>");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/view.jsp");
		request.setAttribute("images", images.toString());
		rd.forward(request, response);
	}

}
