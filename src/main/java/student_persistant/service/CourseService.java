package student_persistant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_persistant.model.CourseBean;
import student_persistant.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository repo;

	public int insertData(CourseBean course) {
		return repo.insertData(course);
	}

	public int updateData(CourseBean course) {
		return repo.updateData(course);
	}

	public int deleteData(int id) {
		return repo.deleteData(id);
	}

	public CourseBean selectOne(int id) {
		return repo.selectOne(id);
	}

	public List<CourseBean> selectAll() {
		return repo.selectAll();
	}
}
