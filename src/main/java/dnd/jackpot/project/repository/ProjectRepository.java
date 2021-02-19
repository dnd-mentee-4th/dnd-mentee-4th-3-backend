package dnd.jackpot.project.repository;

import java.util.List;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import dnd.jackpot.project.entity.ERegion;
import dnd.jackpot.project.entity.Einterest;
import dnd.jackpot.project.entity.Estack;
import dnd.jackpot.project.entity.Project;
import dnd.jackpot.user.User;

public interface ProjectRepository extends JpaRepository<Project, Long>, JpaSpecificationExecutor<Project>{
//	프로젝트가 잘 업로드 및 불러오나 보기위해 일단 
	Page<Project> findAll(Pageable pageable);

	@Transactional(readOnly=true)
	@Query("SELECT p FROM Project p "
			+ "JOIN p.stack s "
			+ "JOIN p.interest i "
			+ "WHERE ((:region is null) OR (p.region in :region)) "
			+ "AND ((:interest is null) OR (i.interest in :interest)) "
			+ "AND ((:stack is null) OR (s.stack in :stack))")
	Page<Project> findByRegionInAndInterestInAndStackIn(@Param("region")List<ERegion> region, 
			@Param("interest")List<Einterest> interest, @Param("stack")List<Estack>stack, Pageable pageable);
	

	List<Project> findAllByRegionIn(List<ERegion> region);
	
	List<Project> findAllByAuthor(User Author);
}

