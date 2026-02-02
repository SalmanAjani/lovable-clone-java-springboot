package com.salman.ajani.lovable_clone.service;

import com.salman.ajani.lovable_clone.dto.project.FileContentResponse;
import com.salman.ajani.lovable_clone.dto.project.FileNode;

import java.util.List;

public interface ProjectFileService {
    List<FileNode> getFileTree(Long projectId);

    FileContentResponse getFileContent(Long projectId, String path);

    void saveFile(Long projectId, String filePath, String fileContent);
}
