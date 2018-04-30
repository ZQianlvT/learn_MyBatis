package app4;

import org.apache.ibatis.session.SqlSession;
import util.MybatisUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl {

    /**
     * 动态查询全部学生
     */
    public List<Student> dynaFindAll(Integer id,String name, Double sal) {
        SqlSession sqlSession;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("id",id);
            map.put("name",name);
            map.put("sal",sal);
            return sqlSession.selectList(Student.class.getName()+".dynaFindAll",map);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }

    /**
     * 动态更新学生
     */
    public void dynaUpdate(Integer id,String name, Double sal) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("id",id);
            map.put("name",name);
            map.put("sal",sal);
            sqlSession.update(Student.class.getName()+".dynaUpdate",map);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(sqlSession!=null)
                sqlSession.rollback();
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }

    /**
     * 动态删除学生
     */
    public void dynaDelete(int... ids) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            sqlSession.delete(Student.class.getName()+".dynaDelete",ids);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(sqlSession!=null)
                sqlSession.rollback();
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }

    /**
     * 动态插入学生
     */
    public void dynaInsert(Student student) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            sqlSession.insert(Student.class.getName()+".dynaInsert",student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(sqlSession!=null)
                sqlSession.rollback();
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }

    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
//        studentDao.dynaUpdate(2,"呵呵",3000D);
//        for(int i = 1;i<14;i++){
//            studentDao.add(new Student(i,"嘻嘻"+i,1000D));
//        }
//       studentDao.dynaDelete(1,3,4);
        studentDao.dynaInsert(new Student(3,"嘿嘿ie",null));
        List<Student> studentList = studentDao.dynaFindAll(null,null,null);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
