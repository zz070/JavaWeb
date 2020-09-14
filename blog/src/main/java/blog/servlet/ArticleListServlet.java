package blog.servlet;

import blog.dao.ArticleDAO;
import blog.model.Article;
import blog.model.Result;
import blog.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Article> articles = ArticleDAO.list();
        return articles;
//        return testData();
    }

//    //测试数据
//    public static List<Article> testData(){
//        List<Article> articles = new ArrayList<>();
//        Article a1 = new Article();
//        a1.setId(1);
//        a1.setTitle("Title");
//        a1.setContent("寒江孤影");
//        a1.setUserId(1);
//        a1.setCreateTime(new Date());
//        Article a2 = new Article();
//        a2.setId(2);
//        a2.setTitle("Title2");
//        a2.setContent("寒江孤影,江湖故人");
//        a2.setUserId(1);
//        a2.setCreateTime(new Date());
//        articles.add(a1);
//        articles.add(a2);
//        return articles;
//    }
}

