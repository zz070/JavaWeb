package blog.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //ids = 1,2,3
        String idsString = req.getParameter("ids");
        int[] ids = parseIds(idsString);
        //把ids传到数据库作删除操作
        return null;
    }
    public static int[] parseIds(String idsString){//1,2,3
        String[] idsArray = idsString.split(",");//["1","2","3']
        int[] ids = new int[idsArray.length];
        for(int i =0;i<idsArray.length;i++){
            ids[i] = Integer.parseInt(idsArray[i]);//[1,2,3]
        }
        return ids;
    }
}
