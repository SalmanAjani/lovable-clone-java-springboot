package com.salman.ajani.lovable_clone.mapper;

import com.salman.ajani.lovable_clone.dto.project.ProjectResponse;
import com.salman.ajani.lovable_clone.dto.project.ProjectSummaryResponse;
import com.salman.ajani.lovable_clone.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponseDto(Project project);

    @Mapping(target = "projectName", source = "name")
    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);

}
