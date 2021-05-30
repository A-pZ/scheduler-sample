package com.github.apz.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.apz.model.Task;

@Mapper
public interface TaskMapper {
	@Insert("INSERT INTO task (id, count) VALUES (#{id}, #{count})")
	public void register(@Param("id") String id, @Param("count") Integer count);
	
	@Select("SELECT count FROM task WHERE id = #{id}")
	public Optional<Integer> findById(@Param("id") String id);
	
	@Delete("DELETE FROM task where id = #{id}")
	public void delete(@Param("id") String id);
	
	@Select("SELECT id, count FROM task")
	public List<Task> findAll();
}
