package dnd.jackpot.project.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import dnd.jackpot.project.entity.ERegion;
import dnd.jackpot.user.User;
import dnd.jackpot.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProjectDto {
	private Long id = 0L;
	private String shortDesc="";
	private List<String> stacks = new ArrayList<>();
	private List<String> interests = new ArrayList<>();
	private List<String> position = new ArrayList<>();
	private String title = "";
	private String createdDateTime;
	private ERegion region;
	private String recruitmentPeriod;
	private String online;
	private String duration;
	private long userIndex;
	private int scrapUsers;
	private List<CommentDto.getAll> comments = new ArrayList<>();

	
}
