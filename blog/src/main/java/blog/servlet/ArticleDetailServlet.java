package blog.servlet;

import blog.dao.ArticleDAO;
import blog.exception.BusinessException;
import blog.exception.ClientException;
import blog.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@WebServlet("/articleDetail")
public class ArticleDetailServlet  extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取请求数据中的id（文章id）
        String id = req.getParameter("id");
        Integer articleId;
        try {
            articleId = Integer.parseInt(id);
        }catch (Exception e){
            throw new ClientException("001","请求参数错误[id= "+id+"]");
        }
        Article article = ArticleDAO.query(articleId);
        if(article == null){
            throw new BusinessException("002","查询不到文章详情id = "+articleId);
        }
        return  article;//测试代码，以后替换为数据库根据文章id查询文章操作
    }
//    public static Article testData(){
//        Article a1 = new Article();
//        a1.setId(1);
//        a1.setTitle("Title");
//        a1.setContent("寒江孤影");
//        a1.setUserId(1);
//        a1.setCreateTime(new Date());
//        return a1;
//    }
}
