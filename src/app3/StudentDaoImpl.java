package app3;

import org.apache.ibatis.session.SqlSession;
import util.MybatisUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl {

    /**
     * 增加学生
     */
    public void add(Student student) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            sqlSession.insert(Student.class.getName() + ".add", student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }


    public List<Student> findAllWithPage(int start,int end) {
        SqlSession sqlSession;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            Map<String,Integer> map = new LinkedHashMap<>();
            map.put("start",start);
            map.put("end",end);
            return sqlSession.selectList(Student.class.getName()+".findAllWithPage",map);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }


    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
//        for(int i = 1;i<14;i++){
//            studentDao.add(new Student(i,"嘻嘻"+i,1000D));
//        }
        List<Student> studentList = studentDao.findAllWithPage(1, 3);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
