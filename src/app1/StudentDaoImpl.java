package app1;

import org.apache.ibatis.session.SqlSession;
import util.MybatisUtil;

public class StudentDaoImpl {

    /**
     * 增加学生
     */
    public void add1() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            //事务自动开启
            sqlSession.insert("studentNameSpace.add1");
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //事务回滚
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }

    /**
     * 添加学生
     * @param student 封装学生信息的对象
     */
    public void add2(Student student) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            //事务自动开启
            sqlSession.insert("studentNameSpace.add2",student);
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //事务回滚
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }

    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        //studentDao.add1();
        studentDao.add2(new Student(2,"嘻嘻",5000D));
    }
}
