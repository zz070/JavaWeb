package blog.util;

import blog.model.Article;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Date;

public class JSONUtilTest {
    @Test
    public void t1(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Article article = new Article();
            article.setId(1);
            article.setTitle("Title");
            article.setContent("寒江孤影");
            article.setUserId(1);
            article.setCreateTime(new Date());
            //将对象序列化为json字符串
            String s = mapper.writeValueAsString(article);
            System.out.println(s);
            //将json字符串反序列化为java对象
            Article des = mapper.readValue(s,Article.class);
            System.out.println(des);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
