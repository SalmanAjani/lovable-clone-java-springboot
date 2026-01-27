package com.salman.ajani.lovable_clone.service.impl;

import com.salman.ajani.lovable_clone.dto.project.ProjectRequest;
import com.salman.ajani.lovable_clone.dto.project.ProjectResponse;
import com.salman.ajani.lovable_clone.dto.project.ProjectSummaryResponse;
import com.salman.ajani.lovable_clone.entity.Project;
import com.salman.ajani.lovable_clone.entity.ProjectMember;
import com.salman.ajani.lovable_clone.entity.ProjectMemberId;
import com.salman.ajani.lovable_clone.entity.User;
import com.salman.ajani.lovable_clone.enums.ProjectRole;
import com.salman.ajani.lovable_clone.error.BadRequestException;
import com.salman.ajani.lovable_clone.error.ResourceNotFoundException;
import com.salman.ajani.lovable_clone.mapper.ProjectMapper;
import com.salman.ajani.lovable_clone.repository.ProjectMemberRepository;
import com.salman.ajani.lovable_clone.repository.ProjectRepository;
import com.salman.ajani.lovable_clone.repository.UserRepository;
import com.salman.ajani.lovable_clone.security.AuthUtil;
import com.salman.ajani.lovable_clone.service.ProjectService;
import com.salman.ajani.lovable_clone.service.SubscriptionService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;
    AuthUtil authUtil;
    SubscriptionService subscriptionService;

    @Override
    public ProjectResponse createProject(ProjectRequest request) {

        if (!subscriptionService.canCreateNewProject()) {
            throw new BadRequestException("User cannot create new project with current plan. Upgrade plan now.");
        }

        Long userId = authUtil.getCurrentUserId();

//        User owner = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", userId.toString()));

        User owner = userRepository.getReferenceById(userId);

        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();

        project = projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);

        return projectMapper.toProjectResponseDto(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects() {

//        return projectRepository.findAllAccessibleByUser(userId)
//                .stream()
//                .map(projectMapper::toProjectSummaryResponse)
//                .collect(Collectors.toList());

        Long userId = authUtil.getCurrentUserId();

        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);

    }

    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")
    public ProjectResponse getUserProjectById(Long projectId) {
        Long userId = authUtil.getCurrentUserId();

        Project project = getAccessibleProjectById(projectId, userId);
        return projectMapper.toProjectResponseDto(project);
    }

    @Override
    @PreAuthorize("@security.canEditProject(#projectId)")
    public ProjectResponse updateProject(Long projectId, ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();

        Project project = getAccessibleProjectById(projectId, userId);

        project.setName(request.name());
        project = projectRepository.save(project);

        return projectMapper.toProjectResponseDto(project);
    }

    @Override
    @PreAuthorize("@security.canDeleteProject(#projectId)")
    public void softDelete(Long projectId) {
        Long userId = authUtil.getCurrentUserId();

        Project project = getAccessibleProjectById(projectId, userId);

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    // Internal Functions
    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));
    }
}
