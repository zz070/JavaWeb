package blog.servlet;

import blog.dao.ArticleDAO;
import blog.exception.BusinessException;
import blog.model.Article;
import blog.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet  extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       //文章修改：包含id,title,content
        InputStream is = req.getInputStream();
        //http请求Content-Type为application/json,请求体是json字符串，需要反序列化为java对象
        //需要检查json字符串的键，必须和java类型中的属性，能匹配
        // 如果json中的字段在Java类型中没有，就抛异常
        Article article = JSONUtil.deserialize(is,Article.class);
        //模拟数据库修改数据操作
        System.out.println("================================\n"+article);
        int num = ArticleDAO.update(article);
        if(num != 1){
            throw new BusinessException("004","文章修改出错");
        }
        return null;
    }
}
