package student_persistant.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import student_persistant.model.CourseBean;
import student_persistant.service.JPAUtil;

@Repository
public class CourseRepository {
	
	public int insertData(CourseBean course) {
		int i = 0;
		EntityManager em = null;
		try {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(course);
			em.getTransaction().commit();
			i = 1;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());

		} finally {
			em.close();
		}
		return i;
	}
	
	public int updateData(CourseBean course) {
		EntityManager em = null;
		int i = 0;
		try {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			
			CourseBean bean = em.find(CourseBean.class, course.getId());
			bean.setName(course.getName());
			bean.setPrice(course.getPrice());
			em.merge(bean);
			em.getTransaction().commit();
			i = 1;

		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());

		} finally {
			em.close();
		}
		return i;
	}
	
	public int deleteData(int id) {
		EntityManager em = null;
		int i = 0;
		try {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();

			CourseBean bean = em.find(CourseBean.class, id);

			em.remove(bean);
			em.getTransaction().commit();
			i = 1;

		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());

		} finally {
			em.close();
		}
		return i;
	}
	
	public CourseBean selectOne(int id) {
		EntityManager em = null;
		CourseBean course = null;
		try {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();

			course = em.createQuery("SELECT c FROM CourseBean c WHERE c.id=:c.id", CourseBean.class)
					.setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());

		} finally {
			em.close();
		}
		return course;
	}
	
	public List<CourseBean> selectAll() {
		EntityManager em = null;
		List<CourseBean> lstCourse = null;
		try {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();

			lstCourse = em.createQuery("SELECT c FROM CourseBean c", CourseBean.class).getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());

		} finally {
			em.close();
		}
		return lstCourse;
	}
}
