package blog.servlet;

import blog.model.Article;
import blog.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       InputStream is = req.getInputStream();
       //http请求Content-Type为application/json,请求体是json字符串，需要反序列化为java对象
        //需要检查json字符串的键，必须和java类型中的属性，能匹配
        // 如果json中的字段在Java类型中没有，就抛异常
        //文章新增：包括title，content，userAccout
        Article article = JSONUtil.deserialize(is,Article.class);
        //模拟数据库插入数据操作
        System.out.println("================================\n"+article);
        return null;
    }
}
