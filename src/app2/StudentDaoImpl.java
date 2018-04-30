package app2;

import org.apache.ibatis.session.SqlSession;
import util.MybatisUtil;

import java.util.List;

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

    /**
     * 根据id查询学生
     */
    public Student findById(int id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            return sqlSession.selectOne(Student.class.getName() + ".findById", id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }

    /**
     * 查询所有学生
     */
    public List<Student> findAll() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            return sqlSession.selectList(Student.class.getName() + ".findAll");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }

    /**
     * 更新学生
     */
    public void update(Student student) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            sqlSession.update(Student.class.getName()+".update",student);
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

    /**
     * 删除学生
     */
    public void delte(Student student) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            sqlSession.delete(Student.class.getName()+".delete",student);
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

    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
//        studentDao.add(new Student(1,"嘻嘻",5000D));
//        studentDao.add(new Student(2,"哈哈",6000D));
//        studentDao.add(new Student(3,"嘿嘿",7000D));
//        studentDao.add(new Student(4,"呵呵",8000D));
//        Student student = studentDao.findById(4);
//        System.out.println(student);
//        List<Student> studentList = studentDao.findAll();
//        for (Student student : studentList) {
//            System.out.println(student);
//        }
//        student.setSal(20000D);
//        studentDao.update(student);
//        studentDao.delte(student);
    }
}
