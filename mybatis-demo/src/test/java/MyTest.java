import com.weizz5.mybatis.bean.Emp;
import com.weizz5.mybatis.dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/06/02
 */
public class MyTest {

    @Test
    public void test01() throws IOException {

        String resource ="mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);

        Emp emp = mapper.select(1);

        System.out.println(emp );

        sqlSession.close();
    }
}
