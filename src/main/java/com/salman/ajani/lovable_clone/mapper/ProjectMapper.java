package com.salman.ajani.lovable_clone.mapper;

import com.salman.ajani.lovable_clone.dto.project.ProjectResponse;
import com.salman.ajani.lovable_clone.dto.project.ProjectSummaryResponse;
import com.salman.ajani.lovable_clone.entity.Project;
import com.salman.ajani.lovable_clone.enums.ProjectRole;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponseDto(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project, ProjectRole role);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);

}
