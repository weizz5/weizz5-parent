import com.alibaba.fastjson.JSON;
import com.weizz5.mybatis.bean.Emp;
import com.weizz5.mybatis.dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/06/02
 */
public class MyTest {

    private Logger logger = Logger.getLogger(MyTest.class);
    private SqlSession sqlSession;

    private EmpDao empDao;
    @Before
    public void init(){
        String resource ="mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


//        System.out.println(JSON.toJSONString(sqlSessionFactory.getConfiguration().getEnvironment().getId()));
        sqlSession = sqlSessionFactory.openSession(true);
        empDao = sqlSession.getMapper(EmpDao.class);
    }

    @After
    public void destory(){
        sqlSession.close();
    }

    @Test
    public void test01()  {
//        System.out.println(JSON.toJSONString(sqlSession.getConfiguration().getMapperRegistry().getMappers()));
//        System.out.println(JSON.toJSONString(sqlSession.getConfiguration().getMapperRegistry().getMapper(EmpDao.class,sqlSession)));
//        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
//        System.out.println(JSON.toJSONString(mapper));
        Emp emp = empDao.query(1);
//        Integer emp = mapper.delete(232);

        logger.info(emp );
    }

    @Test
    public void queryAllTest()  {
        List<Emp> emp = empDao.queryAll();
        logger.info(emp );
    }

    @Test
    public void queryRangeTest()  {
        Map<String, Emp> emp = empDao.queryByRange();
        logger.info(emp.size()+",key:"+emp.keySet()+","+emp );
    }

    @Test
    public void test02(){
        Emp emp = new Emp();
        emp.setEmpno(14);
        emp.setEname("lisi");
        Integer count = empDao.save(emp);
//        sqlSession.commit();
        logger.info(count);

    }


    @Test
    public void update(){
        Emp emp = new Emp();
        emp.setEmpno(14);
        emp.setEname("wanger");
        emp.setSal("3000");
        Integer count = empDao.update(emp);
//        sqlSession.commit();
        logger.info(count);

    }


    @Test
    public void delete(){
        Emp emp = new Emp();
        emp.setEmpno(14);
        emp.setEname("wanger");
        emp.setSal("3000");
        Integer count = empDao.delete(14);
//        sqlSession.commit();
        logger.info(count);

    }



}
